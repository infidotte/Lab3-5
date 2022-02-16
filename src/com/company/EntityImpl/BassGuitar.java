package com.company.EntityImpl;

import com.company.Exceptions.BrokenCostException;
import com.company.Exceptions.BrokenPickUpException;
import com.company.Guitar;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Objects;

public class BassGuitar implements Guitar {
    private String[] pickups;
    private String bass_name = "";
    private int bass_cost = 0;

    public BassGuitar() {
        pickups = new String[]{"Bridge-Single", "Middle-Single"};
        bass_name = "Fender Square";
        bass_cost = 20000;
    }

    public BassGuitar(String[] pickup, String name, int cost) {
        for (int i = 0; i < pickup.length; i++){
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

    public String getName() {
        return bass_name;
    }

    public void setName(String name) {
        this.bass_name = name;
    }

    public String getPickup(int index) {
        return pickups[index];
    }

    public String[] getPickups(){
        return pickups;
    }

    @Override
    public void checkPickUp(String PickUp) throws BrokenPickUpException {
        if (PickUp.equals("Broken")) {
            throw new BrokenPickUpException("Broken pickup");
        }

    }

    public void checkCost(int cost) throws BrokenCostException {
        if (cost<0){
            throw new BrokenCostException("Broken message");
        }
    }
    public int getCost() {
        return bass_cost;
    }

    public void setCost(int cost) {
        this.bass_cost = cost;
    }

    public boolean ifHumbucker() {
        boolean res = false;
        if (bass_name == "Fender Square" && pickups[0] == "Bridge-Humbucker") {
            bass_name = "Fender Square Rock";
            res = true;
        }
        return res;
    }

    public void output(OutputStream out){

    }
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
