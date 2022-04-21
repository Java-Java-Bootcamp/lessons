public class Scavenger {
    private static final int BYTES = 1024 * 1024; // 1 мегабайт
    private static final int ITERATIONS = 1024 * 10;

    public void work() {
        long byteCount = 0;
        System.out.println(getClass().getSimpleName() + ": Work started");

        // в идеале: 1 мегабайт x 1024 x 10 = 1 гигабайт x 10 = 10 гигабайт
        for (int i = 0; i < ITERATIONS; i++) {
            byte[] array = new byte[BYTES];
            byteCount += array.length;
        }

        System.out.println(getClass().getSimpleName() + ": Work stopped: " + byteCount + " total bytes");
    }
}
