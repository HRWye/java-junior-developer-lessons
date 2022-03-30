package ru.itmo.lessons.lesson11.staticBlocks;

public class Util {
    public static int max;//это не характеристики объектов, это переменные которые хранятся внутри класса и принадлежат классу
    public static int min;
    public  final static double PI;//такие переменные обычно являются константами и пишутся большими буквами
//Иногда для инициализации мы используем сеттеры. Но есть и альтернативный способ - используя блоки инициализации.
    //Существует всего два типа блоков:
//нестатический (instance initializer)
//статический (class initializer)(представлен ниже):
    //инструкции выполняются один раз при загрузке класса
    //даже если в классе только статические свойства и методы, он все равно не статический, потому статик классы вложенные
    //в статическом блоке вызываются статические свойства и статические методы
    static {
        PI=3.14;
    }
    public static int random(int min,int max){//статический метод нельзя переопределить в дочернем классе, поэтому необязательно объявлять его final
        //из статического метода нельзя обратиться к нестатическим методам и свойствам;
        //нельзя обратиться к this.
        return (int)(min+Math.random()*(max-min));
    }
    //статические методы и переменные это не характеристики объектов!!!

    private Util() {
    }//пустой приватный конструктор сделан с целью невозможности создания объектов в мейн классе
}