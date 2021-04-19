package com.example27.execption;

public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
