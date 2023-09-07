package com.shouxin.yy.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.CharsetUtil;

/**
 * @author feikong
 * @time 2023/9/6 10:11 下午
 */
public class OutboundHandler2 extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ByteBuf data = (ByteBuf) msg;
        System.out.println("OutboundHandler2 write: " + data.toString(CharsetUtil.UTF_8));
        ctx.write(Unpooled.copiedBuffer("OutboundHandler2: " + data.toString(CharsetUtil.UTF_8), CharsetUtil.UTF_8));
        ctx.flush();
    }
}
