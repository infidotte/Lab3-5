package com.company.Classes;

import com.company.Interfaces.Guitar;

import java.util.function.Consumer;

public class Iterator implements java.util.Iterator {
    Guitar obj;
    String[] array;
    int count = 0;

    public Iterator(Guitar obj) {
        this.obj = obj;
        this.array = obj.getPickups();
    }

    @Override
    public boolean hasNext() {
        if (count < array.length) {
            return true;
        } else {
            count = 0;
            return false;
        }
    }

    @Override
    public String next() {
        String result = array[count];
        count++;
        return result;
    }
}