package ru.itmo.lessons.lesson14;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        // 0 - объекты равны, то есть this равен о
        //-1 - this меньше чем объект о
        // 1 - this больше чем объект о
        return Integer.compare(this.getAge(), o.getAge());
    }
}
    class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
    class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
