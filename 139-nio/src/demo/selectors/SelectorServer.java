package demo.selectors;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

@Slf4j
public class SelectorServer
{
   final static int DEFAULT_PORT = 7777;

   static ByteBuffer bb = ByteBuffer.allocateDirect(8);

   public static void main(String[] args) throws IOException
   {
      int port = DEFAULT_PORT;
      if (args.length > 0)    
         port = Integer.parseInt(args[0]);
      log.info("Server starting ... listening on port {}", port);
      
      ServerSocketChannel ssc = ServerSocketChannel.open();
      ServerSocket ss = ssc.socket();
      ss.bind(new InetSocketAddress(port));
      ssc.configureBlocking(false);

      Selector selector = Selector.open();
      ssc.register(selector, SelectionKey.OP_ACCEPT);

      while (true)
      {
         int n = selector.select();
         if (n == 0)
            continue;
         Iterator it = selector.selectedKeys().iterator();
         while (it.hasNext())
         {
            SelectionKey key = (SelectionKey) it.next();
            if (key.isAcceptable())
            {
               SocketChannel channel;
               channel = ((ServerSocketChannel) key.channel()).accept();
               if (channel == null)
                  continue;
               log.info("Receiving connection");
               bb.clear();
               bb.putLong(System.currentTimeMillis());
               bb.flip();
               log.info("Writing current time");
               while (bb.hasRemaining())
                  channel.write(bb);
               channel.close();
            }
            it.remove();
         }
      }
   }
}