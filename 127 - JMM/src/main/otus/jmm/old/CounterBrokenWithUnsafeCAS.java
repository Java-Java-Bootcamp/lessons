package main.otus.jmm.old;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class CounterBrokenWithUnsafeCAS {

    static CASCounter casCounter;

    static {
        try {
            casCounter = new CASCounter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final int LIMIT = 10_000;
    private static void inc() {
        for (int idx = 0; idx < LIMIT; idx++) {
            casCounter.increment();
        }
    }
    public static void main(String[] args) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);

        Thread thread1 = new Thread(CounterBrokenWithUnsafeCAS::inc);
        Thread thread2 = new Thread(CounterBrokenWithUnsafeCAS::inc);
        Thread thread3 = new Thread(CounterBrokenWithUnsafeCAS::inc);

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(casCounter.getCounter());
    }


    static class CASCounter {
        private Unsafe unsafe;
        private volatile long counter = 0;
        private long offset;

        private Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        }

        public CASCounter() throws Exception {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
        }

        public void increment() {
            long before = counter;
            while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
                before = counter;
            }
        }

        public long getCounter() {
            return counter;
        }
    }

}
