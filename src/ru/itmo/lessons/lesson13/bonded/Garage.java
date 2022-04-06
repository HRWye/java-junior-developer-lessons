package ru.itmo.lessons.lesson13.bonded;

/* T extends Vehicle - T может быть Vehicle и его наследники */
/* в классе у vehicle можно вызвать методы Vehicle */
/* T extends Vehicle & Repair */
/* в классе у vehicle можно вызвать методы Vehicle и Repair */
public class Garage<T extends Vehicle & Repair> {
    private T vehicle;

    public T getVehicle() {
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }
}
