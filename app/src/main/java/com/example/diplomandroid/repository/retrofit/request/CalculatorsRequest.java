package com.example.diplomandroid.repository.retrofit.request;

public class CalculatorsRequest {
    private String sex;
    private double weight;
    private double height;
    private double age;
    private int loadFactor;

    public CalculatorsRequest(double weight) {
        this.weight = weight;
    }

    public CalculatorsRequest(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public CalculatorsRequest(double height, String sex) {
        this.height = height;
        this.sex = sex;
    }

    public CalculatorsRequest(String sex, double weight, double height, double age, int loadFactor) {
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(int loadFactor) {
        this.loadFactor = loadFactor;
    }
}
