package ru.itmo.lessons.lesson13.bonded;

public class Bicycle extends Vehicle implements Repair{
    private final Type type;

    public Bicycle(String color, String company, int condition, Type type) {
        super(color, company, condition);
        this.type = type;
    }

    @Override
    public void repair() {
        this.condition = this.getCondition() + 1;
        System.out.println("Велосипед типа " + type + " отремонтирован");
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MOUNTAIN, CITY
    }
}
