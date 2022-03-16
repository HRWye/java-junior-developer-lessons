package ru.itmo.lessons.lesson6.books;

public class Shelf {
    private String color = "белый";//цвет полки
   public Book[] books = new Book[10];//книги

    //метод добавления книги на полку
    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {books[i] = book;
            return;}//завершает целиком метод, а break завершает только цикл
        }
        System.out.println("Нет места");
    }
//метод добавления нескольких книг на полку
    public void addBook(Book...books){

    }
}

