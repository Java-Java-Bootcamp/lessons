package ru.otus.javabootcamp.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Server {

  private static Logger logger = LoggerFactory.getLogger(Server.class);

  public static void main(String[] args) throws InterruptedException {
    final EventLoopGroup eventLoopGroup = new NioEventLoopGroup(2);
    final Handler handler = new Handler();

    try {

      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap.group(eventLoopGroup)
          .channel(NioServerSocketChannel.class)
          .localAddress(new InetSocketAddress(8080))
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
              ch.pipeline().addLast(handler);
            }
          });

      logger.info("Starting server");

      ChannelFuture future = bootstrap.bind().sync();
      future.channel().closeFuture().sync();
    } finally {
      eventLoopGroup.shutdownGracefully().sync();
    }
  }
}
