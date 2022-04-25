package ru.itmo.lessons.lesson23;

public class MyTask implements Runnable {

    @Override
    public void run() {
        //System.out.println(this.getName());/*возвращение имени потока**//*==**/
        /**этот метод не доступен потому что нет наследования от Thread*/


        System.out.println(Thread.currentThread()/*возвращает ссылку на поток**/.getName());
    }
}
