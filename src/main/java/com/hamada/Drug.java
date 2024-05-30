package com.hamada;

import java.io.Serializable;

public class Drug implements Serializable {

    String name;
    String type;

    public Drug(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
