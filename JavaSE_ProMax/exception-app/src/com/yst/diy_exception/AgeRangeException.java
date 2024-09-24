package com.yst.diy_exception;

public class AgeRangeException extends RuntimeException {
    public AgeRangeException() {
    }

    public AgeRangeException(String message) {
        super(message);
    }
}
