package com.company.Exceptions;

public class BrokenCostException extends Exception{
    public BrokenCostException(String message){
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
