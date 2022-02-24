package com.company.Classes;

import com.company.Exceptions.BrokenPickUpException;
import com.company.Exceptions.UnsupportedOperationException;
import com.company.Interfaces.Guitar;

import java.io.*;
import java.util.Iterator;

public class UnModifiable implements Guitar {
    Guitar object;

    public UnModifiable(Guitar o) {
        this.object = o;
    }

    @Override
    public String getName() {
        return object.getName();
    }

    @Override
    public void setName(String name) {
        Exception error = new UnsupportedOperationException("Unsupported Operation");
        error.printStackTrace();
    }

    @Override
    public int getCost() {
        return object.getCost();
    }

    @Override
    public void setCost(int cost) {
        Exception error = new UnsupportedOperationException("Unsupported Operation");
        error.printStackTrace();
    }

    @Override
    public boolean ifHumbucker() {
        return object.ifHumbucker();
    }

    @Override
    public String getPickup(int index) {
        return object.getPickup(index);
    }

    @Override
    public String[] getPickups() {
        return object.getPickups();
    }

    @Override
    public void checkPickUp(String pickUp) throws BrokenPickUpException {
        object.checkPickUp(pickUp);
    }

    @Override
    public void output(OutputStream out) throws IOException {
        object.output(out);
    }

    @Override
    public void write(Writer out) throws IOException {
        object.write(out);
    }

    @Override
    public void getToRead() {
        object.getToRead();
    }

    @Override
    public Guitar createFromInputStream(InputStream input) throws IOException {
        return object.createFromInputStream(input);
    }

    @Override
    public Guitar createFromReader(Reader reader) throws IOException {
        return object.createFromReader(reader);
    }

    @Override
    public Iterator iterator() {
        return object.iterator();
    }
}
