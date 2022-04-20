package ru.itmo.lessons.lesson21;

public class Application {
    public static void main(String[] args) {

        User user = new User(User.Level.LOW, "qwe");

        //Экземпляр внутреннего класса
        //1. когда уже создан объект внешнего класса
        User.Account account = user.new Account(20);
        //2. одновременное создание
        User.Account account2 =  new User(User.Level.HIGH, "das")
                .new Account(200);

        System.out.println(account2.getUser());

        Student.Exam math = new Student.Exam("math");

        Student student = new Student("Tom");
        math.setMark(5);
        student.addExam(math);

        //анонимные классы
        //часто используется в качестве обработчика событий
        //если метод в интерфейсе один то нужно использовать лямбду-выражение
        SomeInterface object = new SomeInterface() {
            @Override
            public void void1() {System.out.println("void1");}

            @Override
            public void void2() {System.out.println("void2");}

            @Override
            public void void3() {System.out.println("void3");}
        };
        object.void1();
        object.void2();

    }
}
