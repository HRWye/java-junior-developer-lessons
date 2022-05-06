package ru.itmo.lessons.lesson26;

import ru.itmo.lessons.lesson25.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService pool1 = Executors.newFixedThreadPool(3);

        Callable<Message> task = new MessageGenerator();//задача выполненная потоком из пула вернет результат своей работы

        ArrayList<Future<Message>> taskResults = new ArrayList<>();//и результат поместит в ArrayList

        for (int i = 0; i < 10; i++) {
            // добавляем задачу в очередь на выполнение
            // сообщаем, куда нужно передать результат работы потока
            // Future - контейнер, с результатом работы одного потока
            Future<Message> resultContainer = pool1.submit(task);
            taskResults.add(resultContainer);
            // void execute(Runnable command); - ничего не возвращает
            // <T> Future<T> submit(Callable<T> task) - возвращает объект типа Future<T>
        }
        // task1 -> container1
        // task2 -> container2
        // task3 -> container3
        // task4 -> container4

        /*
        for (Future<Message> taskResult : taskResults) {
            System.out.println("Ожидание получения данных");
            try {
                System.out.println("Сообщение из контейнера: " + taskResult.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool1.shutdown();*/

        for (Future<Message> taskResult : taskResults) {
            System.out.println("Ожидание получения данных");
            try {
                System.out.println("Сообщение из контейнера: " +
                        taskResult.get((long) (Math.random() * 2000), TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("Не смог дождаться результата");
            }
        }
        pool1.shutdown();

        ExecutorService pool2 = Executors.newFixedThreadPool(3);
        List<Callable<Message>> tasksList = new ArrayList<>();
        tasksList.add(new MessageGenerator());
        tasksList.add(new MessageGenerator());
        tasksList.add(new MessageGenerator());

        try {
            List<Future<Message>> resultsContainer = pool2.invokeAll(tasksList);
            pool2.shutdown();
            for (Future<Message> container : resultsContainer) {
                System.out.println("Сообщение " + container.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // задачу можно отменить future.cancel(true);
        // можно проверить, отменена ли задача future.isCanceled();
        // можно проверить, выполнена ли задача future.isDone();
    }
}