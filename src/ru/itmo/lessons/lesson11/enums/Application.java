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


    }
}
