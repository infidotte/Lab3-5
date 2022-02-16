package com.company.EntityImpl;

import com.company.Exceptions.BrokenCostException;
import com.company.Exceptions.BrokenPickUpException;
import com.company.Guitar;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Objects;

public class SimpleGuitar implements Guitar {
    private String[] pickups;
    private String guitar_name = "";
    private int guitar_cost = 0;

    public SimpleGuitar() {
        pickups = new String[]{"Bridge-Single", "Middle-Single", "Neck-Single"};
        guitar_name = "Fender Square";
        guitar_cost = 20000;
    }

    public SimpleGuitar(String[] pickup, String name, int cost) {
        for (int i = 0; i < pickup.length; i++){
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

    public void checkCost(int cost) throws BrokenCostException{
        if (cost<0){
            throw new BrokenCostException("Broken message");
        }
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

    public boolean ifHumbucker() {
        boolean res = false;
        if (guitar_name == "Fender Square" && pickups[0] == "Bridge-Humbucker") {
            guitar_name = "Fender Square Rock";
            res = true;
        }
        return res;
    }
    public void output(OutputStream out){

    }
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
