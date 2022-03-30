package ru.itmo.lessons.lesson12.question;

import java.util.Arrays;

public class Storage {
    private String[] strings;
    private int numb;

    public Storage(int len) {
        if (len < 1) {
            throw new IllegalArgumentException("Задайте размер массива");
        }
        strings = new String[len];
    }

    public void addString(String newString) {
        if (numb>3){
            System.out.println("В массиве больше нет места");
        }else{
        strings[numb] = newString;
        numb++;}
    }

    @Override
    public String toString() {
        return "Storage{" +
                "strings=" + Arrays.toString(strings) +
                '}';
    }
}
