package ru.itmo.lessons.lesson24.waitnotify;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>(6);

    public void putBook(Book book) {
        books.add(book);
        System.out.println("Книга добавлена, всего книг: " + books.size());
    }

    public Book getBook() {
        Book book = books.remove(0);
        System.out.println("Удалена книга, всего книг: " + books.size());
        return book;
    }

    static class Book{}
}
