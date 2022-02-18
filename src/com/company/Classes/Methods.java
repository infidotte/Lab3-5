package com.company.Classes;

import com.company.EntityImpl.BassGuitar;
import com.company.EntityImpl.Impl;
import com.company.EntityImpl.SimpleGuitar;
import com.company.Interfaces.Guitar;
import com.company.Interfaces.Inter;

import java.io.*;
import java.util.Scanner;

public class Methods {


    public Guitar[] createArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("write size of array: ");
        int size = Integer.parseInt(sc.nextLine());
        Guitar[] array = new Guitar[size];
        for (int i = 0; i < size; i++) {
            System.out.print("0 id default guitar, 1 if custom: ");
            int cust = Integer.parseInt(sc.nextLine());
            if (cust == 1) {
                System.out.print("0 if Bass, 1 if Guitar: ");
                int choice = Integer.parseInt(sc.nextLine());
                System.out.print("write pickups: ");
                String[] pickup = sc.nextLine().split(" ");
                System.out.print("write name: ");
                String name = sc.nextLine();
                System.out.print("write cost: ");
                int cost = Integer.parseInt(sc.nextLine());
                if (choice == 0) array[i] = new BassGuitar(pickup, name, cost);
                else if (choice == 1) array[i] = new SimpleGuitar(pickup, name, cost);
            } else if (cust == 0) {
                System.out.print("0 if Bass, 1 if Guitar: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 0) array[i] = new BassGuitar();
                else if (choice == 1) array[i] = new SimpleGuitar();
            }
        }
        return array;
    }

    public Guitar[] functionArray(Guitar[] array) {
        int count = 0;
        for (Guitar i : array) {
            if (i.getPickup(0).equals("Bridge-Humbucker")
                    && i.getName().equals("Fender Square")) count++;
        }
        Guitar[] result = new Guitar[count];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].ifHumbucker()) {
                result[count] = array[i];
                count++;
            }
        }
        return result;
    }

    public Guitar[] checkCode(Guitar[] array, int what) {
        if (what == 1) {
            BassGuitar n = new BassGuitar();
            int code = n.hashCode();
            int count = 0;
            for (Guitar i : array) {
                if (i.hashCode() == code) count++;
            }
            Guitar[] result = new Guitar[count];
            count = 0;
            for (Guitar i : array) {
                if (i.hashCode() == code) result[count++] = i;
            }
            return result;
        } else if (what == 2) {
            SimpleGuitar n = new SimpleGuitar();
            int code = n.hashCode();
            int count = 0;
            for (Guitar i : array) {
                if (i.hashCode() == code) count++;
            }
            Guitar[] result = new Guitar[count];
            count = 0;
            for (Guitar i : array) {
                if (i.hashCode() == code) result[count++] = i;
            }
            return result;
        } else {
            Guitar[] result = {null};
            return result;
        }
    }

    public Guitar[] presetArray(){
        String[] guitar_pickups = {"Bridge-Humbucker", "Middle-Humbucker"};
        String guitar_name = "ZOMBIE";
        int guitar_cost = 19900;

        String[] bass_prickups = {"Bridge-Humbucker", "Neck-Single"};
        String bass_name = "New URAL";
        int bass_cost = 3;

        String[] rock_guitar = {"Bridge-Humbucker", "Middle-Single", "Neck-Single"};
        String rock_guitarname = "Fender Square";
        int rock_guitarcost = 22000;

        String[] rock_bass = {"Bridge-Humbucker", "Middle-Single"};
        String rock_bassname = "Fender Square";
        int rock_basscost = 100;

        Guitar[] array = {new SimpleGuitar(), new SimpleGuitar(guitar_pickups, guitar_name, guitar_cost),
                new BassGuitar(), new BassGuitar(bass_prickups, bass_name, bass_cost),
                new SimpleGuitar(rock_guitar, rock_guitarname, rock_guitarcost),
                new BassGuitar(rock_bass, rock_bassname, rock_basscost)};

        return array;
    }

    public void outinput(Guitar[] array){
        File bytes = new File("src/com/company/Files/bytes.txt");
        File chars = new File("src/com/company/Files/chars.txt");
        File toReadBytes = new File("src/com/company/Files/toReadBytes.txt");
        File toReadChars = new File("src/com/company/Files/toReadChars.txt");

        try (OutputStream output = new FileOutputStream(bytes);
             Writer writer = new FileWriter(chars);
             InputStream input = new FileInputStream(toReadBytes);
             Reader reader = new FileReader(toReadChars)
        ) {
            for (Guitar i : array) {
                i.output(output);
                i.write(writer);
            }
            Statics.outputGuitar(new SimpleGuitar(), output);
            Statics.writeGuitar(new SimpleGuitar(), writer);
            System.out.print("read bytes: ");
            Statics.inputGuitar(input).getToRead();
            System.out.print("read chars: ");
            Statics.readerGuitar(reader).getToRead();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Statics.serialOutput(array);
        Statics.serialInput();
    }

    public void threads(){
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        Inter obj = new Impl(size);
        Thread writer = new WriterThread(obj);
        Thread reader = new ReaderThread(obj);
        System.out.println("Main thread started...");
        reader.start();
        writer.start();
        System.out.println("Main thread fin...");
    }
}
