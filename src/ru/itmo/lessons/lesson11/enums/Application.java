package ru.itmo.lessons.lesson11.enums;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Article article1 = new Article("Trip to Australia");//в этот момент устанавливается не только title, но и created
        article1.setCountry(Country.AUSTRALIA);//обратились в константановой переменной из перечисления
        System.out.println(article1.getCountry());//строковое представление перечисления выглядит как само перечисление

        Article article2 = new Article("Trip to UK");//в этот момент устанавливается не только title, но и created
        article1.setCountry(Country.UK);//обратились в константановой переменной из перечисления
        System.out.println(article1.getCountry());//строковое представление перечисления выглядит как само перечисление

        //получение массива констант
        Country[] countries=Country.values();// метод values() сгруппирует все в массив, в том же порядке в каком и в перечислении
        System.out.println(Arrays.toString(countries));
        //индекс перечисления элемента в массиве c помощью метода ordinal()
        System.out.println(Country.FRANCE.ordinal());

        for (Country country : countries) {
            System.out.println("country "+country.name());//метод name() выводит значение элемента массива перечисления в строковом виде
        }

        Country country = Country.valueOf("UK"); // метод valueOf("...") возвращает ссылку на элемент ("...") типа класса перечисления
        //name() - стринговое представление
        //valueOf("...") - ссылка на элемент класса перечисления

        Priority low = Priority.LOW;
        Priority low1 = Priority.LOW;//создали две ссылки на один объект
        System.out.println(low.getCode());
        low.setCode(2);
        System.out.println(low.getCode());


        Priority[] priorities =Priority.values();
        System.out.println(Arrays.toString(priorities));
        for (Priority priority : priorities) {
            System.out.print(priority.getCode()+", ");
        }

        int sumRes = Operation.SUM.action(2,3);
        System.out.println(sumRes);
        int multiRes = Operation.SUM.action(2,3);
        System.out.println(multiRes);

        Planets.PLUTO.setRadio(123213);
        Planets[] planets=Planets.values();
        for (Planets planet : planets) {
            System.out.println(planet.getTitle()+", "+planet.getMass()+", "+planet.getRadio());
        }
        //метод name() нельзя переопределить он final
        //метод toString() переопределить можно

        //по курсачу:
        //делать наследование в курсовой не нужно!!!
        //названия абонементов можно сделать перечислением
        //класс абонемент
        //класс который хранит информацию о владельце
        //класс фитнес (без метода main!!!), в нем 3 массива размером по 20 каждый, так же будет метод закрыться(в нем массив заполняется null, Arrays.fill()) + метод посещение,
        //который принимает на вход абонемент и желаемую зону посещения и в нем надо реализовать необходимые проверки
        //интерфейсов нет
        //в перечислении мы перечисляем только типы абонементов
        //в классе абонемент уже присваиваем эти типы
    }
}
