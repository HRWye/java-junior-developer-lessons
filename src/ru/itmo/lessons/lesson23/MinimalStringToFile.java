package ru.itmo.lessons.lesson23;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public class MinimalStringToFile extends Thread{

    private CopyOnWriteArrayList<String> strings;
    private File file;

    public MinimalStringToFile(CopyOnWriteArrayList<String> strings, File file) {
        this.strings=strings;
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println("Задание 2");
      String minimalString = strings.stream()
               .min(((o1, o2) -> (int)(o1.length()- o2.length())))
               .orElse("базовое минимальное слово");

        try (FileOutputStream fileOutput = new FileOutputStream(file,true)){
                    fileOutput.write(minimalString.getBytes());
        } catch (IOException e) {
            System.out.println("Проблемы с записью в файл");
        }
        System.out.println("Слово в файл записано");
    }
}
