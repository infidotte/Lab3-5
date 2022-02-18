package com.company.Classes;

import com.company.Interfaces.Inter;

public class WriterThread extends Thread {
    private Inter inter;
    private int size;

    public WriterThread(Inter inter) {
        this.inter = inter;
        this.size = inter.getLength();

    }

    public void run() {
        try {
            for (int i = 0; i < size; i++) {
                int value = (int) (Math.random() * 99 + 1);
                inter.setIndexArray(i, value);
                System.out.printf("%2d to position %s \n", value, i);
                Thread.sleep(1);
            }
            System.out.print("WriteThread finished...\n");

        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

    }
}