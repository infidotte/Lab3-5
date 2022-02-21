package com.company.EntityImpl;

import com.company.Interfaces.Inter;

public class InterWrapperImpl implements Inter {
    private int[] array;

    public InterWrapperImpl(Inter inter) {
        array = inter.getArray();
    }

    @Override
    public synchronized int[] getArray() {
        return this.array;
    }

    @Override
    public synchronized void setIndexArray(int index, int value) {
        this.array[index] = value;
    }

    @Override
    public synchronized int getLength() {
        return array.length;
    }

    @Override
    public synchronized int getIndexArray(int index) {
        return this.array[index];
    }
}
