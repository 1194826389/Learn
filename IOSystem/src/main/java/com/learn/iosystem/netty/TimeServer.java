package com.learn.iosystem.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by hechao on 2017/4/23.
 */
public class TimeServer {
    public void bind(int port) throws Exception {
        // 配置服务端的NIO线程组
        // NioEventLoopGroup是个线程组，它包含了一组NIO线程，专门用于网络事件的处理，实际上他们就是Reactor线程组。这里创建的两个的原因是一个用于服务端接受客户端的连接，另一个用于进行SocketChannel的网络读写。
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // ServerBootstrap对象是netty用于启动NIO服务器的富足启动类，
            // 目的是降低服务器的开发复杂度。通过调用group方法，
            // 将两个NIO线程组当做参数传递给ServerBootstrap中，
            // 接着设置创建的Channel为NioServerSocketChannel,
            // 它的功能对应于JDK Nio类库中的NioServerSocketChannel类。
            // 然后配置NioServerSocketChannel的TCP参数，此处将他的backlog设置为1024，
            // 最后绑定I/O事件的处理类，它的作用类似于Reactor模式中的handle类，主要用于处理网络IO事件，例如记录日志，对消息进行编解码等。
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());
            // 绑定端口，同步等待成功
            // 服务器启动辅助类配置完成之后，
            // 调用它的bind方法绑定监听端口，
            // 随后调用它的同步阻塞方法sync等待绑定操作完成。
            // 完成之后netty会返回一个CHannelFuture,它的功能类似于JDK的java.util.concurrent.Future,主要用于异步操作的通知回调
            ChannelFuture  f = b.bind(port).sync();

            // 等待服务器监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }
}
