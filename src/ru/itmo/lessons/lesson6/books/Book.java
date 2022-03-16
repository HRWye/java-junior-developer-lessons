package ru.itmo.lessons.lesson6.books;

import java.util.Objects;

public class Book {
    /*свойства:
    название
    автор
    количество страниц
     */

    private String title;
    private int pageCount;
    private Author author;
    //если модификатор private стоит перед свойством и методом, это значит к свойству или методу можно обратится только в пределах класса создания в пределах{}
    //если при создании необходимо сразу задать свойство или выполнить определенные инструкции, то делаем конструктор

    public Book(){}//пустой конструктор
    public Book(Author author) {//непустой конструктор
        this.author=Objects.requireNonNull(author,"author не может быть null");//Objects.requireNonNull(переменная,"сообщение об ошибке")
    }
    //таким образом, мы задали два разных поведения при создании объекта
    public Book(String title, Author author){
         this(author);//вызываем другой конструктор
        setTitle(title);//вызываем метод setTitle и передаем ему значение title на проверку
    }
    //создали еще и третий вариант поведения

    //создаем методы, которые позволяют установить значения свойств со всеми необходимыми проверками = такие методы называются сеттеры
    //задача сеттера проверить значение которые хотим установить и, если проверка пройдена, установить это значение, обычно создаются с типом void
    public void setTitle(String titleValue){//чтобы метод был готов получить данные из вне, то в круглых скобках нужно перечислить аргументы которые способен будет принять метод
           if (titleValue==null||titleValue.length()<3){
               throw new IllegalArgumentException("Значение title от трех символов");//создание экземпляра ошибки, схоже с работой break
           }
           title = titleValue;
    }

    //методы, которые возвращают значения свойств - геттеры
    public String getTitle(){
        return title;
    }

    public void setPageCount(int pageCount){
        if (pageCount<10){
            throw new IllegalArgumentException("Значение pageCount от и больше 10");
        }
        this.pageCount=pageCount;//Если имена совпадают, то this. используется = ссылка на текущий объект
    }

    public int getPageCount() {
        return pageCount;
    }

    public Author getAuthor() {
        return author;
    }
}
