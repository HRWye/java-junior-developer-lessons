package ru.itmo.lessons.lesson17;

import ru.itmo.lessons.lesson16.education.Course;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**Stream API
 Предоставляет набор методов для работы с данными, как с потоком.
 Позволяет представить различные наборы данных в виде потока, а далее: сортировать их, фильтровать, осуществлять поиск по различным критериям и т.д.,
 кроме этого позволяет создавать новые потоки, создавать коллекции и мапы из текущего потока данных.

 Особенности работы со Stream API:
 1. Stream никогда НЕ ХРАНИТ ДАННЫЕ
 2. Для сохранения данных из Stream нужно использовать специальные методы.
 3. Stream никогда НЕ ИЗМЕНЯЕТ ИСТОЧНИК (коллекцию, массив и тд), из которого он создан, все преобразования происходят только в потоках.
 4. В своей работе методы stream используют лямбда выражения.

 Для работы с потоками данных необходимо:
 1. Получить данные в виде потока - объект типа Stream
 2. Выполнить промежуточные операции с потоком данных (промежуточные операции обрабатывают данные и возвращают Stream объект)
 3. Выполнить терминальную (конечную) операцию (терминальная операция обрабатывает данные и завершает работу потока) Без терминальной операции промежуточные операции не начнут выполняться!!!*/

public class StreamAPI {
    public static void main(String[] args) {
        // TODO 1: Создать поток целых чисел (-560, 312, 12, -1, 45, 0, 0, 23, -2, 221)
        //  - оставить в потоке только отрицательные элементы
        //  - выбрать 5 первых элементов
        //  - возвести каждый элемент в квадрат
        //  - вывести каждый элемент в консоль
        Stream<Integer> integerStream1 = Stream.of(-560, 312, 12, -1, 45, 0, 0, 23, -2, 221);//метод of добавляет элементы в поток
        /**Конвейерные методы для выполнения промежуточных операций:*/
        integerStream1.filter(num -> num<0)//filter(Predicate<? super T> predicate) - возвращает поток (Stream) с теми объектами, которые удовлетворяют условию;
                .limit(5)//limit(long maxSize) - возвращает поток (Stream), состоящий из объектов не превышающих maxSize;
                .map(num -> num*num)//map(Function<? super T, ? extends R> mapper) - возвращает поток (Stream), состоящий из обработанных функцией объектов;
        /**Терминальные методы для выполнения конечных операций: после этой операции поток закрывается и обратиться к нему будет уже нельзя*/
                .forEach(System.out::println/*=elem->System.out.println(elem)*/);/*forEach(Consumer<? super T> action) применяет переданный метод (action) к каждому объекту потока (Stream),
                                             порядок обработки при параллельном выполнении не гарантируется;*/

        // TODO 2: Создать поток целых чисел (-6, 45, 12, -77, 77, 45, 6, -6, 0, 0, 12)
        //  - оставить в потоке только уникальные элементы
        //  - отсортировать в натуральном порядке (по возрастанию)
        //  - вывести каждый элемент в консоль
        Stream<Integer> integerStream2 = Stream.of(-6, 45, 12, -77, 77, 45, 6, -6, 0, 0, 12);
        integerStream2.distinct()//distinct() - возвращает поток (Stream), состоящий из уникальных объектов (для сравнения использует метод equals объектов);
                .sorted()//sorted() возвращает поток (Stream) отсортированных объектов;
                .forEach(System.out::println);

        // TODO 3: anyMatch, allMatch, noneMatch - терминальные методы
        //  - создать поток целых чисел (411, 7, 90, -1000, 0, 2, 71) и
        //    проверить, есть ли в потеке элемент со значением 0
        //  - создать поток целых чисел (411, 7, 90, -1000, 0, 2, 71) и
        //    проверить, состоит ли поток из только положительных элементов
        //  - создать поток целых чисел (411, 7, 90, -1000, 0, 2, 71) и
        //    проверить, что в потоке нет значений больше 10_000

        integerStream1 = Stream.of(411, 7, 90, -1000, 0, 2, 71);
        System.out.println(integerStream1.anyMatch(num->num==0));//anyMatch(Predicate<? super T> predicate) - возвращает true, если хотя бы один элемент потока соответствует условию;

        integerStream1 = Stream.of(411, 7, 90, -1000, 0, 2, 71);
        System.out.println(integerStream1.allMatch(num->num>0));//allMatch(Predicate<? super T> predicate) - возвращает true, если все элементы потока соответствуют условию;

        integerStream1 = Stream.of(411, 7, 90, -1000, 0, 2, 71);
        System.out.println(integerStream1.noneMatch(num->num>10_000));//noneMatch(Predicate<? super T> predicate) - возвращает true, если ни один элемент потока не соответствует условию;

        // TODO 4: findFirst - взять первый | findAny - взять произвольный - терминальные методы
        //  возвращает элемент потока Optional<T> - null safe container
        String[] colors = {"white", "black", "red", "yellow", "yellowgreen"};
        String color = Arrays.stream(colors).findFirst().get();//.get() возвращает ссылку на элемент
        color = Arrays.stream(colors).findFirst().orElse("yellow");//.orElse() - если null, то вернет значение по умолчанию в ()
        boolean isPresent = Arrays.stream(colors).findFirst().isPresent();//isPresent() - возвращает true если не null

        // TODO 5: Создать поток из элементов массива colors
        //  - пропустить 2 первых элемента
        //  - оставить в потоке только цвета, начинающиеся на 'y'
        //  - вывести каждый элемент в консоль
        Arrays.stream(colors).skip(2)//skip(long n) - пропускает n первых элементов, возвращает поток (Stream), состоящий из оставшихся элементов (или пустой Stream);
                .filter(elem->elem.startsWith("y"))
                .forEach(System.out::println);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());

        // TODO 6: Создать поток из элементов списка course
        //  и выбрать минимальный по стоимости курс, вывести курс в консоль
        Course minByPrice = courses.stream()
                .min(((o1, o2) -> (int)(o1.getPrice()- o2.getPrice())))
                .orElse(Course.getInstance());
        System.out.println(minByPrice);

        // TODO 7: Создать поток из элементов списка course
        //  и выбрать максимальный по продолжительности курс,
        //  вывести курс в консоль
        Course maxByDuration = courses.stream()
                .max(Comparator.comparing(Course::getDuration))
                .orElse(Course.getInstance());
        System.out.println(maxByDuration);

        // TODO 7: на основе списка курсов получить
        //  массив курсов дороже 20000
        //  В итоге должен получиться массив Course[]
        Course[] courseArr = courses.stream()
                .filter(course -> course.getPrice()>20_000)
                //.toArray(); по умолчанию создаст массив из элементов типа Object
                .toArray(Course[]::new);//в () передали ссылку на конструктор, чтобы элементы массивы были элементами класса Course

        // TODO 8: увеличить стоимость
        //  каждого курса с продолжительностью более
        //  3х месяцев на 5000 (из списка course)
        //  В итоге должен получиться List<Course>
        //  map(function) (после выполнения операций возвращает измененный элемент) - peek(consumer) (после выполнения операций не возвращает измененный элемент)
        List<Course> courseList = courses.stream()
                .filter(course -> course.getDuration()>3)
                .peek(course -> course.setPrice(course.getPrice()+5000))
                .collect(Collectors.toList());//для создания списка
              //.collect(Collectors.toSet());
              //.collect(Collectors.toCollection(ArrayList::new));new - ссылка на конкретную коллекцию

        colors = new String[]{"blue", "orange", "brown", "white"};
        // TODO 11:  на основе массива colors создать
        //  мапу Map<String, Integer>,
        //  где ключи - элементы массива,
        //  значения - размер элемента массива
        Map<String, Integer> map = Arrays.stream(colors)
                .collect(Collectors.toMap(
                        Function.identity(),//ключи (ключи=элементы потока, либо используем  elem -> elem)
                        elem->elem.length(),//значение
                        (elem1,elem2)->elem1//// как формировать значения, если ключи одинаковые
                ));

        String[][] strings = {
                {"45", "78", "-90", "0", "1", "1"},
                {"441", "14", "14", "28"},
                {"122", "-6", "10", "50"},
        };
        // map - flatMap
        // TODO 12: В каждом вложенном массиве оставить
        //  только уникальные элементы,
        //  отсортировать каждый вложенный массив.
        //  В итоге должен получиться массив String[][]
        String[][] strings1 = Arrays.stream(strings)
                .map(elem->Arrays.stream(elem)
                                 .distinct()
                                 .sorted()
                                 .toArray(String[]::new))
                .toArray(String[][]::new);
        System.out.println(Arrays.deepToString(strings1));

        // TODO 13: На основе массива strings создать
        //  одномерный массив уникальных элементов,
        //  массив отсортировать.
        //  В итоге должен получиться массив String[]
        String[] strings2 = Arrays.stream(strings)
                .flatMap(elem->Arrays.stream(elem)
                                     .distinct()
                                     .sorted())
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings2));
    }
}
