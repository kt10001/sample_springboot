package com.shouxin.yy.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author feikong
 * @time 2023/9/3 2:28 下午
 */
public class EchoClient {
    private int port;
    private String host;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 启动流程
     */
    public void start() {
        // 配置服务端线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建服务端的启动对象
            Bootstrap bootstrap = new Bootstrap();
            // 设置参数
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            // 启动
            System.out.println("echo client run...");
            ChannelFuture channelFuture = bootstrap.connect().sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 优雅退出，释放线程组
            group.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        new EchoClient("127.0.0.1", 8080).start();
    }
}
