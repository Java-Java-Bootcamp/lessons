package main.otus.jmm.old;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterBrokenWitAtomic {
    private static AtomicInteger count = new AtomicInteger(0);

    private static final int LIMIT = 10_000;

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(CounterBrokenWitAtomic::inc);
        Thread thread2 = new Thread(CounterBrokenWitAtomic::inc);
        Thread thread3 = new Thread(CounterBrokenWitAtomic::inc);

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(count);
    }

    private static void inc() {
        for (int idx = 0; idx < LIMIT; idx++) {
            count.incrementAndGet();
        }

    }
}
