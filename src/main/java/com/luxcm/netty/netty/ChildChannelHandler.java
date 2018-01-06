package com.luxcm.netty.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ServerChannel;

import java.nio.channels.SocketChannel;

public class ChildChannelHandler extends ChannelInitializer<ServerChannel>{


    protected void initChannel(ServerChannel serverChannel) throws Exception {
        serverChannel.pipeline().addLast(new TimeServerHandler());
    }
}
