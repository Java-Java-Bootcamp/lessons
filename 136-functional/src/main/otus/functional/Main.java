package main.otus.functional;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        for (String s : stringList) {
            System.out.println(s);
        }
        stringList.forEach(System.out::println);
        int[] data = new int[10];
        setValue(data);
        System.out.println("value is: " + data[0]);
    }

    static void setValue(int[] data) {
        data[0] = 1;
    }

    int tempValue;

    public int cleanSquareFunction(int value) {
        int result = value ^ 2;
        tempValue = result;
        return result;
    }

    public int cleanSumFunction(int[] value) {
        int sum = 0;
        for (int i = 0; i < value.length; i++) {
            System.out.println("value of current sum is: " + sum);
            sum = sum + value[i];
        }
        return sum;
    }

}
