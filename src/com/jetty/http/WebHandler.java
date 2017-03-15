package com.jetty.http;

import com.jetty.http.entity.HttpRequestMsg;
import com.jetty.http.entity.HttpResponseMsg;
import com.jetty.http.entity.RequestMapping;

@RequestMapping("/api")
public class WebHandler extends AbstractWebHandler
{

	/**
	 * 刷新
	 */
	@RequestMapping("/reload")
	public HttpResponseMsg<?> reload(HttpRequestMsg<String[]> reqMsg) {

		HttpResponseMsg responseMsg = checkClientInfo(reqMsg.getSessionId());
		if (responseMsg != null)
		{
			return responseMsg;
		}

		String[] reloadModules = reqMsg.convertBody(String[].class);
		return new HttpResponseMsg<>();
	}

	@Override
	public HttpResponseMsg<?> checkClientInfo(String sessionId) {
		return null;
	}
}
