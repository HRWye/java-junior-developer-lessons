package ru.itmo.lessons.lesson13.bonded;

abstract public class Vehicle {
    protected String color;
    protected String company;
    protected int condition;

    public Vehicle(String color, String company, int condition) {
        this.color = color;
        this.company = company;
        this.condition = condition;
    }

    public void changeColor(String newColor){
        this.color = newColor;
    }

    public String getColor() {
        return color;
    }

    public String getCompany() {
        return company;
    }

    public int getCondition() {
        return condition;
    }

    public static Vehicle getVehicle(String type){
        String[] colors = {"black", "white", "yellow", "orange"};
        String randColor = colors[(int) (Math.random() * colors.length)];

        String[] companies = {"A", "B", "C", "D"};
        String randCompany = companies[(int) (Math.random() * companies.length)];

        int randCond = (int) (Math.random() * 8);

        Vehicle vehicle = null;
        switch (type) {
            case "car":
                int randNum = (int) (500 + Math.random() * 400);
                vehicle = new Car(randColor, randCompany, randCond, randNum);
                break;
            case "bike":
                Bicycle.Type randType = Bicycle.Type.values()[(int) (Math.random() * Bicycle.Type.values().length)];
                vehicle = new Bicycle(randColor, randCompany, randCond, randType);
                break;
            case "train":
                int randCarCount = (int) (3 + Math.random() * 12);
                vehicle = new Train(randColor, randCompany, randCond, randCarCount);
                break;
        }
        return vehicle;
    }
}
