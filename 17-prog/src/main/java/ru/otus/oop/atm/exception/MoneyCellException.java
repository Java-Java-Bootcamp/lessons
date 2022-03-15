package ru.otus.oop.atm.exception;

public class MoneyCellException extends Exception {
    public MoneyCellException() {
        super();
    }

    public MoneyCellException(String message) {
        super(message);
    }

    public MoneyCellException(String message, Throwable cause) {
        super(message, cause);
    }

    public MoneyCellException(Throwable cause) {
        super(cause);
    }
}
