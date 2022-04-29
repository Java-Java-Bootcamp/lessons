package demo.buffers;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

@Slf4j
public class ByteBufferDemo
{
   public static void main(String[] args)
   {
      ByteBuffer buffer = ByteBuffer.allocate(7);
      log.info("Capacity: {}", buffer.capacity());
      log.info("Limit: {}", buffer.limit());
      log.info("Position: {}", buffer.position());
      log.info("Remaining: {}", buffer.remaining());

      buffer.put((byte) 10).put((byte) 20).put((byte) 30);

      log.info("Capacity: {}", buffer.capacity());
      log.info("Limit: {}", buffer.limit());
      log.info("Position: {}", buffer.position());
      log.info("Remaining: {}", buffer.remaining());

      for (int i = 0; i < buffer.position(); i++) {
         log.info("Buffers {}'s value: {}", i, buffer.get(i));
      }

      log.info("Buffer: {}", buffer);
   }
}