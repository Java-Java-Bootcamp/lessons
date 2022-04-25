package main.otus.jmm.memory;

public class StackHeapExample {

    private static  Integer intObject = new Integer(0);
    private static int intPrimitive = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> method());
        thread1.start();
        thread1.join();
        System.out.println(intObject);
    }

    private static void method() {
        for (int i = 0; i < 10000; i++) {
            intObject++;
        }
    }

    private static void oneMoreMethod(User passedTwice) {
        double simpleDouble = 12d;
        passedTwice.setName("Maria");
    }

    private static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


}
