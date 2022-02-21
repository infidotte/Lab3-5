package com.company.Classes;

import com.company.Interfaces.Inter;

import java.util.concurrent.Semaphore;

public class RunnableReaderThread {
    private Inter inter;
    private int index;
    Semaphore sem;

    public RunnableReaderThread(Inter inter, int index, Semaphore sem) {
        this.inter = inter;
        this.index = index;
        this.sem = sem;
    }

    public void run() {
        try {
            sem.acquire();
            int value = inter.getIndexArray(index);
            System.out.printf("%2d from position %s \n", value, index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();
    }
}
