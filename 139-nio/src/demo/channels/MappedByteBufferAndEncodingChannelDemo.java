package demo.channels;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Slf4j
public class MappedByteBufferAndEncodingChannelDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("thoughts.txt", "r");
        FileChannel fc = raf.getChannel();
        long size = fc.size();
        log.info("Size: {}", size);
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, size);

        StringBuilder contentBuilder = new StringBuilder();
        while (mbb.hasRemaining()) {
            contentBuilder.append((char) mbb.get());
        }

        log.info("Content: \n {}", contentBuilder);

        mbb.flip();
        StringBuilder decodedContentBuilder = new StringBuilder();
        CharBuffer decodedContent = StandardCharsets.UTF_8.decode(mbb);
        while (decodedContent.remaining() > 0) {
            decodedContentBuilder.append(decodedContent.get());
        }
        fc.close();

        log.info("Decoded content: \n {}", decodedContentBuilder);
    }
}