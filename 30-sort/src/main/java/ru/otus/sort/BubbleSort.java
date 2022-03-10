package ru.otus.sort;


public class BubbleSort {
    private final ArrayUtil util = new ArrayUtil();

    public void sort(int[] array) {
        util.printArray(array);

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int next = j + 1;
                if (array[j] > array[next]) {
                    util.swap(array, j, next);
                }
            }
        }

        util.printArray(array);
    }
}
