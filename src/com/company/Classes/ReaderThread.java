package com.company.Classes;

import com.company.Interfaces.Inter;

public class ReaderThread extends Thread {
    private Inter inter;
    private int size;
    private int time;

    public ReaderThread(Inter inter) {
        this.inter = inter;
        this.size = inter.getLength();
        this.time = size * 10;
    }

    public void run() {
        try {
            Thread.sleep(time);
            for (int i = 0; i < size; i++) {
                int value = inter.getIndexArray(i);
                System.out.printf("%2d from position %s \n", value, i);
            }
            System.out.print("ReadThread finished...\n");
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

    }
}
