package demo.channels;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class FileChannelDemo
{
   public static void main(String[] args) throws IOException
   {
      RandomAccessFile raf = new RandomAccessFile("temp", "rw");
      FileChannel fc = raf.getChannel();
      long pos;
      log.info("Position = {}", (pos = fc.position()));
      log.info("size: {}", fc.size());

//      String msg = "This is a test message.";

      ByteBuffer buffer = ByteBuffer.allocateDirect(200);
      /*buffer.asCharBuffer()
              .put(msg);

      fc.write(buffer);
      fc.force(true);

      log.info("position: {}", fc.position());
      log.info("size: {}", fc.size());*/

      // File read
      buffer.clear();
      fc.position(pos);
      fc.read(buffer);

      buffer.flip();
      StringBuilder contentBuilder = new StringBuilder();
      while (buffer.hasRemaining()) {
         contentBuilder.append(buffer.getChar());
      }

      log.info("Content: {}", contentBuilder);
   }
}