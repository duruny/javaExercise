package com.socket.web;

import com.jetty.http.config.ServerConfig;
import com.socket.web.function.IFunction;
import com.socket.web.handler.BaseWebSocketServerHandler;
import com.util.LogUtils;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * WebSocket服务
 * 
 */
public class WebSocketServer {
	private static WebSocketServer server;

	private WebSocketServer() {
	}

	// 单例
	public static WebSocketServer getInstance() {
		if (server == null) {
			server = new WebSocketServer();
		}
		return server;
	}

	/**
	 * 启动web
	 */
	public void start(final IFunction<BaseWebSocketServerHandler> function) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<Channel>() {

						@Override
						protected void initChannel(Channel channel) throws Exception {
							((MaxMessagesRecvByteBufAllocator) channel.config().getRecvByteBufAllocator())
									.maxMessagesPerRead(1024 * 1024);
							ChannelPipeline pipeline = channel.pipeline();
							pipeline.addLast("http-codec", new HttpServerCodec()); // Http消息编码解码
							pipeline.addLast("aggregator", new HttpObjectAggregator(65536)); // Http消息组装
							pipeline.addLast("http-chunked", new ChunkedWriteHandler()); // WebSocket通信支持
							pipeline.addLast("handler", function.execute()); // WebSocket服务端Handler
						}
					});

			Channel channel = b.bind(ServerConfig.getSocketPort()).sync().channel();
			LogUtils.info("WebSocket 已经启动，端口：" + ServerConfig.getSocketPort() + ".");
			channel.closeFuture().sync();
		} catch (Exception e) {
			LogUtils.error("webSocket start error!", e);
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

}
