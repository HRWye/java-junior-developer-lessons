package ru.itmo.lessons.lesson22;

public class Application {
    public static void main(String[] args) {
        Controller green = new Controller("green", 100);
        Controller yellow = new Controller("yellow", 300);
        Controller red= new Controller("red", 600);

        Sensor sensor = new Sensor();
        sensor.addListener(green);
        sensor.addListener(yellow);
        sensor.addListener(red);
    }


}
