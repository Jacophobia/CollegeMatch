package com.example.collegematch;


import java.util.ArrayList;

public class DataRetriever {
    public DataRetriever() {

    }

    public ArrayList<College> getCollegeList() {
        ArrayList<College> colleges = new ArrayList<>();
        ArrayList<String> majorsByu = new ArrayList<>();
        majorsByu.add("Computer Science");
        majorsByu.add("Art");
        majorsByu.add("English");
        majorsByu.add("French");
        majorsByu.add("Mechanical Engineering");
        colleges.add(new College("Byu Provo", 3.5f, 29, 1200, majorsByu, 4000.0, "West"));

        ArrayList<String> majorsByui = new ArrayList<>();
        majorsByui.add("Computer Science");
        majorsByui.add("Art");
        majorsByui.add("English");
        majorsByui.add("Spanish");
        majorsByui.add("Mechanical Engineering");
        colleges.add(new College("Byu Idaho", 2.5f, 19, 900, majorsByui, 2000.0, "West"));

        ArrayList<String> majorsHarvard = new ArrayList<>();
        majorsHarvard.add("Law");
        majorsHarvard.add("Art");
        majorsHarvard.add("English");
        majorsHarvard.add("Spanish");
        majorsHarvard.add("Mechanical Engineering");
        colleges.add(new College("Harvard", 3.9f, 34, 1500, majorsHarvard, 26000.0, "East"));

        ArrayList<String> majorsMiami = new ArrayList<>();
        majorsMiami.add("Law");
        majorsMiami.add("Art");
        majorsMiami.add("History");
        majorsMiami.add("Spanish");
        majorsMiami.add("Mechanical Engineering");
        colleges.add(new College("University of Miami", 3.0f, 25, 1250, majorsMiami, 13000.0, "East"));

        ArrayList<String> majorsMissouri = new ArrayList<>();
        majorsMissouri.add("Law");
        majorsMissouri.add("Art");
        majorsMissouri.add("History");
        majorsMissouri.add("Spanish");
        majorsMissouri.add("Dance");
        colleges.add(new College("University of Missouri", 2.0f, 16, 800, majorsMissouri, 9000.0, "Midwest"));

        ArrayList<String> majorsTexas = new ArrayList<>();
        majorsMissouri.add("Law");
        majorsMissouri.add("Interior Design");
        majorsMissouri.add("History");
        majorsMissouri.add("Spanish");
        majorsMissouri.add("Dance");
        colleges.add(new College("Texas University", 3.1f, 26, 1350, majorsTexas, 20000.0, "South"));
        return colleges;
    }


}
