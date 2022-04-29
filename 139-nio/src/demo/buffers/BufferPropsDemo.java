package demo.buffers;

import lombok.extern.slf4j.Slf4j;

import java.nio.Buffer;
import java.nio.ByteBuffer;

@Slf4j
public class BufferPropsDemo
{
   public static void main(String[] args)
   {
      ByteBuffer buffer = ByteBuffer.allocate(7);
      log.info("Capacity: {}", buffer.capacity());
      log.info("Limit: {}", buffer.limit());
      log.info("Position: {}", buffer.position());
      log.info("Remaining: {}", buffer.remaining());
      log.info("Changing buffer limit to 5");
      buffer.limit(5);
      log.info("Limit: {}", buffer.limit());
      log.info("Position: {}", buffer.position());
      log.info("Remaining: {}", buffer.remaining());
      log.info("Changing buffer position to 3");
      buffer.position(3);
      log.info("Limit: {}", buffer.limit());
      log.info("Position: {}", buffer.position());
      log.info("Remaining: {}", buffer.remaining());
      log.info("Buffer: {}", buffer);

      buffer.limit(7);
      buffer.position(0);
      for (int i = 0; i < buffer.limit(); i++) {
         buffer.put((byte) 10);
      }

      buffer.limit(5);

      buffer.flip();
      log.info("Buffer: {}", buffer);
      while (buffer.hasRemaining()) {
         log.info("{}", buffer.get());
      }

      log.info("Limit to 7");
      buffer.limit(10);
      log.info("Buffer: {}", buffer);
      while (buffer.hasRemaining()) {
         log.info("{}", buffer.get());
      }
   }
}