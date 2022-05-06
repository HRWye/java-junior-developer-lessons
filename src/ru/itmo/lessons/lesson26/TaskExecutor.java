package ru.itmo.lessons.lesson26;

import java.util.List;
import java.util.concurrent.*;

public class TaskExecutor {
    public static void main(String[] args) {
        // Пул потоков - реализация порождающего паттерна проектирования - 'объектный пул'

        // пул потоков: [thread1, thread2, thread3]
        // очередь задач: [task1, task2, task3, task4, task5]: пулу не надо передавать задачи связанные с бесконечными циклами и вводом данных от пользователя
        // из пула берутся потоки и они начинают выполнять задачи из очереди

        //пул потоков можно создать свой или взять уже реализованные

        // Пул можно создать (уже реализованные):
        // 1. фиксированного размера (количество потоков указывается при создании и не меняется)
        // 2. гибкого размера (указать минимальное и максимальное количество потоков): если минимальное количество поток не вывозят все задачи, то создаются новые, до максимального количества
        // 3. пул для выполнения задач с указанным интервалом
        // 4. можно расширить существующий класс (пул потоков) для более гибкой настройки
        // 5. можно имплементировать интерфейс пула потоков

        // пул потоков: [thread1, thread2]
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 7; i++) {
            int iValue = i;
            // void execute(Runnable command);
            // метод execute передает задачу в очередь на выполнение
            fixedPool.execute(()->{
                System.out.println("Выполнение задачи № " + iValue);
            });
        }

        fixedPool.execute(()->{System.out.println("Выполнение задачи № 1");});
        fixedPool.execute(()->{System.out.println("Выполнение задачи № 2");});
        fixedPool.execute(()->{System.out.println("Выполнение задачи № 3");});
        fixedPool.execute(()->{System.out.println("Выполнение задачи № 4");});
        fixedPool.execute(()->{System.out.println("Выполнение задачи № 5");});

        //после выполнения задач, пул начинает ждать выполнения новых задач

        // fixedPool.shutdown(); // завершает текущие задачи из очереди и не принимает новые
        // к пулу нельзя обратиться повторно

        // прерывает выполнение задач, возвращает список с невыполненными задачами
        // не принимает новые, к пулу нельзя обратиться повторно
        List<Runnable> runnables = fixedPool.shutdownNow();
        System.out.println(runnables.size());

        // пул на 1 поток
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        singlePool.execute(() -> {
            System.out.println("Task 1");
        });
        singlePool.execute(() -> {
            System.out.println("Task 2");
        });
        singlePool.shutdownNow();

        ScheduledExecutorService everySevenSecond = Executors.newSingleThreadScheduledExecutor();
        everySevenSecond.scheduleAtFixedRate( // метод не берет в расчет время выполнения задачи
                () -> { // Runnable command - задача, которая выполняется
                    System.out.println("scheduleAtFixedRate task");//время выполнения задачи не должен превышать период
                },
                0, // long initialDelay - первоначальное время ожидания перед началом выполнения
                7, // long period - задача запускается на выполнение каждые 7
                TimeUnit.SECONDS // TimeUnit unit - секунд
        );
        // можно завершить вызовом метода shutdown

        ScheduledExecutorService everyThreeSecond = Executors.newSingleThreadScheduledExecutor();
        everyThreeSecond.scheduleWithFixedDelay( // метод берет в расчет время выполнения задачи
                () -> { // Runnable command - задача, которая выполняется
                    try {
                        Thread.sleep(5000);
                        System.out.println("scheduleWithFixedDelay task");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                0, // long initialDelay - первоначальное время ожидания перед началом выполнения
                3, // long period - задача запускается на выполнение каждые 3
                TimeUnit.SECONDS // TimeUnit unit - секунд после завершения предыдущей
        );
        // можно завершить вызовом метода shutdown

        // отложенное выполнение
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.schedule(
                () -> { // Runnable command - задача, которая выполняется
                    System.out.println("scheduledExecutor task");
                },
                10, // long delay - время ожидания перед началом выполнения задачи
                TimeUnit.SECONDS // например, в секундах
        );
        scheduledExecutor.shutdown();

        ExecutorService lessonPool = new LessonExecutor(
                2,
                7,
                20, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        lessonPool.execute(()->{
            try {
                Thread.sleep(2000);
                System.out.println("lessonPool 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        lessonPool.execute(()->{
            System.out.println("lessonPool 2");
        });
        lessonPool.shutdown();
    }
}