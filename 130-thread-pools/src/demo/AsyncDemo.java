package demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class AsyncDemo {
    public static void main(String[] args) {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(
                () -> "test"
        ).thenApplyAsync(s -> s + " test");

        String result = cf.join();

        log.info(result);

        //allOff
    }
}
