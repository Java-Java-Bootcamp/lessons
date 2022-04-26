package demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadFactoryDemo {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3,
                runnable -> new Thread(runnable, "Custom thread"));

        executor.execute(() -> {
            log.info("Working...");
        });
    }
}


