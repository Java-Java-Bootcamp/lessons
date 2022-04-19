package main.otus.practice.annotations.jsonconverter;

public class AnotherBean {
    @JsonField(name = "className")
    private String beanName;

    @JsonField(name = "beanDate")
    private String date;

    public AnotherBean(String beanName, String date) {
        this.beanName = beanName;
        this.date = date;
    }
}
