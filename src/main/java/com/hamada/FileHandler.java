package com.hamada;

import java.io.*;
import java.util.List;

public class FileHandler {
    private static final String DRUGS_FILE = "drugsFile";

    public static void saveDrugs(List<Drug> drugs) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DRUGS_FILE))) {
            oos.writeObject(drugs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Drug> readDrugList() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DRUGS_FILE))) {
            return  (List<Drug>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
