package ru.otus.sort;

public class InsertionSort {
    private final ArrayUtil util = new ArrayUtil();

    public void sort(int[] array) {
        util.printArray(array);

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }

        util.printArray(array);
    }
}