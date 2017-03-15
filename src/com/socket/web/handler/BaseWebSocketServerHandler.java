package com.socket.web.handler;

import com.util.LogUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

import static io.netty.handler.codec.http.HttpHeaderNames.HOST;

/**
 * webSocket处理器
 * 
 * @author jason.lin
 */
public abstract class BaseWebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
	// webSocket访问路径
	private String basePath;

	private WebSocketServerHandshaker handShaker;

	public BaseWebSocketServerHandler(String path) {
		this.basePath = path;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof FullHttpRequest) {
			// 处理握手协议
			handleHttpRequest(ctx, (FullHttpRequest) msg);

		} else if (msg instanceof WebSocketFrame) {
			// 正常通信
			handleWebSocketFrame(ctx, (WebSocketFrame) msg);
		}
	}

	/**
	 * 正常通信
	 */
	public void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
		if (frame instanceof CloseWebSocketFrame) {
			handShaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
			close(ctx, frame);
			return;
		}

		if (frame instanceof PingWebSocketFrame) {
			ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
			return;
		}

		if (frame instanceof TextWebSocketFrame) {
			String msg = ((TextWebSocketFrame) frame).text();
			handleTextMsg(ctx, msg);
		}
	}

	/**
	 * 关闭链接
	 */
	public abstract void close(ChannelHandlerContext ctx, WebSocketFrame frame);

	/**
	 * 处理文本消息
	 */
	public abstract void handleTextMsg(ChannelHandlerContext ctx, String msg);

	/**
	 * 处理握手协议
	 */
	public void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
		// 如果HTTP解码失败，返回HHTP异常
		if (!request.decoderResult().isSuccess() || (!"webSocket".equals(request.headers().get("Upgrade")))) {
			sendHttpResponse(ctx, request,
					new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
			return;
		}

		WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(getWebSocketLocation(request),
				null, true);
		handShaker = wsFactory.newHandshaker(request);
		if (handShaker == null) {
			WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
		} else {
			// 握手成功之后,业务逻辑 注册
			ChannelFuture channelFuture = handShaker.handshake(ctx.channel(), request);

			LogUtils.info("handleHttpRequest result: " + channelFuture.isSuccess());

			// 连接成功
			if (channelFuture.isSuccess()) {
				connect(ctx, request);
			}
		}
	}

	/**
	 * 连接成功
	 */
	public abstract void connect(ChannelHandlerContext ctx, FullHttpRequest request);

	/**
	 * 发送响应码
	 */
	public void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res) {
		if (res.status().code() != 200) {
			ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
			res.content().writeBytes(buf);
			buf.release();
			HttpUtil.setContentLength(res, res.content().readableBytes());
		}

		ChannelFuture f = ctx.channel().writeAndFlush(res);
		if (!HttpUtil.isKeepAlive(req) || res.status().code() != 200) {
			f.addListener(ChannelFutureListener.CLOSE);
		}
	}

	/**
	 * 组装webSocket完整路径
	 * 
	 */
	public String getWebSocketLocation(FullHttpRequest req) {
		String location = req.headers().get(HOST) + basePath;
		return "ws://" + location;
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// 当出现异常就关闭连接
		Channel incoming = ctx.channel();
		LogUtils.error("Client:" + incoming.remoteAddress() + "异常", cause);
		ctx.close();

	}

}
