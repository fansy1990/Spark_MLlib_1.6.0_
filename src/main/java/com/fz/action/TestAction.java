//package com.fz.action;
//
//import com.fz.service.TestService;
//import com.fz.util.HUtils;
//import com.fz.util.Utils;
//import com.opensymphony.xwork2.ActionSupport;
//import org.apache.hadoop.examples.WordCount;
//import org.apache.hadoop.examples.WordCount.IntSumReducer;
//import org.apache.hadoop.examples.WordCount.TokenizerMapper;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.ipc.RemoteException;
//import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
//import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//import org.apache.hadoop.util.GenericOptionsParser;
//import org.apache.struts2.ServletActionContext;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@Component("testAction")
//public class TestAction extends ActionSupport {
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//	@Resource
//	private TestService testService;
//	private String email;
//	private String name;
//
//	private String input;
//	private String output;
//
//	public String getEmail() {
//		return email;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void test(){
//		PrintWriter writer=null;
//		String info="name:"+name+",email:"+email;
//		System.out.println(info);
//		try{
//			writer= ServletActionContext.getResponse().getWriter();
//			writer.write(info);//响应输出
//			testService.saveUser();
//			//释放资源，关闭流
//			writer.flush();
//			writer.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//
//	}
//	/**
//	 * 获得给定hdfs目录的所有文件夹及子文件
//	 */
//	public void getHdfs(){
//		try {
//			String buff = testService.getHdfsFiles(input);
//			Utils.write2PrintWriter(buff);
//		} catch(RemoteException e){
//			Utils.write2PrintWriter(e.getLocalizedMessage());
//			e.printStackTrace();
//		}catch (IOException e) {
//			Utils.write2PrintWriter(e.getLocalizedMessage());
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * 运行WordCount MR任务
//	 */
//	public void runWordCount(){
//		String[] args={
//				input,output
//		};
//		try{
//		 String[] otherArgs = new GenericOptionsParser(HUtils.getConf(), args).getRemainingArgs();
//		    if (otherArgs.length < 2) {
//		      System.err.println("Usage: wordcount <in> [<in>...] <out>");
//		      System.exit(2);
//		    }
//		    Job job = Job.getInstance(HUtils.getConf());
//		    job.setJobName( "word count");
//		    job.setJarByClass(WordCount.class);
//		    job.setMapperClass(TokenizerMapper.class);
//		    job.setCombinerClass(IntSumReducer.class);
//		    job.setReducerClass(IntSumReducer.class);
//		    job.setOutputKeyClass(Text.class);
//		    job.setOutputValueClass(IntWritable.class);
//		    for (int i = 0; i < otherArgs.length - 1; ++i) {
//		      FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
//		    }
//		    FileOutputFormat.setOutputPath(job,
//		      new Path(otherArgs[otherArgs.length - 1]));
//		    boolean ret = job.waitForCompletion(true);
//		    if(ret){
//		    	Utils.write2PrintWriter(job.getJobID().toString()+"successed!");
//		    }else{
//		    	Utils.write2PrintWriter(job.getJobID().toString()+" failed!");
//		    }
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * @return the input
//	 */
//	public String getInput() {
//		return input;
//	}
//	/**
//	 * @param input the input to set
//	 */
//	public void setInput(String input) {
//		this.input = input;
//	}
//	/**
//	 * @return the output
//	 */
//	public String getOutput() {
//		return output;
//	}
//	/**
//	 * @param output the output to set
//	 */
//	public void setOutput(String output) {
//		this.output = output;
//	}
//
//}
