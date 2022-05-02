package ru.itmo.lessons.lesson25;

import java.util.concurrent.ArrayBlockingQueue;

public class WriteThread implements Runnable{
    private ArrayBlockingQueue<Message> messages;

    public WriteThread(ArrayBlockingQueue<Message> messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        String[] strings = {"сообщение 1", "сообщение 2", "сообщение 3"};
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000);
                String text = strings[(int)(Math.random() * strings.length)];
                Message message = new Message(text);
                // объект добавляется в конец очереди,
                // если очередь переполнена, поток блокируется до тех
                // пор, пока место в очереди не появится
                messages.put(message);
                System.out.println("WriteThread " + message);
            } catch (InterruptedException e)/*автоматически меняет свойство interrupt*/ {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
