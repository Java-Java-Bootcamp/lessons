package main.otus.jmm.memory;

public class Volatile {
    static volatile int []array;

    public static void main(String[] args) {
       array = new int[10]; // guaranteed write
       array[0] = 10; // no guaranty
    }

}
