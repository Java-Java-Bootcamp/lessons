package com.company;

public class Animal {

    private String food;
    private String location;

    public Animal() {
    }

    public Animal(String food) {
        this.food = food;
    }

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public void sleep() {
        System.out.println("I am sleeping...");
    }

    @Override
    public String toString() {
        return "Animal{" + "food='" + food + '\'' + ", location='" + location + '\'' + '}';
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
