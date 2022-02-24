package com.company.Exceptions;

public class UnsupportedOperationException extends Exception {
    public UnsupportedOperationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
