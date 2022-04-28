package main.otus.functional;

import java.util.*;
import java.util.function.*;

public class FunctionSupplierPredicateConsumer {


    public static void main(String[] args) {
        List<String> array = new ArrayList<>();

        array.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String s1) {
                return s.length() - s1.length();
            }
        });

        array.sort((s, s1) -> s.length() - s1.length());

        Predicate<Integer> greaterThan10 = x -> x > 10;
        BiPredicate<Integer, Integer> sumPredicate = (x,y) -> x + y > 100;
        Predicate<String> containsMoreThan3Chars = word -> word!= null && word.length() > 3;
        genericFunctionWithPredicate(x -> x.length() > 10);

        Supplier<String> emptyString = () -> "";
        Supplier<Date> nowDateSupplier = () -> {
            if (System.currentTimeMillis() > 100000) {
                System.out.println("Time is more than " + 100000);
                return new Date(100000);
            } else {
                System.out.println("Time is less than " + 100000);
                return new Date(5000);
            }
        };

        genericFunctionWithSupplier(nowDateSupplier);
        Consumer<String> printSupplier = (x) -> System.out.println(x);
        Function<String, Integer> getLengthFromString = x -> x.length();

        Integer length = getLengthFromString.apply("My String Value");
    }

    public static void printDataFromDatabase(int record){
        String dataToPrint = getData(record);
        System.out.println("printing data from database: " + dataToPrint);
    }

    private static Map<Integer,String> records = new HashMap<>();

    public static void savingDataDataFromDatabase(int record){
        String dataToSave = getData(record);
        records.put(record, dataToSave);
    }


    private static String getData(int recordNumber){
        return String.valueOf(recordNumber); //assuming it's call from database
    }

    public static void genericFunctionWithPredicate(Predicate<String> myPredicate) {
        if(myPredicate.test("some string")){
            System.out.println("some string");
        }
    }

    public static void genericFunctionWithSupplier(Supplier<Date> myPredicate) {
        System.out.println(myPredicate.get());
    }

    public static void genericFunctionWithFunction(Function<String, Integer> myFunction) {
        if(myFunction.apply("some word") > 12){
            System.out.println(" for some word is more than 12");
        }else{
            System.out.println(" for some word is less than 12");
        }
    }

    public static void genericFunctionWithSupplier(Predicate<String> myPredicate) {
        String myString = "";
        if (myPredicate.test(myString)) {
            System.out.println(" yes it true!");
        }
    }


}
