package demo.buffers;

import lombok.extern.slf4j.Slf4j;

import java.nio.Buffer;
import java.nio.ByteBuffer;

@Slf4j
public class BufferPropsDemo
{
   public static void main(String[] args)
   {
      Buffer buffer = ByteBuffer.allocate(7);
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
      log.info("Position: {}", buffer.position());
      log.info("Remaining: {}", buffer.remaining());
      log.info("Buffer: {}", buffer);
   }
}