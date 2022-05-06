package ru.itmo.lessons.lesson26;

import ru.itmo.lessons.lesson25.Message;

import java.util.concurrent.Callable;

// используется совместно с пулами из пакета concurrent,
// не может быть передан в конструктор Thread
public class MessageGenerator implements Callable<Message> {

    @Override
    public Message call() throws Exception {
        // инструкции, которые должны выполнятся в отдельном потоке
        Thread.sleep((long) (Math.random() * 3000));
        String[] strings = {"сообщение 1", "сообщение 2", "сообщение 3"};
        String text = strings[(int)(Math.random() * strings.length)];
        Message message = new Message(text);
        System.out.println("Сообщение создано / получено " + message);
        return message;
    }
}