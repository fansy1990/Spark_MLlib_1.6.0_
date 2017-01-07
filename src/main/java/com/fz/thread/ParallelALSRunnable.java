/**
 * 
 */
package com.fz.thread;

import com.fz.utils.HUtils;
import com.fz.utils.Utils;
import org.apache.hadoop.fs.Path;
//import org.apache.mahout.cf.taste.hadoop.als.ParallelALSFactorizationJob;

/**
 * parallel als recommend
 * @author fansy
 * @date 2015-8-14
 */
public class ParallelALSRunnable implements RunnableWithArgs {
//	arg1:input,arg2:output,arg3:lambda,arg4:numFeatures,arg5:numIterations,
//	arg6:numThreadsPerSolver
	private String input;
	private String output;
	private String lambda;
	private String numFeatures;
	private String numIterations;
	private String numThreadsPerSolver;
	@Override
	public void run() {
		
		String[] args=new String[]{
				"-i",input,
				"-o",output,
				"--lambda",lambda,
//				 "--implicitFeedback", "?",
//				 "--alpha","?",
				 "--numFeatures",numFeatures,
				 "--numIterations",numIterations,
				 "--numThreadsPerSolver",numThreadsPerSolver,
				 "--tempDir","temp"
		};
		
		Utils.printStringArr(args);
		try {
			HUtils.getFs().delete(new Path("temp"), true);
			HUtils.getFs().delete(new Path(output), true);
			
			int ret = 0;
//            ret = ToolRunner.run(HUtils.getConf()	,new ParallelALSFactorizationJob()	, args);
			if(ret==0){// 所有任务运行完成
//				HUtils.setALLJOBSFINISHED(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 任务中，报错，需要在任务监控界面体现出来
//			HUtils.setRUNNINGJOBERROR(true);
			Utils.simpleLog("ParallelALSFactorizationJob任务错误！");
		}
	}

	@Override
	public void setArgs(String[] args) {
//		arg1:input,arg2:output,arg3:lambda,arg4:numFeatures,arg5:numIterations,
//		arg6:numThreadsPerSolver
		this.input=args[0];
		this.output=args[1];
		this.lambda=args[2];
		this.numFeatures=args[3];
		this.numIterations=args[4];
		this.numThreadsPerSolver=args[5];
	}

}
