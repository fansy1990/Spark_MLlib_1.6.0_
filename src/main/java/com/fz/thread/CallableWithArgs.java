/**
 * 
 */
package com.fz.thread;

import java.util.concurrent.Callable;

/**
 * 带有参数的Callable接口
 * @author fansy
 * @date 2017/01/01
 */
public interface CallableWithArgs<V> extends Callable<V> {

	public abstract void setArgs(String[] args);
}
