package com.jetty.http.config;

@Configuration(config = "resources/serverConfig.properties")
public class ServerConfig {

	// jetty服务端口
	private static int httpPort;

	// webSocket的端口
	private static int socketPort;

	// jetty超时时间
	private static int timeOut;

	// jetty线程池最大线程数
	private static int maxThreads;

	// jetty线程池最小存活线程数
	private static int minThreads;

	public static int getHttpPort() {
		return httpPort;
	}

	public static void setHttpPort(int httpPort) {
		ServerConfig.httpPort = httpPort;
	}

	public static int getTimeOut()
	{
		return timeOut;
	}

	public static void setTimeOut(int timeOut)
	{
		ServerConfig.timeOut = timeOut;
	}

	public static int getMaxThreads()
	{
		return maxThreads;
	}

	public static void setMaxThreads(int maxThreads)
	{
		ServerConfig.maxThreads = maxThreads;
	}

	public static int getMinThreads()
	{
		return minThreads;
	}

	public static void setMinThreads(int minThreads)
	{
		ServerConfig.minThreads = minThreads;
	}

	public static int getSocketPort()
	{
		return socketPort;
	}

	public static void setSocketPort(int socketPort)
	{
		ServerConfig.socketPort = socketPort;
	}
}
