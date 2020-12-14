package com.example.testapplication;

public class Register {
    private String courses;
    private int hours;
    private int fees;

    public Register(String courses, int hours, int fees) {
        this.courses = courses;
        this.hours = hours;
        this.fees = fees;
    }

    public String getCourses() {
        return courses;
    }

    public int getHours() {
        return hours;
    }

    public int getFees() {
        return fees;
    }


    public void setCourses(String courses) {
        this.courses = courses;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

}
