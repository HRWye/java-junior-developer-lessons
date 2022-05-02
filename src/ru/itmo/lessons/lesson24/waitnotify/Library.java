package ru.itmo.lessons.lesson24.waitnotify;

import java.util.ArrayList;

//Object
//wait() - приостанавливает работу потока, до тех пор пока поток не будет разбужен вызовом метода notify из другого потока
//wait(млс)
//потоки могут проснуться сами оп себе

//notify();notifyAll(); - возобновляет работу потока, который был приостановлен. Нельзя указать какой поток должен возобновить работу.

//можно вызвать только в synchronized методе или блоке
public class Library {
    private ArrayList<Book> books = new ArrayList<>(6);

    public synchronized void putBook(Book book) throws InterruptedException {
       // if (books.size()>5) wait();
        while (books.size()>5){
            wait();//записывать нужно вот в цикле while, так как это профилактика от самопроизвольного пробуждения потока
        }
        books.add(book);
        System.out.println("Книга добавлена, всего книг: " + books.size());
        notifyAll();
    }

    public synchronized Book getBook() throws InterruptedException {
        while (books.size()==0){
            wait();
        }
        Book book = books.remove(0);
        System.out.println("Удалена книга, всего книг: " + books.size());
        notifyAll();
        return book;
    }

    static class Book{}
}
