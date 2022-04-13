package ru.itmo.lessons.lesson18;




import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {

        // Используя Stream API:
        List<Pupil> pupils = new ArrayList<>(Arrays.asList(
                new Pupil(1, "Женя", Pupil.Gender.MALE, LocalDate.now().minusYears(10)),
                new Pupil(2, "Олег", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(3, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Pupil(4, "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(12)),
                new Pupil(5, "Алексей", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(6, "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(7, "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(17)),
                new Pupil(8, "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(5)),
                new Pupil(9, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Pupil(10, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Pupil(11, "Григорий", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(12, "Ирина", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, List<Pupil>> byGender = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));

        // 2. Найти средний возраст учеников
        double avgAge = pupils.stream()
                .mapToInt(pupil->LocalDate.now().getYear() - pupil.getBirth().getYear())//mapToInt(ToIntFunction<? super T> mapper),
                // mapToDouble(ToDoubleFunction<? super T> mapper),
                // mapToLong(ToLongFunction<? super T> mapper) - аналог метода map, но возвращают числовой поток (Stream);
                .average().orElse(0);
        System.out.println(avgAge);

        // 3. Найти самого младшего ученика
        Pupil minAge = pupils.stream().min(Comparator.comparing(Pupil::getBirth)).orElse(null);
        System.out.println(minAge);

        // 4. Найти самого старшего ученика
        Pupil maxAge = pupils.stream().max(/*(p1,p2)->p2.getBirth().compareTo(p1.getBirth)*/Comparator.comparing(Pupil::getBirth)).orElse(null);
        System.out.println(maxAge);

        // 5. Собрать учеников в группы по году рождения
        Map<Integer, List<Pupil>> byBirth = pupils.stream()
                .collect(Collectors.groupingBy(pupil -> pupil.getBirth().getYear()));
        System.out.println(byBirth);

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        Collection<Pupil> uniqueByName = pupils.stream()
                .collect(Collectors.toMap(
                        Pupil::getName,
                        Function.identity(),
                        ((pupil, pupil2) -> pupil)//какое значение выбрать, если ключи одинаковые
                )).values();
        uniqueByName.forEach(pupil -> System.out.println(pupil.getName() + ": " + pupil.getBirth()));

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        pupils.sort(
                Comparator.comparing(Pupil::getGender)
                        .thenComparing(Pupil::getBirth)
                        .thenComparing(Pupil::getName).reversed()
        );
        System.out.println(pupils);

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        int from = 10;
        int to = 10;
        pupils.forEach(
                pupil -> {
                    if (pupil.getBirth().getYear()>to && pupil.getBirth().getYear() < from){
                        System.out.println(pupil);
                    }
                }
        );

        // 9. Собрать в список всех учеников с именем=someName
        List<Pupil> pupilsByName = pupils.stream()
                .filter(pupil -> pupil.getName().equals("Петр"))
                .collect(Collectors.toList());/*toList()*/

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> genderCount = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.summingInt(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear())));
        System.out.println(genderCount);
    }
}