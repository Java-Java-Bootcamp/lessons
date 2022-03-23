package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Student {

    private final String id;
    private final String firstName;
    private final String lastName;

    @JsonCreator
    public Student(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
