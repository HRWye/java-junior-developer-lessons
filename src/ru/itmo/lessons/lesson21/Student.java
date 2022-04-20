package ru.itmo.lessons.lesson21;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Exam> examList = new ArrayList<>();

    public void addExam(Exam exam){
        examList.add(exam);
    }

    public void printExamInfo(){
        examList.forEach(System.out::println);
    }

    public Student(String name) {
        this.name = name;
    }

    //Вложенный класс - статический
    //1. внешний класс не может быт статическим
    //2. область видимости - согласно модификаторам
    //3. можно создавать без объектов внешнего класса
    //4. нет доступа к нестатическим свойствам и методам внешнего класса
    public static class Exam{
         private String title;
         private int mark;

         public Exam(String title){
             this.title=title;
         }

         public void setMark(int mark){
             this.mark = mark;
         }


    }
}
