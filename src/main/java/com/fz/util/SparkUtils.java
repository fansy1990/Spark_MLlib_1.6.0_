package com.fz.util;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.spark.SparkConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.spark.deploy.yarn.Client;
import org.apache.spark.deploy.yarn.ClientArguments;

import java.io.IOException;

/**
 * Spark 任务提交
 * Created by fanzhe on 2017/1/2.
 */
public class SparkUtils {
    private static Logger log = LoggerFactory.getLogger(SparkUtils.class);
    /**
     * 调用Spark 加入监控模块
     *
     * @param args
     * @return Application ID字符串
     */
    public static String runSpark(String[] args) {
        StringBuffer buff = new StringBuffer();

        for(String arg:args){
            buff.append(arg).append(",");
        }
        log.info("runSpark args:"+buff.toString());
        ApplicationId appId = null;
        try {
            System.setProperty("SPARK_YARN_MODE", "true");
            SparkConf sparkConf = new SparkConf();
            sparkConf.set("spark.yarn.jar", Utils.getKey("spark.yarn.jar", Utils.dbOrFile));
            sparkConf.set("spark.yarn.scheduler.heartbeat.interval-ms",
                    Utils.getKey("spark.yarn.scheduler.heartbeat.interval-ms", Utils.dbOrFile));
            // classnotfound 异常
//            sparkConf.set("spark.yarn.dist.archives",Utils.getKey("spark.yarn.dist.archives",Utils.dbOrFile));

            ClientArguments cArgs = new ClientArguments(args, sparkConf);

            Client client = new Client(cArgs, HUtils.getConf(), sparkConf);
            client.run();
            // client.run(); // 去掉此种调用方式，改为有下面的调用方式，这样可以返回jobID

             // 调用Spark

            try{
                appId = client.submitApplication();
            }catch(Throwable e){
                e.printStackTrace();
                // 清空临时文件
                cleanupStagingDir(appId);
                //  返回null
                return null;
            }
            return appId.toString();
        } catch (Exception e) {
            e.printStackTrace();
            // 清空临时文件
            cleanupStagingDir(appId);
            return null;
        }finally{
            cleanupStagingDir(appId);
        }
    }

    /**
     * 参考Spark实现删除相关文件代码
     *
     * TODO Tomcat关闭时，如果还有Spark程序还在运行，那么删除不了文件
     *
     * @param appId
     */
    public static void cleanupStagingDir(ApplicationId appId) {
        String appStagingDir = Client.SPARK_STAGING() + Path.SEPARATOR + appId.toString();

        try {
            Path stagingDirPath = new Path(appStagingDir);
            FileSystem fs = HUtils.getFs();
            if (fs.exists(stagingDirPath)) {
                log.info("Deleting staging directory " + stagingDirPath);
                fs.delete(stagingDirPath, true);
            }
        } catch (IOException e) {
            log.warn("Failed to cleanup staging dir " + appStagingDir, e);
        }
    }

    /**
     * 根据类参数构造Spark提交任务参数
     * @param classArgs
     * @return
     */
    public static String[] constructArgs(String appName, String className,String[] classArgs){
        String[] args = new String[14 + classArgs.length * 2];
        args[0]="--name";
        args[1]=appName;
        args[2]="--class";
        args[3]=className;
        args[4] = "--driver-memory";
        args[5] = Utils.getKey("spark.driver.memory",Utils.dbOrFile);
        args[6] = "--num-executors";
        args[7] = Utils.getKey("spark.num.executors",Utils.dbOrFile);
        args[8] = "--executor-memory";
        args[9] = Utils.getKey("spark.executor.memory",Utils.dbOrFile);
        args[10] = "--jar" ;
        args[11] = Utils.getKey("spark.jar",Utils.dbOrFile);
        args[12] = "--files" ;
        args[13] = Utils.getKey("spark.files",Utils.dbOrFile) ;
//        args[14] = "--archives" ;
//        args[15] = Utils.getKey("spark.yarn.dist.archives",Utils.dbOrFile) ;

        int j=14;
        for(int i= 0  ; i< classArgs.length; i++ ){
            args[j++] = "--arg";
            args[j++] = classArgs[i];
        }

//        String[] runArgs=new String[]{
//                "--name","ALS Model Train ",
//                "--class","als.ALSModelTrainer",
//                "--driver-memory","512m",
//                "--num-executors", "2",
//                "--executor-memory", "512m",
//                "--jar","hdfs://master:8020/user/root/Spark141-als.jar",//
//                "--files","hdfs://master:8020/user/root/yarn-site.xml",
//                "--arg",inputArgs[0],
//                "--arg",inputArgs[1],
//                "--arg",inputArgs[2],
//                "--arg",inputArgs[3],
//                "--arg",inputArgs[4],
//                "--arg",inputArgs[5]
//        };
        return args;
    }
}
