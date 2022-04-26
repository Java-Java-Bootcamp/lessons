package demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
public class PrecreatedThreadsDemo {
    public static void main(String[] args) {
        Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
        Executor fixedThreadPool = Executors.newFixedThreadPool(3);
        Executor cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(new Programmer("Dev " + i));
        }

        log.info("Go home");
    }
}

@Slf4j
@RequiredArgsConstructor
class Programmer implements Runnable {
    private final String name;
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 8; i++) {
            boolean working = random.nextBoolean();
            log.info("{}: It is {} hour", name, i);
            if (working) {
                log.info("{}: Working", name);
            } else {
                log.info("{}: Drinking coffee", name);
            }
        }
    }
}
