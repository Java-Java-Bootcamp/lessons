package ru.otus.sort;

public class MergeSort {
    private final ArrayUtil util = new ArrayUtil();

    public void sort(int[] array) {
        util.printArray(array);

        int[] result = mergeSort(array);

        util.printArray(result);
    }

    private int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[mid + i];
        }

        left = mergeSort(left);
        right = mergeSort(right);
        int[] result = merge(left, right);

        return result;
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPoint = 0;
        int rightPoint = 0;
        int resultPoint = 0;

        while (leftPoint <= left.length - 1 && rightPoint <= right.length - 1) {
            if (left[leftPoint] <= right[rightPoint]) {
                result[resultPoint] = left[leftPoint];
                leftPoint++;
                resultPoint++;
            } else {
                result[resultPoint] = right[rightPoint];
                rightPoint++;
                resultPoint++;
            }
        }

        while (leftPoint <= left.length - 1) {
            result[resultPoint] = left[leftPoint];
            leftPoint++;
            resultPoint++;
        }
        while (rightPoint <= right.length - 1) {
            result[resultPoint] = right[rightPoint];
            rightPoint++;
            resultPoint++;
        }

        return result;
    }
}
