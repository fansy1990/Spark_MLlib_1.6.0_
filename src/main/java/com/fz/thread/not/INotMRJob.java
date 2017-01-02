/**
 * 
 */
package com.fz.thread.not;

import java.util.Map;

/**
 * 提交非MR任务的基类
 * @author fansy
 * @date 2015年8月5日
 */
public interface INotMRJob {

	public void setArgs(String[] args);
	
	public Map<String,Object> runJob();
}
