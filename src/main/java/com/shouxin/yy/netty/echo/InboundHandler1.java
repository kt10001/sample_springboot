package com.shouxin.yy.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author feikong
 * @time 2023/9/6 9:53 下午
 */
public class InboundHandler1 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf data = (ByteBuf) msg;
        System.out.println("InboundHandler1 channelRead 服务端接受到数据: " + data.toString(CharsetUtil.UTF_8));
        // 执行下一个InboundHandler
        ctx.fireChannelRead(Unpooled.copiedBuffer("InboundHandler1: " + data.toString(CharsetUtil.UTF_8), CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
