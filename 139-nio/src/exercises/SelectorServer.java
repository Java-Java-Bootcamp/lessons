package exercises;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Slf4j
public class SelectorServer {
    final static int DEFAULT_PORT = 7777;

    static CharBuffer charBuffer = CharBuffer.allocate(250);

    public static void main(String[] args) throws IOException {
        List<String> quotes = Files.readAllLines(Paths.get("thoughts.txt"));
        Selector selector = configureSelector(args);

        while (true) {
            int n = selector.select();
            if (n == 0)
                continue;
            Iterator it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                if (key.isAcceptable()) {
                    SocketChannel channel;
                    channel = ((ServerSocketChannel) key.channel()).accept();
                    if (channel == null) {
                        continue;
                    }
                    log.info("Receiving connection");
                    charBuffer.clear();
                    charBuffer.put(quotes.get(new Random().nextInt(quotes.size())));
                    charBuffer.flip();
                    log.info("Writing current time");
                    while (charBuffer.hasRemaining()) {
                        channel.write(StandardCharsets.UTF_8.encode(charBuffer));
                    }
                    channel.close();
                }
                it.remove();
            }
        }
    }

    private static Selector configureSelector(String[] args) throws IOException {
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
        return selector;
    }
}