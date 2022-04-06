package ru.itmo.lessons.lesson13.types;

public class GenericTypes {
    public static void main(String[] args) {
        User<String> stringUser = new User<>();//в <> можно указать каким типом данных является дженерик T
        stringUser.setId("123213");
        stringUser.setLogin("login");

        String sId = stringUser.getId();//если бы не указали конкретный тип данных, то тип данных был бы Object
        System.out.println(sId.startsWith("12"));

        User<Integer> integerUser = new User<>();
        integerUser.setId(454365);
        stringUser.setLogin("sghawe");

        Integer iId=integerUser.getId();
        System.out.println(iId>0);

        PairContainer<String, Integer> container1 = new PairContainer<>("a",1);
        System.out.println(container1.getKey());
        System.out.println(container1.getValue());

        PairContainer<String,User> container2 = new PairContainer<>("x",stringUser);
        Object oId =container2.getValue().getId();

        PairContainer<String,User<String>> container3 = new PairContainer<>("x",stringUser);
        String strId =container3.getValue().getId();

        PairContainer<Integer,User<Integer>> containerDop = new PairContainer<>(432,integerUser);
        PairContainer<Integer, PairContainer<Integer, User<Integer>>> container4 = new PairContainer<>(123, containerDop);

    }
}
