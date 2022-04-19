package main.otus.practice.annotations.dependencyinjection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DependencyInjectionWithRefleciton {

    private static Map<String, Object> injectableBeans = new HashMap<>();

    public static void main(String[] args) throws IllegalAccessException {
        initializeContext();
        ServiceWithInjection bean = new ServiceWithInjection();
        for (Field field : bean.getClass().getDeclaredFields()) {
           boolean hasInjectedAnnotation = field.getDeclaredAnnotations()[0].annotationType().getName().contains("Inject");
           if(hasInjectedAnnotation){
               field.setAccessible(true);
               field.set(bean, injectableBeans.get(field.getType().getTypeName()));
           }
        }
        System.out.println(bean.callService());
    }

    public static void initializeContext(){
        injectableBeans.put(Service.class.getTypeName(), new ServiceImpl());
    }

}
