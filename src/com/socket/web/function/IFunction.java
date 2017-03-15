package com.socket.web.function;

/**
 * 方法
 * @author jason.lin
 *
 */
public interface IFunction<T> {
	/**
	 * 执行
	 * @param params
	 * @return
	 */
	public T execute(Object... params);
}
