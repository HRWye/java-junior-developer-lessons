package ru.itmo.lessons.lesson25;

import java.util.concurrent.ArrayBlockingQueue;

public class ReadThread implements Runnable{
        private ArrayBlockingQueue<Message> messages;

        public ReadThread(ArrayBlockingQueue<Message> messages) {
            this.messages = messages;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // удаляет и возвращает первый элемент очереди
                    // поток блокируется, если в очереди нет элементов
                    // до тех пор, пока они там не появятся
                    Message message = messages.take();
                    System.out.println("ReadThread: " + message);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
