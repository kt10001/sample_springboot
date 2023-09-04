package com.shouxin.yy.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author feikong
 * @time 2023/9/3 2:28 下午
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客户端发送过来的消息
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("server receive msg: " + byteBuf.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channelReadComplete");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("server exceptionCaught: " + cause.getMessage());
        ctx.close();
    }
}
