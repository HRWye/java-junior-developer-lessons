package ru.itmo.lessons.lesson16;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    private static void run(Operation operation, double x, double y){
        double res = operation.execute(x, y);
        System.out.println("Результат: "+res);

    }
    public static void main(String[] args) {


        // TODO:: объявить интерфейс Operation с одним абстрактным методом,
        //  который принимает на вход два числа с плавающей точкой и возвращает число с плавающей точкой

        /*public interface Operation {
           double execute (double a, double b);}*/

        // TODO:: написать несколько реализаций абстрактного метода

        Operation plus = (first, second) ->/*return*/ first + second;//если нет фигурных скобок, то можно не писать return
        Operation div = (first,second) -> {
            if (second==0) return 0;
            return first/second;
        };//если фигурные скобки есть, то return необходим
        //если метод принимает на вход один аргумент, то фигурные скобки можно не ставить
        //тип данных и возвращаемых значений можно не указывать, они берутся из контекста (из интерфейса)
        //если тело метода состоит из одной инструкции, то фигурные скобки можно не ставить
        System.out.println(plus.execute(34,78));
        System.out.println(div.execute(45,1));

        run(plus, 5.7,5.2);
        run(div, 5.8,5.1);

        // Predicate
        // TODO:: написать реализации метода test:
        //  - проверка на положительное число
        //  - проверка на отрицательное число
        //  - проверка на четное число

        Predicate<Integer> isPos = x->x>0;
        Predicate<Integer> isNeg = x->x>0;
        Predicate<Integer> isEven = x -> x%2==0;

        System.out.println(isPos.test(-67));
        System.out.println(isNeg.test(-67));
        System.out.println(isEven.test(-67));

        System.out.println(isPos.and(isEven).test(68));
        System.out.println(isNeg.or(isEven).test(0));

        // Function
        // TODO:: написать реализации метода apply:
        //  - уменьшение целого числа на 20%
        //  - увеличение числа в два раза
        //  - добавление к положительному числу символов " p."

        Function<Integer, Double> min20Per = x -> x*0.8;
        Function<Integer, Integer> x2 = x -> x*=x;
        Function<Integer, String> addP = x -> x+" p.";

        System.out.println(min20Per.apply(100));
        System.out.println(x2.apply(2));
        System.out.println(addP.apply(5));
        System.out.println(x2.andThen(min20Per).apply(45));

        // TODO:: написать generic метод, который
        //  принимает Predicate condition и 2 Function: trueFn и falseFn
        //  и возвращает Function, в зависимости от результата предиката
    }
}
