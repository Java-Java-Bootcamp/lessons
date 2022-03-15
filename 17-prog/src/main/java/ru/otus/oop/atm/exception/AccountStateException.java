package ru.otus.oop.atm.exception;

public class AccountStateException extends Exception{
    public AccountStateException() {
        super();
    }

    public AccountStateException(String message) {
        super(message);
    }

    public AccountStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountStateException(Throwable cause) {
        super(cause);
    }
}
