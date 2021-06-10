package com.example.schoolapp;

import androidx.annotation.NonNull;

public class Report {
    private String study;
    private int maths;
    private int science;
    private int social;
    private int hindi;
    private int english;
    private int computer;
    private String total;

    public Report(String study, int maths, int science, int social, int hindi, int english, int computer, String total) {
        this.study = study;
        this.maths = maths;
        this.science = science;
        this.social = social;
        this.hindi = hindi;
        this.english = english;
        this.computer = computer;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Report{" +
                "study='" + study + '\'' +
                ", maths=" + maths +
                ", science=" + science +
                ", social=" + social +
                ", hindi=" + hindi +
                ", english=" + english +
                ", computer=" + computer +
                ", total='" + total + '\'' +
                '}';
    }

    public String getStudy() {
        return study;
    }

    public int getMaths() {
        return maths;
    }

    public int getScience() {
        return science;
    }

    public int getSocial() {
        return social;
    }

    public int getHindi() {
        return hindi;
    }

    public int getEnglish() {
        return english;
    }

    public int getComputer() {
        return computer;
    }

    public String getTotal() {
        return total;
    }
}

