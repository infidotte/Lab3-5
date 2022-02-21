package com.company.Exceptions;

import java.io.PrintStream;

public class BrokenPickUpException extends RuntimeException {

    public BrokenPickUpException(String message) {
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
