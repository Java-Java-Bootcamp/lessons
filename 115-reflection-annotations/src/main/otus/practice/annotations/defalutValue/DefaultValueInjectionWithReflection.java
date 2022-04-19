package main.otus.practice.annotations.defalutValue;

import java.lang.reflect.Field;

public class DefaultValueInjectionWithReflection {

    public static void main(String[] args) throws Exception {

        BeanWithDefaultValue beanWithDefaultAnnotation = new BeanWithDefaultValue();

        Field field = beanWithDefaultAnnotation.getClass().getDeclaredField("someFieldWithDefaultValue");
        field.setAccessible(true);

        if(field.get(beanWithDefaultAnnotation) == null){
            MyDefaultValue myDefaultValue  = (MyDefaultValue) field.getDeclaredAnnotations()[0];
            field.set(beanWithDefaultAnnotation, myDefaultValue.defaultValue());
        }
        System.out.println("bean field value after set: " + beanWithDefaultAnnotation.getSomeFieldWithDefaultValue());

    }
}
