package exersises;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@NoThreadSafe
public class MorningCoffee extends Thread {
    static int coffeeBeans = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            coffeeBeans += 2;
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        log.info("Work day started");
        // три программиста одновременно пьют кофе
        List<Thread> threads = List.of(
                new MorningCoffee(),
                new MorningCoffee(),
                new MorningCoffee()
        );

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        log.info("Done. Coffee beans count: {}", coffeeBeans);
    }
}