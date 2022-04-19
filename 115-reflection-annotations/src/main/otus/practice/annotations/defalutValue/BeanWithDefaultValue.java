package main.otus.practice.annotations.defalutValue;

public class BeanWithDefaultValue {

    @MyDefaultValue(defaultValue = "value by default")
    private String someFieldWithDefaultValue;

    public BeanWithDefaultValue(){

    }

    public String getSomeFieldWithDefaultValue() {
        return someFieldWithDefaultValue;
    }

}
