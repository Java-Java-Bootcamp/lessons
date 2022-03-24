package com.example.demo.model;

import com.example.demo.dto.StudentDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    public Student() {
    }

    public Student(StudentDto dto) {
        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentDto createDto() {
        return new StudentDto(id, firstName, lastName);
    }

}
