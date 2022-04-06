package ru.itmo.lessons.lesson13.methods;

public class UtilsApp {
    public static void main(String[] args) {
        String[] strings = {"sad","asd","aasd"};
        String string = "sad";
        System.out.println(CustomUnits.inArray(strings,string));
        //после запуска начнется процесс компиляции и в это время <T> преобразуется в Object
        System.out.println(CustomUnits.<String>inArray(strings,string));
        //перед именем метода мы можем конкретизировать какой тип мы передаем (необязательно)
        /*System.out.println(CustomUnits.<String>inArray(strings,1));
        указав тип, команда будет "ругаться" если мы передадим переменные не типа <>*/

        System.out.println(CustomUnits.compareHash(12,12));
        //System.out.println(CustomUnits.<Number, String>compareHash(12,"12"));

    }
}
