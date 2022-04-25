package ru.itmo.lessons.lesson23;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class FromConsoleToStrings extends Thread {

    private CopyOnWriteArrayList<String> strings;

    public FromConsoleToStrings(CopyOnWriteArrayList<String> strings) {
        this.strings=strings;
    }

    @Override
    public void run() {
        System.out.println("Задание 1");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<5; i++){
        String fromConsole = sc.nextLine();
        strings.add(fromConsole);}
        System.out.println(strings);
    }
}
