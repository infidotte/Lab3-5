package com.company.Classes;

import com.company.EntityImpl.BassGuitar;
import com.company.EntityImpl.InterWrapperImpl;
import com.company.EntityImpl.SimpleGuitar;
import com.company.Interfaces.Guitar;
import com.company.Interfaces.Inter;

import java.io.*;
import java.util.Arrays;

public class Statics {

    public static void outputGuitar(Guitar guitar, OutputStream out) throws IOException {
        guitar.output(out);
    }

    public static void writeGuitar(Guitar guitar, Writer out) throws IOException {
        guitar.write(out);
    }

    public static Guitar inputGuitar(InputStream input) throws IOException {
        Guitar res = new SimpleGuitar().createFromInputStream(input);
        return res;
    }

    public static Guitar readerGuitar(Reader reader) throws IOException {
        Guitar result = new BassGuitar().createFromReader(reader);
        return result;
    }

    public static void serialOutput(Guitar[] array) {
        File savefile = new File("src/com/company/Files/savefile.txt");
        try (FileOutputStream out = new FileOutputStream(savefile);
             ObjectOutputStream objout = new ObjectOutputStream(out)) {
            System.out.println("Before serialize :  " + Arrays.toString(array));
            objout.writeObject(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serialInput() {
        File savefile = new File("src/com/company/Files/savefile.txt");
        try (
                FileInputStream fileinput = new FileInputStream(savefile);
                ObjectInputStream objinput = new ObjectInputStream(fileinput);
        ) {
            Guitar[] array = (Guitar[]) objinput.readObject();
            System.out.println("After serialize :  " + Arrays.toString(array));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Inter synchronizedInter(Inter i) {
        Inter obj = new InterWrapperImpl(i);
        return obj;
    }
}
