public class Demo {
    // Demo 2: -Xmx256m
    // -verbose:gc
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            new Scavenger().work();
            Thread.sleep(500);
        }
    }
}
