package ru.otus.sort;

public class QuickSort {
    private final ArrayUtil util = new ArrayUtil();

    public void sort(int[] array) {
        util.printArray(array);

        quickSort(array, 0, array.length - 1);

        util.printArray(array);
    }

    private void quickSort(int[] array, int from, int to) {
        if (from >= to) {
            return;
        }
        int left = from;
        int right = to;
        int mid = (left + right) / 2;

        while (left < right) {
            if (array[left] > array[mid]) {
                util.swap(array, left, mid);
            } else {
                left++;
            }

            if (array[right] < array[mid]) {
                util.swap(array, right, mid);
            } else {
                right--;
            }
        }

        if (right - from > 1) {
            quickSort(array, from, right);
        }
        if (to - right > 1) {
            quickSort(array, right, to);
        }
    }
}
