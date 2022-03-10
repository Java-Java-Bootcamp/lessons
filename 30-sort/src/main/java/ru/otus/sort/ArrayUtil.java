package ru.otus.sort;

public class ArrayUtil {

    public void printArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            String format = i < array.length - 1 ? "%s, " : "%s";
            System.out.printf(format, array[i]);
        }
        System.out.println();
    }

    public void swap(int[] array, int left, int right) {
        array[left] = array[left] ^ array[right] ^ (array[right] = array[left]);
    }
}
