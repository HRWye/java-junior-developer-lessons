package ru.itmo.lessons.lesson13.bonded;

public class Car extends Vehicle implements Repair{
    private final int num;

    public Car(String color, String company, int condition, int num) {
        super(color, company, condition);
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public void repair() {
        this.condition = this.getCondition() + 2;
        System.out.println("Автомобиль с номером " + num + " отремонтирован");
    }
}
