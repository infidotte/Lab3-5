package com.company.EntityImpl;

import com.company.Interfaces.Inter;

import java.util.Arrays;

public class Impl implements Inter {

    private int[] array;

    public Impl(int size) {
        array = new int[size];
    }

    @Override
    public int[] getArray() {
        return array;
    }

    public int getIndexArray(int index) {
        return this.array[index];
    }

    public void setIndexArray(int index, int value) {
        this.array[index] = value;
    }

    public int getLength() {
        return this.array.length;
    }

    @Override
    public String toString() {
        return "Impl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}