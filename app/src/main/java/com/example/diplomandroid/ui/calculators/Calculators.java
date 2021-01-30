package com.example.diplomandroid.ui.calculators;

public class Calculators {

    private int imageResource;
    private int name;
    private int description;

    public Calculators(int imageResource, int name, int description) {
        this.imageResource = imageResource;
        this.name = name;
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}
