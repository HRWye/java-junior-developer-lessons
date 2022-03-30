package ru.itmo.lessons.lesson11.enums;

public enum Planets {
    EARTH(50000,1243214,"Земля"), VENUS(15425435,12432, "Венера"), PLUTO(12343214,124321,"Плутон");
    private int mass;
    private int radio;
    private final String title;

    Planets(int mass, int radio, String title) {
        this.mass = mass;
        this.radio = radio;
        this.title = title;
    }

    public int getMass() {
        return mass;
    }
    public void setMass(int mass) {
        this.mass = mass;
    }
    public int getRadio() {
        return radio;
    }
    public void setRadio(int radio) {
        this.radio = radio;
    }
    public String getTitle() {
        return title;
    }
}
