package ru.otus.sort;

public class Application {
    public static void main(String[] args) {
        Generator generator = new Generator();
        int[] array = generator.generateArray(10);

        BubbleSort bubbleSort=new BubbleSort();
        bubbleSort.sort(array);

        array = generator.generateArray(10);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array);
    }
}
