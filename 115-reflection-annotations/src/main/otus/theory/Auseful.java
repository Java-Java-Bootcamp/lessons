package main.otus.theory;

public class Auseful {
    public static void main(String[] args) throws Exception {

        boolean primitiveString = String.class.isPrimitive();
        boolean primitiveInt = int.class.isPrimitive();
        System.out.println("primitiveString:" + primitiveString + ", primitiveInt:" + primitiveInt);

        int[] arr = {1, 2};
        boolean isArray = arr.getClass().isArray();
        Class<?> componentArr = arr.getClass().getComponentType();
        System.out.println("isArray:" + isArray + ",  componentArr:" + componentArr);

        Class<?> string = Class.forName("java.lang.String");
        boolean isIterableString = Iterable.class.isAssignableFrom(string);

        Class<?> list = Class.forName("java.util.ArrayList");
        boolean isIterableList = Iterable.class.isAssignableFrom(list);
        System.out.println("isIterableString:" + isIterableString + ", isIterableList:" + isIterableList);

        boolean hasAnnotation = DemoClass.class.getMethod("toString").isAnnotationPresent(SimpleAnnotation.class);
        System.out.println("hasAnnotation:" + hasAnnotation);
    }
}
