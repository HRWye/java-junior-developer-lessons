package ru.itmo.lessons.lesson25;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Task implements Delayed {
    // инструкции, которые нужно выполнить в отдельном потоке
    private Runnable action;
    private LocalDateTime time; // когда инструкции дб выполнены

    public Task(Runnable action, LocalDateTime time) {
        this.action = action;
        this.time = time;
    }

    public Runnable getAction() {
        return action;
    }

    @Override // метод необходим, чтобы выяснить, можно ли извлечь
    // элемент методом take().
    // Если метод вернет 0 или отрицательное число, значит элемент
    // можно извлечь из очереди.
    public long getDelay(TimeUnit unit) {
        return unit.convert(
                Duration.between(LocalDateTime.now(), time).getSeconds(),
                TimeUnit.SECONDS);
    }

    @Override // элементы в очереди будут храниться
    // в отсортированном порядке
    public int compareTo(Delayed o) {
        LocalDateTime other = ((Task) o).time;
        return this.time.compareTo(other);
    }
}
