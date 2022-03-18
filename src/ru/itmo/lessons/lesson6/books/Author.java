package ru.itmo.lessons.lesson6.books;

public class Author {
    //у каждого объекта будут свойства name и surname
    public String name; //значение будет дано по умолчанию, то есть null
    //public - модификатор свойства, означающий, что к этому свойству можно обратится из любой точки программы
    public String surname;

    //методы
    //если метод просто выполняет инструкции и не возвращает никакого результата, то пишем void
    public void printFullName() {//{}-тело метода, т.е. когда к методу обратимся то будут выполнены инструкции в теле метода
        System.out.println(name + " " + surname);
    }

    //если метод что-то возвращает, то мы указываем что он будет возвращать
    public String getFullName() {
        return name + " " + surname;//return в непустых методах возвращает результат работы метода и прерывает работу метода
        //break для циклов, return для методов
        //return в void методах можно использовать только, для того чтобы прервать работу метода в виде 'return;'
    }


    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
