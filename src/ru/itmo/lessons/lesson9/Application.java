package ru.itmo.lessons.lesson9;

public class Application {
    //класс Point
    //класс Figure

    public static void main(String[] args){
          Point a = new Point(23, -12);
          Point b = new Point(23, -12);
          Point c = new Point(12, 33);
          Point d = new Point(45, 11);
          Point f = new Point(-8, -9);

        System.out.println(a);//==System.out.println(a.toString);
        System.out.println(b);//вывод изменился так как мы поменяли реализацию метода toString который заложен в sout

        System.out.println(a==b);
        System.out.println(a.equals(b));//метод equals тоже входит в класс Object, и по умолчанию сравнивает он ссылки и должен быть переопределен

        //клонирование
        //у метода clone модификатор protected
        Point aClone = a.clone();

        System.out.println(a==aClone);//false
        System.out.println(a.equals(aClone));//true

        Figure figure = new Figure(3);
        figure.addPoint(a);
        figure.addPoint(b);
        figure.addPoint(c);
        figure.addPoint(d);
        figure.addPoint(f);

        Figure figureClone =figure.clone();
        System.out.println(figure.equals(figureClone));


    }
}
