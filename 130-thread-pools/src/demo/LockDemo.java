package demo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockDemo {
    private static int counter = 0;

    private static ReentrantLock lock = new ReentrantLock();

    @SneakyThrows
    public static void main(String[] args) {
        Runnable increment = () -> {
            for (int i = 0; i < 100_000; i++) {
                lock.lock();
                counter++;
                lock.unlock();
            }
        };
        List<Thread> threads = List.of(
                new Thread(increment),
                new Thread(increment),
                new Thread(increment)
        );

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        log.info("Counter: {}", counter);
    }
}
