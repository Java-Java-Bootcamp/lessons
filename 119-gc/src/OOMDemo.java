public class OOMDemo {
    // -Xmx256m
    // -Xmx1024k
    // -Xmx4g
    // -verbose:gc

    // Epsilon GC: https://openjdk.java.net/jeps/318
    // Demo 1: -Xmx256m -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
    public static void main(String[] args) {
        new Scavenger().work();
    }
}
