package com.company;

import com.company.Classes.Methods;
import com.company.Classes.Statics;
import com.company.EntityImpl.BassGuitar;
import com.company.EntityImpl.SimpleGuitar;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("write to call functions: \n" +
                "1 - start lab3 with preset objects\n" +
                "2 - start with custom\n" +
                "3 - start lab4 methods");
        int choice = Integer.parseInt(sc.nextLine());
        Methods met = new Methods();
        switch (choice) {
            case 1:
                Guitar[] array1 = met.presetArray();
                cicle(array1,met);
                break;
            case 2:
                Guitar[] array2 = met.createArray();
                cicle(array2,met);
                break;
            case 3:
                Guitar[] array3 = met.presetArray();
                met.outinput(array3);
        }

    }
    public static void cicle(Guitar[] array, Methods met){
        for(int i = 0; i< array.length; i++){
            System.out.println(i+1 + ": " + array[i]);
        }
        System.out.println("\nМассив объектов по функциональному методу:\n" + Arrays.toString(met.functionArray(array)));
        Guitar[] guitas = met.checkCode(array, 2);
        Guitar[] basses = met.checkCode(array, 1);
        System.out.println("\nМассивы, разделенные по типу объектов\n" + Arrays.toString(guitas));
        System.out.println(Arrays.toString(basses) + "\n");
    }
}
