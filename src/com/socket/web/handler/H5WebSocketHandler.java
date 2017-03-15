package com.socket.web.handler;

import com.util.LogUtils;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

public class H5WebSocketHandler extends BaseWebSocketServerHandler {

	public H5WebSocketHandler() {
		super("webSocket");
	}

	public H5WebSocketHandler(String path) {
		super(path);
	}

	@Override
	public void handleTextMsg(ChannelHandlerContext ctx, String msg) {
		LogUtils.error("收到消息：" + msg);
	}

	@Override
	public void connect(ChannelHandlerContext ctx, FullHttpRequest request) {
		LogUtils.error("链接成功：" + ctx.channel().id());

	}

	@Override
	public void close(ChannelHandlerContext ctx, WebSocketFrame frame) {
		LogUtils.error("关闭链接：" + ctx.channel().id());

	}
}
