package ru.itmo.lessons.lesson6;

import ru.itmo.lessons.lesson6.books.Author;
import ru.itmo.lessons.lesson6.books.Book;
import ru.itmo.lessons.lesson6.books.Shelf;

public class Application {
    /*полное имя класса складывается из имени пакета, где находится класс и самого имени класса
    ru.itmo.lessons.lesson6.Application - имя класса*/
    public static void main(String[] args) {
        //если строка образуется из строковых конкантинаторов, то подсчет идет во время компиляции

        /*У каждого объекта есть набор методов и набор свойств и характеристик
        1. создаем класс, где будем перечислять набор методов и характеристик будущих объектов
        класс = способ описания сущности, определяющий ее состояние и поведение
        на основе класса создаются объекты (экземпляры данного класса) - представители данного класса,
        имеющие конкретное состояние и поведение, определенное в классе
         */

        //в пакете books создаем новый класс и называем его Author

        //создаем объект, экземпляр класса Author
        Author author1=new Author();//среда автоматически импортирует класс, если они находятся в разных пакетах
        author1.name="Tom";//доступ к свойству объекта осуществляется через .
        author1.surname="Crowed";
        Author author2=new Author();
        author2.name="Mike";
        author2.surname="Thompson";
        //в памяти создано два отдельных экземпляра класса

        //вызов метода
        author1.printFullName();
        author2.printFullName();
        //производится вывод информации в консоль

        author1.getFullName();
        //здесь просто будет отдан результат конкатенации двух переменных

        String fullName=author1.getFullName();
        System.out.println(fullName);

        Book book1 = new Book();//это вызов конструктора
        //по умолчанию всегда есть конструктор даже если мы его не видим
        book1.setTitle("Книга");//когда в кавычках будет задана локальная переменная, мы передаем значение в public void setTitle(String titleValue){}
        System.out.println(book1.getTitle());
        book1.setPageCount(22);
        //book1.title="";
        //book1.pageCount=-34;

        Shelf shelf=new Shelf();
        shelf.addBook(book1);
        shelf.addBook(book1,book1,book1);
        //вывод имени автора первой книги на полке
        System.out.println(shelf.books[0].getAuthor().name);


    }
}
