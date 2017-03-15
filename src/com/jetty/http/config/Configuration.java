package com.jetty.http.config;

import java.lang.annotation.*;

/**
 * 配置常量
 * @author jason.lin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Configuration
{

	/**
	 * 配置位置
	 * @return
	 */
	String config();
}
