package com.example.collegematch;


import java.util.ArrayList;

public class DataFormatter {
    ArrayList<College> colleges;
    DataSorter sorter;

    DataFormatter(UserProfile userProfile) {
        sorter = new DataSorter();
        this.colleges = sorter.getCollegeReccomendations(userProfile);
    }

    public String getCollegeName(int index) {
        return colleges.get(index).getName();
    }

    public float getCollegeGPA(int index) {
        return colleges.get(index).getGPA();
    }

    public long getCollegeACT(int index) {
        return colleges.get(index).getACT();
    }

    public long getCollegeSAT(int index) {
        return colleges.get(index).getSAT();
    }

    public ArrayList<String> getCollegeMajors(int index) {
        return colleges.get(index).getMajors();
    }

    public double getCollegePPS(int index) { // price per semester
        return colleges.get(index).getPPS();
    }

    public double getCollegeLocation(int index) {
        return colleges.get(index).getPPS();
    }

    public int size() {
        return this.colleges.size();
    }

}
