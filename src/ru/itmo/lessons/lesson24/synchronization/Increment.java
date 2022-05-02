package ru.itmo.lessons.lesson24.synchronization;

public class Increment extends Thread {
    private SomeAccount account;

    public Increment(SomeAccount account){
        this.account=account;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //synchronized блок - блокирует монитор объекта из ()
        synchronized (account) {
            account.upBalance(10);
            //в {} не должно быть ничего что не связано с объектов ()
        }
    }
}
