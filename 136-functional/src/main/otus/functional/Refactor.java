package main.otus.functional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class Refactor {

    private static Set<String> records = new HashSet<>();

    public static void main(String[] args) {
        Consumer<String> saveString = record -> records.add(record);
        Consumer<String> printString = record -> System.out.println(record);
        genericMethod(1, saveString);
        genericMethod(2, printString);
    }


    public static void genericMethod(int record, Consumer<String> actionToBeAdded) {
        String dataToPrint = getData(record);
        actionToBeAdded.accept(dataToPrint);
    }

    public static void printDataFromDatabase(int record) {
        String dataToPrint = getData(record);
        System.out.println("printing data from database: " + dataToPrint);
    }


    public static void savingDataDataFromDatabase(int record) {
        String dataToSave = getData(record);
        records.add(dataToSave);
    }

    private static String getData(int recordNumber) {
        return String.valueOf(recordNumber); //assuming it's call from database
    }


}
