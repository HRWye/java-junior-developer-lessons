package ru.itmo.lessons.lesson13.methods;

public class CustomUnits {
    //типизированные методы = дженерик методы
    //метод который проверяет наличие элемента в массиве
    public static <T> boolean inArray(T[] arr, T element){
        //T - неизвестный тип
        //может быть статический и нестатический
        //<T> - значит что метод типизирован, тип неопределённый
        //T[] arr, T element - неопределенный массив и неопределенный элемент неопределенного, но одинакового типа
        if (arr==null||element==null){
            throw new IllegalArgumentException("не могут быть null");
        }
        for (T t : arr) {
            if(element.equals(t)) return true;
        } return false;
        //для элементов неизвестного типа данных можно вызывать только Object методы, потому что только они доступны для всех типов переменных
        //<T>-любой тип кроме примитивов
    }
    public static <T extends Number, K extends  Integer> int compareHash(T first, K second){
        //если метод собирается принимать разные типы данных, то мы пишем несколько букв
        //безтиповые данные <> наследуются от Number и Integer
        //при компиляции Т может быть Number и любым из родителей этого класса
        //при компиляции К может быть Integer и любым из родителей этого класса
        return Integer.compare(first.hashCode(), second.hashCode());
        //у first можно вызвать методы Number и его родителей
        //у second можно вызвать методы Integer и его родителей
    }
}
