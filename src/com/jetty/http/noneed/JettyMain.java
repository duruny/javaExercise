package com.jetty.http.noneed;

import com.alibaba.fastjson.JSON;
import com.jetty.http.HttpClient;
import com.jetty.http.config.ServerConfig;
import com.jetty.http.entity.HttpRequestMsg;
import com.jetty.http.entity.HttpResponseMsg;
import com.socket.web.WebSocketServer;
import com.socket.web.function.IFunction;
import com.socket.web.handler.BaseWebSocketServerHandler;
import com.socket.web.handler.H5WebSocketHandler;
import com.util.LogUtils;
import com.util.PropertyConfigUtil;

/**
 * @author jianpeng.zhang
 * @since 2017/3/14.
 */
public class JettyMain {
	public static void main(String[] args) throws Exception {
		LogUtils.logConfigure();

		PropertyConfigUtil.init(ServerConfig.class.getPackage());

		// 启动jetty
		// WebServer.getInstance().startHttp(new WebHandler());

		// 启动WebSocket=>H5
		WebSocketServer.getInstance().start(new IFunction<BaseWebSocketServerHandler>() {
			@Override
			public BaseWebSocketServerHandler execute(Object... params) {
				return new H5WebSocketHandler();
			}
		});

		String url = "http://localhost:8081/web/api/reload";
		HttpRequestMsg<String[]> requestMsg = new HttpRequestMsg<>("111", new String[] { "sdsdf", "wers" });

		HttpResponseMsg<String> responseMsg = HttpClient.get(url, requestMsg);
		if (responseMsg != null) {
			System.out.println(JSON.toJSONString(responseMsg.convertBody(String.class)));
		}
	}
}
