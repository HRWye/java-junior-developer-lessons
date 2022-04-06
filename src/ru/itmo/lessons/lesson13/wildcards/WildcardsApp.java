package ru.itmo.lessons.lesson13.wildcards;

import ru.itmo.lessons.lesson13.types.PairContainer;

public class WildcardsApp {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();

        PairContainer<Integer, Animal> container1 = new PairContainer<>(1,animal);
        PairContainer<Integer, Cat> container2 = new PairContainer<>(1,cat);
        PairContainer<Integer, Dog> container3 = new PairContainer<>(1,dog);

        WildcardsApp.<Animal>copyValue(container2,container1);
    }

    public static <T> void copyValue(
            PairContainer<Integer,? extends T> from,
            PairContainer<Integer,? super T> to
    ){
        //предположим что T Animal
        //? extends T - тип Animal и все потомки
        //? super T - тип Animal и все его родители
           to.setValue(from.getValue());
    }
}
