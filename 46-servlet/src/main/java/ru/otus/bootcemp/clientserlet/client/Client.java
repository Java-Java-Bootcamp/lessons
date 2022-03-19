package ru.otus.bootcemp.clientserlet.client;

import java.math.BigInteger;

public class Client {
    private String fullname;
    private BigInteger phone;

    public Client(){}

    public Client(String fullname, BigInteger phone) {
        this.fullname = fullname;
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "fullname='" + fullname + '\'' +
                ", phone=" + phone +
                '}';
    }
}
