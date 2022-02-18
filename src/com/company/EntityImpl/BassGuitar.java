package com.company.EntityImpl;

import com.company.Exceptions.BrokenCostException;
import com.company.Exceptions.BrokenPickUpException;
import com.company.Guitar;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class BassGuitar implements Guitar,Serializable {

    private String[] pickups;
    private String bass_name;
    private int bass_cost;

    //block to Lab4
    private String[] toRead = {};
    public BassGuitar(String[] b) {
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
    public BassGuitar() {
        pickups = new String[]{"Bridge-Single", "Middle-Single"};
        bass_name = "Fender Square";
        bass_cost = 20000;
    }

    //custom designer
    public BassGuitar(String[] pickup, String name, int cost) {
        for (int i = 0; i < pickup.length; i++) {
            checkPickUp(pickup[i]);
        }
        try {
            checkCost(cost);
        } catch (BrokenCostException e) {
            e.printStackTrace();
        }
        pickups = pickup;
        bass_name = name;
        bass_cost = cost;
    }

    //getters and setters
    public String getName() {
        return bass_name;
    }
    public void setName(String name) {
        this.bass_name = name;
    }
    public String getPickup(int index) {
        return pickups[index];
    }
    public String[] getPickups() {
        return pickups;
    }
    public int getCost() {
        return bass_cost;
    }
    public void setCost(int cost) {
        this.bass_cost = cost;
    }
    //getters and setters

    //function method
    public boolean ifHumbucker() {
        boolean res = false;
        if (bass_name == "Fender Square" && pickups[0] == "Bridge-Humbucker") {
            bass_name = "Fender Square Rock";
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
        out.write('B');
        out.write('A');
        out.write('S');
        out.write('S');
        out.write(' ');
    }
    public void write(Writer out) throws IOException {
        out.write("BASS! ");
    }
    public Guitar createFromInputStream(InputStream input) throws IOException {
        int code;
        String str = "";
        while ((code = input.read()) != -1) {
            str = str.concat(Integer.toString(code));
            str = str + " ";
        }
        String[] arr = str.split(" ");
        Guitar inputBass = new BassGuitar(arr);
        return inputBass;
    }
    public Guitar createFromReader(Reader reader) throws IOException {
        int charCode;
        String str = "";
        while ((charCode = reader.read()) != -1) {
            str = str.concat(Integer.toString(charCode));
            str = str + " ";
        }
        String[] arr = str.split(" ");
        Guitar inputBass = new BassGuitar(arr);
        return inputBass;
    }
    //lab4 methods

    //override
    @Override
    public String toString() {
        return "BassGuitar{" +
                "pickups=" + Arrays.toString(pickups) +
                ", bass_name='" + bass_name + '\'' +
                ", bass_cost=" + bass_cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BassGuitar)) return false;
        BassGuitar that = (BassGuitar) o;
        return bass_cost == that.bass_cost && Arrays.equals(pickups, that.pickups) && bass_name.equals(that.bass_name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bass_name, bass_cost);
        result = 31 * result + Arrays.hashCode(pickups);
        return result;
    }
}
