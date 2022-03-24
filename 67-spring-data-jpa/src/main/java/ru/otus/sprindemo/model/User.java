package ru.otus.sprindemo.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User implements Cloneable {
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String phone;

    public User(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = String.format("%s %s", lastName, firstName);
        this.email = email;
        this.phone = phone;
    }

    public User clone() {
        User entity = new User(this.firstName, this.lastName, this.email, this.phone);
        entity.fullName = this.fullName;
        return entity;
    }

    public static class UserBuilder {
        public User build() {
            User entity = new User(this.firstName, this.lastName, this.email, this.phone);
            entity.fullName = this.fullName;
            return entity;
        }
    }
}
