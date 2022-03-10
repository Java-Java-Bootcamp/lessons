package ru.otus.sort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {
    private Random random = new Random();

    public void generate() {
        int size = 1_000_000_000;
        try (FileWriter output = new FileWriter("numbers.txt")) {
            for (int i = 0; i < size; i++) {
                int value = random.nextInt(size);
                output.write(value + "\n");
            }
            System.out.println("The file has been written");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }

        return array;
    }
}
