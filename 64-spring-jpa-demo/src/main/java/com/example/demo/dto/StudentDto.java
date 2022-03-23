package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;


public class StudentDto {

    private final String id;
    private final String firstName;
    private final String lastName;

    @JsonCreator
    public StudentDto(String id, String firstName, String lastName) {
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
