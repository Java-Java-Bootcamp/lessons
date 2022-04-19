package main.otus.practice.annotations.jsonconverter;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonConverter {
    public static void main(String[] args) throws IllegalAccessException {
        BeanToBeConverted beanToBeConverted = new BeanToBeConverted("john", 45, "whatever");
        AnotherBean anotherBean = new AnotherBean("bean with date name value", "2020-12-11");

        System.out.println(convertToJson(beanToBeConverted));
        System.out.println(convertToJson(anotherBean));
    }

    public static String convertToJson(Object object) throws IllegalAccessException {
        List<String> jsonPairs = new ArrayList<>();
        Class classData = object.getClass();
        for( Field field: classData.getDeclaredFields()){
            boolean isJsonableField = field.getAnnotations().length > 0 && field.getAnnotations()[0].annotationType().getTypeName().contains("JsonField");
            if(isJsonableField){
                JsonField jsonField = (JsonField) field.getAnnotations()[0];
                field.setAccessible(true);
                jsonPairs.add("\"" + jsonField.name() + "\":\"" + field.get(object) + "\"");
            }
            System.out.println();
        }
       return jsonPairs.stream().collect(Collectors.joining(",","{","}"));
    }

}
