package ru.itmo.lessons.lesson16.education;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class University {
    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        return courses.add(Objects.requireNonNull(course));
    }
    public boolean addCourses(List<Course> courses) {
        return courses.addAll(Objects.requireNonNull(courses));
    }

    public List<Course> getCourses() {
        return courses;
    }

    /** Принимает на вход predicate, возвращает новый список, состоящий из элементов, которые
    прошли проверку методом test*/
    public List<Course> getFilteredCourses(Predicate<Course> condition) {// условие для фильтрации
        List<Course> filtered = new ArrayList<>();
        for (Course course : courses) {
            if (condition.test(course))filtered.add(course);
        }
        return filtered;
    }
}
