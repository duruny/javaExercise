package com.jetty.http;


import com.jetty.http.entity.HttpResponseMsg;

/**
 * http接口基类
 * @author jason.lin
 *
 */
public abstract class AbstractWebHandler
{
    public abstract HttpResponseMsg<?> checkClientInfo(String sessionId);
}
