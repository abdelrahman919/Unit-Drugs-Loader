package com.hamada;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Drug> drugs = ApiCaller.getDrugListFromServer();
//        FileHandler.saveDrugs(drugs);
        DrugsLoader drugsLoader = Config.setUp();
        drugsLoader.loadDrugs();

    }
}