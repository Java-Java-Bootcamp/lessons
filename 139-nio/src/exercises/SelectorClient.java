package exercises;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

@Slf4j
public class SelectorClient {
    final static int DEFAULT_PORT = 7777;

    static ByteBuffer byteBuffer = ByteBuffer.allocateDirect(500);

    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length > 0) port = Integer.parseInt(args[0]);

        try {
            SocketChannel sc = SocketChannel.open();
            InetSocketAddress addr = new InetSocketAddress("localhost", port);
            sc.connect(addr);

            while (sc.read(byteBuffer) != -1) {
                byteBuffer.flip();
            }

            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(byteBuffer);
            StringBuilder quoteBuilder = new StringBuilder();
            while (charBuffer.remaining() > 0) {
                quoteBuilder.append(charBuffer.get());
            }
            log.info("Got quote: {}", quoteBuilder);

            sc.close();
        } catch (IOException ioe) {
            log.error("I/O error: {}", ioe.getMessage());
        }
    }
}