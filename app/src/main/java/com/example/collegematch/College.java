package com.example.collegematch;


import java.util.ArrayList;

public class College {
    String name;
    float GPA;
    long ACT;
    long SAT;
    ArrayList<String> majors;
    double PPS; // price per semester
    String location;

    public College(
            String name, float GPA, long ACT, long SAT,
            ArrayList<String> majors, double PPS, String location
        ) {
        this.name = name;
        this.GPA = GPA;
        this.ACT = ACT;
        this.SAT = SAT;
        this.majors = majors;
        this.PPS = PPS;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public float getGPA() {
        return GPA;
    }

    public long getACT() {
        return ACT;
    }

    public long getSAT() {
        return SAT;
    }

    public ArrayList<String> getMajors() {
        return majors;
    }

    public double getPPS() {
        return PPS;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return getName();
    }
}