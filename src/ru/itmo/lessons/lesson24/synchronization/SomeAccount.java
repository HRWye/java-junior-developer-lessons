package ru.itmo.lessons.lesson24.synchronization;

public class SomeAccount {
    private  int balance;

    public int getBalance() {
        return balance;
    }

    public synchronized/*блокирует монитор объекта у которого вызывается данный метод*/ void upBalance(int count){
        balance+=count;
    }
}
