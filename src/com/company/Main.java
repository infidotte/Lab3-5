package com.company;

import com.company.EntityImpl.BassGuitar;
import com.company.EntityImpl.SimpleGuitar;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        Guitar[] rocks = new Guitar[999];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " " + array[i].toString());
            if (array[i].ifHumbucker() == true) {
                rocks[count] = array[i];
                count++;
            }

        }
        count = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] == null) break;
            else count++;
        }
        Guitar[] newrocks = new Guitar[count];
        for (int i = 0; i < count; i++) {
            newrocks[i] = rocks[i];
        }
        System.out.println("\nМассив объектов по функциональному методу:\n" + Arrays.toString(newrocks));
        count = 0;
        Guitar[] guitas = new Guitar[3];
        Guitar[] basses = new Guitar[3];
        for (Guitar i : array) {
            if (i.getClass().hashCode() == 1313922862) {
                guitas[count] = i;
                count++;
            }
        }
        count = 0;
        for (Guitar i : array) {
            if (i.getClass().hashCode() == 495053715) {
                basses[count] = i;
                count++;
            }
        }
        System.out.println("\nМассивы, разделенные по типу объектов\n" + Arrays.toString(guitas));
        System.out.println(Arrays.toString(basses));



    }
    //1313922862 495053715

}
