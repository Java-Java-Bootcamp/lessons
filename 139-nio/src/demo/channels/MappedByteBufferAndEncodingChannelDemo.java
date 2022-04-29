package demo.channels;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

@Slf4j
public class MappedByteBufferAndEncodingChannelDemo
{
   public static void main(String[] args) throws IOException
   {
      RandomAccessFile raf = new RandomAccessFile("thoughts.txt", "rw");
      FileChannel fc = raf.getChannel();
      long size = fc.size();
      log.info("Size: {}", size);
      MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0,
                                    size);
      while (mbb.remaining() > 0) {
         System.out.print((char) mbb.get());
      }
      for (int i = 0; i < mbb.limit() / 2; i++)
      {
         byte b1 = mbb.get(i);
         byte b2 = mbb.get(mbb.limit() - i - 1);
         mbb.put(i, b2);
         mbb.put(mbb.limit() - i - 1, b1);
      }
      mbb.flip();
      StringBuilder contentBuilder = new StringBuilder();
      CharBuffer decodedContent = Charset.forName("UTF-8").decode(mbb);
      while (decodedContent.remaining() > 0) {
         contentBuilder.append(decodedContent.get());
      }
      fc.close();

      log.info("{}", contentBuilder);
   }
}