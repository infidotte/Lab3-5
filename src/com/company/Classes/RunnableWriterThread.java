package com.company.Classes;

import com.company.Interfaces.Inter;

import java.util.concurrent.Semaphore;

public class RunnableWriterThread implements Runnable {
    private Inter inter;
    private int index;
    Semaphore sem;

    public RunnableWriterThread(Inter inter, int index, Semaphore sem) {
        this.inter = inter;
        this.index = index;
        this.sem = sem;
    }

    public void run() {
        try {
            sem.acquire();
            int value = (int) (Math.random() * 99 + 1);
            inter.setIndexArray(index, value);
            System.out.printf("%2d to position %s \n", value, index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();
    }
}
