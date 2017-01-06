/**
 * 
 */
package com.fz.thread.classification;

import com.fz.thread.CallableWithArgs;
import com.fz.util.HUtils;
import com.fz.util.SparkUtils;
import com.fz.util.Utils;
import org.apache.hadoop.fs.Path;

/**
 * logistic regression
 * @author fansy
 * @date 2017-1-1
 */
public class LogisticCallable implements CallableWithArgs {

    private String appName = "Logistic Regression Train Model ";
    private String className = "com.fz.classification.LogisticRegression";
//	com.fz.classification.LogisticRegression
// testOrNot input minPartitions output targetIndex splitter method hasIntercept numClasses
	private String testOrNot;
    private String input;
	private String minPartitions;
	private String output;
	private String targetIndex;
	private String splitter;
	private String method;
    private String hasIntercept;
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
                method,
                hasIntercept,
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
			Utils.simpleLog("Logistic Regression 提交任务错误！");
		}
        return null;
	}

	@Override
	public void setArgs(String[] args) {
//		testOrNot input minPartitions output targetIndex splitter method hasIntercept numClasses
		this.testOrNot = "false";
        this.input=args[0];
        this.minPartitions=args[1];
		this.output=args[2];
        this.targetIndex=args[3];
		this.splitter=args[4];
        this.method=args[5];
        this.hasIntercept=args[6];
        this.numClasses=args[7];
	}

}
