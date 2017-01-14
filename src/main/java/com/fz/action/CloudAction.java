/**
 * 
 */
package com.fz.action;

import com.alibaba.fastjson.JSON;
import com.fz.model.JobInfo;
import com.fz.service.CurrentJobInfoService;
import com.fz.thread.CallableWithArgs;
import com.fz.thread.not.INotMRJob;
import com.fz.utils.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * @author fansy
 * @date 2015-8-4
 */
@Component("cloudAction")
public class CloudAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = LoggerFactory.getLogger(CloudAction.class);
	private String algorithm; // 算法, 实例化的类名 ,如 classification.LogisticCallable

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public CurrentJobInfoService getCurrentJobInfoService() {
        return currentJobInfoService;
    }

    public void setCurrentJobInfoService(CurrentJobInfoService currentJobInfoService) {
        this.currentJobInfoService = currentJobInfoService;
    }

    @Resource
    private CurrentJobInfoService currentJobInfoService;

    // 算法页面参数,每个页面不超过11个参数,如果超过，则需要修改
	private String arg1; 
	private String arg2;
	private String arg3;
	private String arg4;
	private String arg5;
	private String arg6;
	private String arg7;
	private String arg8;
	private String arg9;
	private String arg10;
	private String arg11;
		


	/**
	 * 提交与HDFS交互的任务
	 * 算法具体参数意思对照jsp页面理解，每个实体类会把arg1~arg11 转换为实际的意思
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void submitJobNotMR() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Map<String ,Object> map = new HashMap<String,Object>();
		INotMRJob runJob = (INotMRJob) Utils.getClassByName(
				Utils.THREADNOTPACKAGES+algorithm);
		// 2.2 设置参数
		runJob.setArgs(new String[]{arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11});
		map= runJob.runJob();
		
		Utils.write2PrintWriter(JSON.toJSONString(map));
		return ;
	}
	
	/**
	 * 提交Spark 任务的Job
	 * 任务提交成功并存入数据库则返回成功，否则返回false
	 */
	public void submitSparkJob(){
		Map<String ,Object> map = new HashMap<String,Object>();
		try {
			// 2. 使用Thread的方式启动Spark任务
			// 2.1 生成Callable接口
			CallableWithArgs<String> runJob = (CallableWithArgs) Utils.getClassByName(
					Utils.THREADPACKAGES+algorithm);
			// 2.2 设置参数
			runJob.setArgs(new String[]{arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11});
			// 2.3 启动Thread
            Future<String> future = executorService.submit(runJob);
			// 3. 启动成功后，获取返回的数据；等待20秒还没有返回，那么默认任务提交失败
            String result = null;
            int i= 0;
            while (true){
                if (future.isDone()) {
                    try {
                        result = future.get();
                        log.info("算法："+algorithm+"被成功提交，其任务ID是："+result);
                        break;
                    } catch (InterruptedException e) {
                        // ignored
                    } catch (ExecutionException e) {
                        // ignored
                    }
                }
                if(i>=Utils.SUBMIT2APPIDTIMEOUT){
                    log.warn("已过"+Utils.SUBMIT2APPIDTIMEOUT+"秒提交周期，集群资源不足或网络异常!");
                    break;
                }
                Thread.sleep(1000);
                i++;
            }

            if(result == null || "".equals(result)){// 任务失败
//                map.put("flag", "false");
//                map.put("msg", "任务提交失败！");
                // 每个页面提示信息的div id是 该算法的名字，其实也是类名
                Utils.updateMap(map,"false","任务提交失败",Utils.algorithm2ShowId(algorithm)+"_id");
            }else{// 任务成功
//                map.put("flag","true");
//                map.put("msg", "任务提交成功，其ID为："+ result);
                Utils.updateMap(map,"true","任务提交成功，其ID为："+ result,
                        Utils.algorithm2ShowId(algorithm)+"_id");
                // 写数据到数据库中，JobID相关，任务状态为Submitted
                if(!currentJobInfoService.save(new JobInfo(result))){
//                    map.put("flag","false");
//                    map.put("msg","提交任务成功，但是把相关数据存入数据库失败，请查看后台日志！");
                    Utils.updateMap(map,"false","提交任务成功，但是把相关数据存入数据库失败，请查看后台日志！",
                            Utils.algorithm2ShowId(algorithm)+"_id");
                }
            }

		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("msg", "任务启动失败！");
            Utils.updateMap(map,"false","任务启动失败！",
                    Utils.algorithm2ShowId(algorithm)+"_id");
		}
        Utils.print(map);
		Utils.write2PrintWriter(JSON.toJSONString(map));
	}




	public String getAlgorithm() {
		return algorithm;
	}


	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}


	public String getArg1() {
		return arg1;
	}


	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}


	public String getArg2() {
		return arg2;
	}


	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}


	public String getArg3() {
		return arg3;
	}


	public void setArg3(String arg3) {
		this.arg3 = arg3;
	}


	public String getArg4() {
		return arg4;
	}


	public void setArg4(String arg4) {
		this.arg4 = arg4;
	}


	public String getArg5() {
		return arg5;
	}


	public void setArg5(String arg5) {
		this.arg5 = arg5;
	}


	public String getArg6() {
		return arg6;
	}


	public void setArg6(String arg6) {
		this.arg6 = arg6;
	}


	public String getArg7() {
		return arg7;
	}


	public void setArg7(String arg7) {
		this.arg7 = arg7;
	}


	public String getArg8() {
		return arg8;
	}


	public void setArg8(String arg8) {
		this.arg8 = arg8;
	}


	public String getArg9() {
		return arg9;
	}


	public void setArg9(String arg9) {
		this.arg9 = arg9;
	}


	public String getArg10() {
		return arg10;
	}


	public void setArg10(String arg10) {
		this.arg10 = arg10;
	}


	public String getArg11() {
		return arg11;
	}


	public void setArg11(String arg11) {
		this.arg11 = arg11;
	}

}
