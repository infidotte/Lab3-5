package com.company;

import com.company.Exceptions.BrokenPickUpException;

import java.io.OutputStream;

public interface Guitar {
    String getName();

    void setName(String name);

    int getCost();

    void setCost(int cost);

    boolean ifHumbucker();

    String getPickup(int index);

    String[] getPickups();

    void checkPickUp(String pickUp) throws BrokenPickUpException;

    void output(OutputStream out);
}
