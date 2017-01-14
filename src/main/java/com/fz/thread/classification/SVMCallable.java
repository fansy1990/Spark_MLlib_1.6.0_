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
 * svm classification
 * @author fansy
 * @date 2017-1-9
 */
public class SVMCallable implements CallableWithArgs {
    private Logger log = LoggerFactory.getLogger(SVMCallable.class);
    private String appName = "SVM Classification Train Model ";
    private String className = "com.fz.classification.SVM";
//	com.fz.classification.SVM
// testOrNot input minPartitions output targetIndex "
//    "splitter numIteration stepSize regParam miniBatchFraction regMethod"
	private String testOrNot;
    private String input;
	private String minPartitions;
	private String output;
	private String targetIndex;
	private String splitter;
	private String numIteration;
    private String stepSize;

    public String getRegParam() {
        return regParam;
    }

    public void setRegParam(String regParam) {
        this.regParam = regParam;
    }

    public String getStepSize() {
        return stepSize;
    }

    public void setStepSize(String stepSize) {
        this.stepSize = stepSize;
    }

    public String getNumIteration() {
        return numIteration;
    }

    public void setNumIteration(String numIteration) {
        this.numIteration = numIteration;
    }

    public String getMiniBatchFraction() {
        return miniBatchFraction;
    }

    public void setMiniBatchFraction(String miniBatchFraction) {
        this.miniBatchFraction = miniBatchFraction;
    }

    public String getRegMethod() {
        return regMethod;
    }

    public void setRegMethod(String regMethod) {
        this.regMethod = regMethod;
    }

    private String regParam;
    private String miniBatchFraction;
    private String regMethod;

    @Override
	public String call() {
		
		String[] args=new String[]{
                testOrNot,
				input,
                minPartitions,
                output,
                targetIndex,
                splitter,
                numIteration,
                stepSize,
                regParam,
                miniBatchFraction,
                regMethod
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
// testOrNot input minPartitions output targetIndex "
//    "splitter numIteration stepSize regParam miniBatchFraction regMethod"
		this.testOrNot = "false";
        this.input=args[0];
        this.minPartitions=args[1];
		this.output=args[2];
        this.targetIndex=args[3];
		this.splitter=args[4];
        this.numIteration=args[5];
        this.stepSize=args[6];
        this.regParam=args[7];
        this.miniBatchFraction = args[8];
        this.regMethod = args[9];
	}

}
