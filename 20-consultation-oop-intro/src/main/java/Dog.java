package com.company;


public class Dog extends Animal {

    private String name;

    public Dog(String food, String location, String name) {
        super(food, location);
        this.name = name;
    }

    public  void makeNoise() {
        System.out.println("Гав-гав");
    }

    public void sleep() {
        System.out.println("I am not sleeping...");
    }

    // overriding - переопределение
    // overloading - перегрузка
    public void run() {
        System.out.println("I love running...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + '}';
    }
}
