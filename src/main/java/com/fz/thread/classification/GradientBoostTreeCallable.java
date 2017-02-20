/**
 * 
 */
package com.fz.thread.classification;

import com.fz.thread.CallableWithArgs;
import com.fz.utils.HUtils;
import com.fz.utils.SparkUtils;
import com.fz.utils.Utils;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gradient Boost tree classification and regression
 * @author fansy
 * @date 2017-2-16
 */
public class GradientBoostTreeCallable implements CallableWithArgs {
    private Logger log = LoggerFactory.getLogger(GradientBoostTreeCallable.class);
    private String appName = "Gradient Boost Tree Train Model ";
    private String className = "com.fz.classification.CustomGradientBoostedTrees";

//    testOrNot input minPartitions output targetIndex " +
//    "splitter algo lossType numIteration  maxDepth [numClasses]
	private String testOrNot;
    private String input;
	private String minPartitions;
	private String output;
	private String targetIndex;
	private String splitter;
	private String lossType;
    private String maxDepth;
    private String numIteration;
    private String algo;
    private String numClasses;


    @Override
	public String call() {
		
		String[] args=new String[]{
                testOrNot,
				input,
                minPartitions,
                output,
                targetIndex,
                splitter,
                algo,
                lossType,
                numIteration,
                maxDepth,
                numClasses
		};
		
		Utils.printStringArr(args);
		try {
            // 在每个算法里面自己删除自己的输出目录，而不是在算法里面去删除输出目录
			HUtils.getFs().delete(new Path(output), true);
			String[] runArgs = SparkUtils.constructArgs(appName,className,args);
            String jobId = SparkUtils.runSpark(runArgs);//

            return jobId;

		} catch (Exception e) {
			e.printStackTrace();
			log.warn(appName + " 提交任务错误！");
		}
        return null;
	}

	@Override
	public void setArgs(String[] args) {
//    testOrNot input minPartitions output targetIndex " +
//    "splitter algo lossType numIteration  maxDepth [numClasses]
		this.testOrNot = "false";
        this.input=args[0];
        this.minPartitions=args[1];
		this.output=args[2];
        this.targetIndex=args[3];
		this.splitter=args[4];
        this.algo=args[5];
        this.lossType=args[6];
        this.numIteration=args[7];
        this.maxDepth = args[8];
        this.numClasses = args[9];
	}

}
