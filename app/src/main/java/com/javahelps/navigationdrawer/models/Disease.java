package com.javahelps.navigationdrawer.models;


public class Disease {

    int id;
    String name;
    String description;
    String symptoms;
    String prevention;
    String medicine;

    public Disease() {

    }


    public Disease(int id, String name, String description, String symptoms, String prevention, String medicine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.symptoms = symptoms;
        this.prevention = prevention;
        this.medicine = medicine;
    }

    public Disease(String name, String description, String symptoms, String prevention, String medicine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.symptoms = symptoms;
        this.prevention = prevention;
        this.medicine = medicine;
    }

    public String getMedicine() {
        return medicine;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getPrevention() {
        return prevention;
    }

    public String getDescription() {
        return description;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
}
