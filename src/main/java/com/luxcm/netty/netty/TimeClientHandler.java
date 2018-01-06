package com.luxcm.netty.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.Charset;

public class TimeClientHandler extends ChannelHandlerAdapter {

    private final ByteBuf FIRST_MESSAGE;

    public TimeClientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        FIRST_MESSAGE = Unpooled.buffer(req.length);
        FIRST_MESSAGE.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(FIRST_MESSAGE);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, Charset.defaultCharset());
        System.out.println("Now is : " + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
