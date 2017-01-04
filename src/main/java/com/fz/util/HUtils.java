/**
 * 
 */
package com.fz.util;

import com.fz.model.JobInfo;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile.Reader;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobStatus;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.*;
import java.util.*;


/**
 * Hadoop 工具类
 * 
 * @author fansy
 * @date 2015-5-28
 */
public class HUtils {


    private static final String DOWNLOAD_EXTENSION = ".dat";
    private static Configuration conf = null;
	private static FileSystem fs = null;




	private static JobClient jobClient = null;
	
	public static final String HDFSPRE= "/user/algorithm/input";
	public static final String LOCALPRE= "../../src/main/data/";

    /**
     * 修改完数据库需要更新Configuration
     */
    public static void updateConfiguration(){
        conf = null;
        getConf();
    }

	public static Configuration getConf() {

		if (conf == null) {
//            // 设置 提交任务系统版本，需要在，这种设置不行，提示UninLoginModel少包
//            System.setProperty("os.name",Utils.getKey("os.name",Utils.dbOrFile));
			conf = new Configuration();
			// get configuration from db or file
			conf.setBoolean("mapreduce.app-submission.cross-platform", "true"
					.equals(Utils.getKey(
							"mapreduce.app-submission.cross-platform", Utils.dbOrFile)));// 配置使用跨平台提交任务
			conf.set("fs.defaultFS", Utils.getKey("fs.defaultFS", Utils.dbOrFile));// 指定namenode
			conf.set("mapreduce.framework.name",
					Utils.getKey("mapreduce.framework.name", Utils.dbOrFile)); // 指定使用yarn框架
			conf.set("yarn.resourcemanager.address",
					Utils.getKey("yarn.resourcemanager.address", Utils.dbOrFile)); // 指定resourcemanager
			conf.set("yarn.resourcemanager.scheduler.address", Utils.getKey(
					"yarn.resourcemanager.scheduler.address", Utils.dbOrFile));// 指定资源分配器
			conf.set("mapreduce.jobhistory.address",
					Utils.getKey("mapreduce.jobhistory.address", Utils.dbOrFile));

            /**
             * CDH 集群远程提交Spark任务到YARN集群，出现
             * java.lang.NoClassDefFoundError: org/apache/hadoop/conf/Configuration
             * 异常，需要设置mapreduce.application.classpath 参数 或
             * yarn.application.classpath 参数
             */
            switch (Utils.getKey("platform",Utils.dbOrFile)){
                case "apache" : conf.set("yarn.application.classpath",
                        Utils.getKey("apache.yarn.application.classpath",Utils.dbOrFile));break;
                case "cdh" :conf.set("yarn.application.classpath",
                        Utils.getKey("cdh.yarn.application.classpath",Utils.dbOrFile));break;
                case "hdp" :conf.set("yarn.application.classpath",
                        Utils.getKey("hdp.yarn.application.classpath",Utils.dbOrFile));break;
                default: Utils.simpleLog("由于platform不是apahce/cdh/hdp，所以不设置yarn.application.classpath参数");
            }

		}

		return conf;
	}

	public static FileSystem getFs() {
		if (fs == null) {
			try {
				fs = FileSystem.get(getConf());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fs;
	}

	/**
	 * 获取hdfs文件目录及其子文件夹信息
	 * 
	 * @param input
	 * @param recursive
	 * @return
	 * @throws java.io.IOException
	 */
	public static String getHdfsFiles(String input, boolean recursive)
			throws IOException {
		RemoteIterator<LocatedFileStatus> files = getFs().listFiles(
				new Path(input), recursive);
		StringBuffer buff = new StringBuffer();
		while (files.hasNext()) {
			buff.append(files.next().getPath().toString()).append("<br>");
		}

		return buff.toString();
	}


	public static void printJobStatus(JobStatus js) {
		System.out.println(new Date() + ":jobId:"
				+ js.getJobID().toString() + ",map:" + js.getMapProgress()
				+ ",reduce:" + js.getReduceProgress() + ",finish:"
				+ js.getRunState());
	}

	/**
	 * @return the jobClient
	 */
	public static JobClient getJobClient() {
		if (jobClient == null) {
			try {
				jobClient = new JobClient(getConf());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jobClient;
	}

	/**
	 * @param jobClient
	 *            the jobClient to set
	 */
	public static void setJobClient(JobClient jobClient) {
		HUtils.jobClient = jobClient;
	}

	/**
	 * 判断一组MR任务是否完成
	 *
	 * @param currentJobInfo
	 * @return
	 */
	public static String hasFinished(JobInfo currentJobInfo) {

		if (currentJobInfo != null) {
			if ("SUCCEEDED".equals(currentJobInfo.getRunState())) {
				return "success";
			}
			if ("FAILED".equals(currentJobInfo.getRunState())) {
				return "fail";
			}
			if ("KILLED".equals(currentJobInfo.getRunState())) {
				return "kill";
			}
		}

		return "running";
	}

	/**
	 * 返回HDFS路径
	 *
	 * @param url
	 * @return fs.defaultFs+url
	 */
	public static Path getPath(String url) {

		return new Path(url);
	}

	/**
	 * 获得hdfs全路径
	 * @param url
	 * @return
	 */
	public static String getFullHDFS(String url){
		return Utils.getKey("fs.defaultFS", Utils.dbOrFile) + url;
	}
	/**
	 * 上传本地文件到HFDS
	 * 如果hdfs文件存在则覆盖
	 *
	 * @param localPath
	 * @param hdfsPath
	 * @return
	 */
	public static Map<String, Object> upload(String localPath, String hdfsPath) {
		Map<String, Object> ret = new HashMap<String, Object>();
		FileSystem fs = getFs();
		Path src = new Path(localPath);
		Path dst = new Path(hdfsPath);
		ret.put("return_show", "upload_return");
		try {
			fs.copyFromLocalFile(src, dst);
			ret.put("return_txt", localPath+"上传至"+hdfsPath+"成功");
			Utils.simpleLog(localPath+"上传至"+hdfsPath+"成功");
		} catch (Exception e) {
			ret.put("flag", "false");
			ret.put("msg", e.getMessage());
			e.printStackTrace();
			return ret;
		}
		ret.put("flag", "true");
		ret.put("msg", "HDFS:'"+hdfsPath+"'");
		return ret;
	}

	/**
	 * 删除HFDS文件或者文件夹
	 *
	 * @param hdfsFolder
	 * @return
	 */
	public static boolean delete(String hdfsFolder) {
		try {
			getFs().delete(getPath(hdfsFolder), true);
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 下载文件
	 * @param hdfsPath
	 * @param localPath
	 *            ,本地文件夹
	 * @return
	 */
	public static Map<String, Object> downLoad(String hdfsPath, String localPath) {
		Map<String, Object> ret = new HashMap<String, Object>();
		FileSystem fs = getFs();
		Path src = new Path(hdfsPath);
		Path dst = new Path(localPath);
		try {
			RemoteIterator<LocatedFileStatus> fss = fs.listFiles(src, true);
			int i = 0;
			while (fss.hasNext()) {
				LocatedFileStatus file = fss.next();
				if (file.isFile() && file.toString().contains("part")) {
					// 使用这个才能下载成功
					fs.copyToLocalFile(false, file.getPath(), new Path(dst,
							"hdfs_" + (i++) + HUtils.DOWNLOAD_EXTENSION), true);
				}
			}
		} catch (Exception e) {
			ret.put("flag", "false");
			ret.put("msg", e.getMessage());
			e.printStackTrace();
			return ret;
		}
		ret.put("flag", "true");
		return ret;
	}

	/**
	 * 移动文件
	 *
	 * @param hdfsPath
	 * @param desHdfsPath
	 * @return
	 */
	public static boolean mv(String hdfsPath, String desHdfsPath) {

		return false;
	}

	/**
	 * 读取HDFS文件并写入本地
	 *
	 * @param url
	 * @param localPath
	 */
	public static void readHDFSFile(String url, String localPath) {
		Path path = new Path(url);
		// Configuration conf = HUtils.getConf();
		FileWriter writer = null;
		BufferedWriter bw = null;
		InputStream in = null;
		try {
			writer = new FileWriter(localPath);
			bw = new BufferedWriter(writer);
			// FileSystem fs = FileSystem.get(URI.create(url), conf);
			FileSystem fs = getFs();
			in = fs.open(path);
			BufferedReader read = new BufferedReader(new InputStreamReader(in));
			String line = null;

			while ((line = read.readLine()) != null) {
				// System.out.println("result:"+line.trim());
				// [5.5,4.2,1.4,0.2] 5,0.3464101615137755
				String[] lines = line.split("\t");
				bw.write(lines[1]);
				bw.newLine();
			}
			System.out.println(new Date() + "ds file:" + localPath);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				bw.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 按照行数读取txt文件，并返回字符串
	 * @param input
	 * @param lines
	 * @param splitter : 每行数据的分隔符
	 * @return
	 * @throws Exception
	 */
	public static String readTxt(String input,String lines,String splitter) throws Exception{
		StringBuffer buff = new StringBuffer();
		Path path = new Path(input);
		long lineNum= Long.parseLong(lines);
		InputStream in = null;
		try {
			FileSystem fs = getFs();
			in = fs.open(path);
			BufferedReader read = new BufferedReader(new InputStreamReader(in));
			String line = null;

			while ((line = read.readLine()) != null&&lineNum-->0) {
				buff.append(line).append(splitter);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}
		return buff.toString();
	}

	/**
	 * 读取给定序列文件的前面k条记录
	 * @param input
	 * @param k
	 * @return
	 */
	public static Map<Object, Object> readSeq(String input, int k) {
		Map<Object,Object> map= new HashMap<Object,Object>();
		Path path = HUtils.getPath(input);
		Configuration conf = HUtils.getConf();
		Reader reader = null;
		try {
			reader = new Reader(conf, Reader.file(path),
					Reader.bufferSize(4096), Reader.start(0));
			Writable dkey =  (Writable) ReflectionUtils
					.newInstance(reader.getKeyClass(), conf);
			Writable dvalue =  (Writable) ReflectionUtils
					.newInstance(reader.getValueClass(), conf);

			while (reader.next(dkey, dvalue)&&k>0) {// 循环读取文件
				// 使用这个进行克隆
				map.put(WritableUtils.clone(dkey, conf),WritableUtils.clone( dvalue,conf));
				k--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeStream(reader);
		}
		return map;
	}

	/**
	 *
	 * @param input
	 * @param output
	 */
	public static void copy(String input, String output) {
		FileSystem fs =getFs();
		Configuration conf = getConf();
		Path in= new Path(input);
		Path out= new Path(output);

		try{
			if(fs.exists(out)){//如果存在则删除
				fs.delete(out, true);
			}
//			fs.create(out);// 新建
			fs.mkdirs(out);
			FileStatus[] files=fs.listStatus(in);
			Path[] srcs= new Path[files.length];
			for(int i=0;i<files.length;i++){
				srcs[i]=files[i].getPath();
			}
			boolean flag =FileUtil.copy(fs,srcs,fs,out,false,true,conf);
			Utils.simpleLog("数据从"+input.toString()+"传输到"+out.toString()+
					(flag?"成功":"失败")+"!");
		}catch(Exception e){
			e.printStackTrace();
			Utils.simpleLog("数据从"+input.toString()+"传输到"+out.toString()+
					"失败"+"!");
		}
	}


}
