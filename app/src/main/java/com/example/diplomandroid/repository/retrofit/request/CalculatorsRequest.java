package com.example.diplomandroid.repository.retrofit.request;

public class CalculatorsRequest {
    private String gender;
    private double weight;
    private double height;
    private double age;
    private String loadFactor;

    public CalculatorsRequest(double weight) {
        this.weight = weight;
    }

    public CalculatorsRequest(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public CalculatorsRequest(double height, String gender) {
        this.height = height;
        this.gender = gender;
    }

    public CalculatorsRequest(String gender, double weight, double height, double age, String loadFactor) {
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.loadFactor = loadFactor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(String loadFactor) {
        this.loadFactor = loadFactor;
    }
}
