package com.company.EntityImpl;

import com.company.Exceptions.BrokenCostException;
import com.company.Exceptions.BrokenPickUpException;
import com.company.Guitar;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class SimpleGuitar implements Guitar, Serializable {

    private String[] pickups;
    private String guitar_name;
    private int guitar_cost;

    //block to Lab4
    private String[] toRead = {};
    public SimpleGuitar(String[] b) {
        toRead = b;
    }
    public void getToRead() {
        for (String i : toRead) {
            System.out.print((char) Integer.parseInt(i));
        }
        System.out.println();
    }
    //block to Lab4

    //default designer
    public SimpleGuitar() {
        pickups = new String[]{"Bridge-Single", "Middle-Single", "Neck-Single"};
        guitar_name = "Fender Square";
        guitar_cost = 20000;
    }

    //custom designer
    public SimpleGuitar(String[] pickup, String name, int cost) {
        for (int i = 0; i < pickup.length; i++) {
            checkPickUp(pickup[i]);
        }
        try {
            checkCost(cost);
        } catch (BrokenCostException e) {
            e.printStackTrace();
        }
        pickups = pickup;
        guitar_name = name;
        guitar_cost = cost;
    }

    //getters and setters
    public String getPickup(int index) {
        return pickups[index];
    }
    public String[] getPickups() {
        return pickups;
    }
    public String getName() {
        return guitar_name;
    }
    public void setName(String name) {
        this.guitar_name = name;
    }
    public int getCost() {
        return guitar_cost;
    }
    public void setCost(int cost) {
        this.guitar_cost = cost;
    }
    //getters and setters

    //function method
    public boolean ifHumbucker() {
        boolean res = false;
        if (guitar_name.equals("Fender Square") && pickups[0].equals("Bridge-Humbucker")) {
            guitar_name = "Fender Square Rock";
            res = true;
        }
        return res;
    }

    //exception methods
    @Override
    public void checkPickUp(String PickUp) throws BrokenPickUpException {
        if (PickUp.equals("Broken")) {
            throw new BrokenPickUpException("Broken pickup");
        }

    }
    public void checkCost(int cost) throws BrokenCostException {
        if (cost < 0) {
            throw new BrokenCostException("Broken message");
        }
    }
    //exception methods

    //lab4 methods
    public void output(OutputStream out) throws IOException {
        out.write('G');
        out.write('U');
        out.write('I');
        out.write('T');
        out.write('A');
        out.write('R');
        out.write(' ');
    }
    public void write(Writer out) throws IOException {
        out.write("GUITAR! ");
    }
    public Guitar createFromInputStream(InputStream input) throws IOException {
        int code;
        String str = "";
        while ((code = input.read()) != -1) {
            str = str.concat(Integer.toString(code));
            str = str + " ";
        }
        String[] arr = str.split(" ");
        Guitar inputGuitar = new SimpleGuitar(arr);
        return inputGuitar;
    }
    public Guitar createFromReader(Reader reader) throws IOException {
        int charCode;
        String str = "";
        while ((charCode = reader.read()) != -1) {
            str = str.concat(Integer.toString(charCode));
            str = str + " ";
        }
        String[] arr = str.split(" ");
        Guitar inputGuitar = new SimpleGuitar(arr);
        return inputGuitar;
    }
    //lab4 methods

    //override
    @Override
    public String toString() {
        return "SimpleGuitar{" +
                "pickups=" + Arrays.toString(pickups) +
                ", guitar_name='" + guitar_name + '\'' +
                ", guitar_cost=" + guitar_cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleGuitar)) return false;
        SimpleGuitar that = (SimpleGuitar) o;
        return guitar_cost == that.guitar_cost && Arrays.equals(pickups, that.pickups) && Objects.equals(guitar_name, that.guitar_name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(guitar_name, guitar_cost);
        result = 31 * result + Arrays.hashCode(pickups);
        return result;
    }
}
