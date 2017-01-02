/**
 * 
 */
package com.fz.thread;

/**
 * 带有参数的Runnable接口
 * @author fansy
 * @date 2015-8-4
 */
public interface RunnableWithArgs extends Runnable {

	public abstract void setArgs(String[] args);
}
