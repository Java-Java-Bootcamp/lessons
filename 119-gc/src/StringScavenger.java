public class StringScavenger {
    private static final String ORIGINAL = "test-gc";
    private static final int ITERATIONS = 1024 * 10;

    public void work() {
        long lettersCount = 0;
        System.out.println(getClass().getSimpleName() + ": Work started");

        // в идеале: 1 мегабайт x 1024 x 10 = 1 гигабайт x 10 = 10 гигабайт
        for (int i = 0; i < ITERATIONS; i++) {
            var str = new String(ORIGINAL);
            lettersCount += str.length();
        }

        System.out.println(getClass().getSimpleName() + ": Work stopped: " + lettersCount + " total letters");
    }
}
