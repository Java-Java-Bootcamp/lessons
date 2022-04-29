package demo.selectors;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

@Slf4j
public class SelectorClient
{
   final static int DEFAULT_PORT = 7777;

   static ByteBuffer bb = ByteBuffer.allocateDirect(8);

   public static void main(String[] args)
   {
      int port = DEFAULT_PORT;
      if (args.length > 0)    
         port = Integer.parseInt(args[0]);

      try
      {
         SocketChannel sc = SocketChannel.open();
         InetSocketAddress addr = new InetSocketAddress("localhost", port);
         sc.connect(addr);

         long time = 0;
         while (sc.read(bb) != -1)
         {
            bb.flip();
            while (bb.hasRemaining())
            {
               time <<= 8;
               time |= bb.get() & 255;
            }
            bb.clear();
         }
         log.info("Got date: {}", new Date(time));

         sc.close();
      }     
      catch (IOException ioe)
      {
         log.error("I/O error: {}", ioe.getMessage());
      }
   }
}