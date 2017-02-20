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
 * Random Forest classification and regression
 * @author fansy
 * @date 2017-2-20
 */
public class RandomForestCallable implements CallableWithArgs {
    private Logger log = LoggerFactory.getLogger(RandomForestCallable.class);
    private String appName = "Random Forest Train Model ";
    private String className = "com.fz.classification.CustomRandomForest";

//    testOrNot input minPartitions output targetIndex " +
 //           "splitter algo impurity maxDepth  maxBins numTrees [numClasses]<numClass only for classification>
	private String testOrNot;
    private String input;
	private String minPartitions;
	private String output;
	private String targetIndex;
	private String splitter;
	private String impurity;
    private String maxDepth;
    private String algo;
    private String maxBins;
    private String numClasses;
    private String numTrees;


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
                impurity,
                maxDepth,

                maxBins,
                numTrees,
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
        //           "splitter algo impurity maxDepth  maxBins numTrees [numClasses]<numClass only for classification>
		this.testOrNot = "false";
        this.input=args[0];
        this.minPartitions=args[1];
		this.output=args[2];
        this.targetIndex=args[3];
		this.splitter=args[4];
        this.algo = args[5];
        this.impurity=args[6];
        this.maxDepth=args[7];
        this.maxBins = args[8];
        this.numTrees = args[9];
        this.numClasses = args[10];
	}

}
