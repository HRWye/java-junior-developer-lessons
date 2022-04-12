package ru.itmo.lessons.lesson17;

import ru.itmo.lessons.lesson16.education.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectrosAPI {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>(Course.getInstances(20));
        // TODO 1: Создать мапу,
        //  где ключи - названия курсов,
        //  значения - списки курсов с указанным в ключе названием
        Map<String, List<Course>> map1 = courses.stream()
                .collect(Collectors.groupingBy(Course::getName));//groupingBy(Function<? super T,? extends K> classifier) - возвращают экземпляр Collector,
                                                                 // позволяющий разделить коллекцию и вернуть Map<N, List>, где T - тип последнего стрима, N - значение разделителя.
                                                                 //Возвращает в виде ключа то что передалось вместе со ссылкой на метод, в виде значения формирует элементы с одинаковыми ключами

        // TODO 2: Создать мапу,
        //  где ключи - продолжительность курсов,
        //  значения - списки курсов с указанной
        //  в ключе продолжительностью
        Map<Integer, ArrayList<Course>> map2 = courses.stream()
                .collect(Collectors.groupingBy(Course::getDuration,
                        Collectors.toCollection(ArrayList::new)));//по умолчанию groupingBy формирует просто List, именно поэтому мы дополнительно указываем, что нужен ArrayList

        // TODO 3: Создать мапу, где ключи - названия курсов,
        //  значения - количество курсов с указанным в ключе названием
        Map<String, Long> map3 = courses.stream()
                .collect(Collectors.groupingBy(Course::getName,
                        Collectors.counting()
                        ));

        // TODO 3: Создать мапу, где ключи - названия курсов,
        //  значения - средняя стоимость курсов
        //  с указанным в ключе названием
        Map<String, Double> map4 = courses.stream()
                .collect(Collectors.groupingBy(Course::getName,
                        Collectors.averagingDouble(Course::getPrice)
                ));

        // TODO 4: Создать мапу, где ключи - названия курсов,
        //  значения - мапа,
        //  в которой  ключи - продолжительность курса,
        //  а значения - списки курсов с указанной в ключе продолжительностью
        Map<String, Map<Integer, List<Course>>> map5 = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getName,
                        Collectors.groupingBy(Course::getDuration)
                ));
    }
}
