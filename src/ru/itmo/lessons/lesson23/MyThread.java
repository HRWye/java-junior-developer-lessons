package ru.itmo.lessons.lesson23;

public class MyThread extends Thread {
    //в таком классе могут быть любые методы и свойства и конструкторы


    //инструкции которые описаны в run() будут выполняться в отдельном потоке
    @Override
    public void run() {
        System.out.println(this.getName());/*возвращение имени потока**//*==**/
        System.out.println(Thread.currentThread()/*возвращает ссылку на поток**/.getName());


    }
}
