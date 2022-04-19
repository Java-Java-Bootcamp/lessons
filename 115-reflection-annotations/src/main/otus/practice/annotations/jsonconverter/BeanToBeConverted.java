package main.otus.practice.annotations.jsonconverter;

public class BeanToBeConverted {
    public BeanToBeConverted(String name, int age, String noused) {
        this.name = name;
        this.age = age;
        this.noused = noused;
    }

    @JsonField(name = "userName")
    private String name;
    @JsonField(name = "age")
    private int age;
    private String noused;
}
