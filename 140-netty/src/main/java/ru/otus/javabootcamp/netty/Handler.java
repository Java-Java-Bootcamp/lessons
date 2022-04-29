package ru.otus.javabootcamp.netty;

import static java.lang.Thread.sleep;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Sharable
public class Handler extends ChannelInboundHandlerAdapter {

  private static final Logger log = LoggerFactory.getLogger(Handler.class);

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    log.info("channelRead");
    ByteBuf buf = (ByteBuf) msg;
    String text = buf.toString(CharsetUtil.UTF_8).trim();
    log.info("Received: {}", text);

    if ("exit".equals(text.toLowerCase())) {
      ctx.close();
    } else if ("sleep".equals(text.toLowerCase())) {
      try {
        sleep(20000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
      ctx.write(msg);
    }
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) {
    log.info("channelReadComplete");
    ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    log.error("error", cause);
    ctx.close();
  }
}
