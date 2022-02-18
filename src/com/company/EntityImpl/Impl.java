package com.company.EntityImpl;

import com.company.Interfaces.Inter;

import java.util.Arrays;

public class Impl implements Inter {

    private int[] array;

    public Impl(int size) {
        array = new int[size];
    }

    public int[] getArray() {
        return array;
    }

    public int getIndexArray(int index) {
        int result = array[index];
        return result;
    }

    public void setIndexArray(int index, int value) {
        this.array[index] = value;
    }

    public int getLength() {
        int length = this.array.length;
        return length;
    }

    @Override
    public String toString() {
        return "Impl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}