package com.company.Interfaces;

import com.company.Exceptions.BrokenPickUpException;

import java.io.*;
import java.util.Iterator;


public interface Guitar extends Iterable {
    String getName();

    void setName(String name);

    int getCost();

    void setCost(int cost);

    boolean ifHumbucker();

    String getPickup(int index);

    String[] getPickups();

    void checkPickUp(String pickUp) throws BrokenPickUpException;

    void output(OutputStream out) throws IOException;

    void write(Writer out) throws IOException;

    void getToRead();

    Guitar createFromInputStream(InputStream input) throws IOException;

    Guitar createFromReader(Reader reader) throws IOException;

    @Override
    Iterator iterator();
}
