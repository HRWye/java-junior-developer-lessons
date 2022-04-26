package ru.itmo.lessons.lesson23;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class JoinThreads {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>();

        Thread task1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task1 обработал данные");
            integers.add(5000);
        });
        Thread task2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task2 обработал данные");
            integers.add(3000);
        });
        Thread task3 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные");
            int userNum = scanner.nextInt();
            System.out.println("task3 обработал данные");
            integers.add(userNum);
        });

        task1.start();
        task2.start();
        task3.start();

        // основной поток должен ждать,
        // пока завершаться другие потоки: task1, task2, task3
        try {
            task1.join();
            task2.join();
            task3.join(10000);
        } catch (InterruptedException e) {

        }

        System.out.println("main " + integers);
    }
}