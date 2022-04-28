package demo;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TerminationDemo {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 100; i++) {
            fixedThreadPool.submit(new Job(i));
        }

        Thread.sleep(1_000);

        fixedThreadPool.shutdownNow();

        /*for (int i = 0; i < 100; i++) {
            fixedThreadPool.submit(new Job(i));
        }*/

        log.info("Finished");
    }
}

@Slf4j
@RequiredArgsConstructor
class Job implements Runnable {
    private final int num;

    @SneakyThrows // грех!!!
    @Override
    public void run() {
        log.info("Work {}", num);
        Thread.sleep(200);
    }
}
