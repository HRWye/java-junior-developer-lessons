package ru.itmo.lessons.lesson9;

import java.util.Objects;

//все классы в языке наследуются от класса Object
public class Point implements Cloneable {//если в классе мы обращаемся к методу clone() родителя, то должны имплементировать интерфейс Cloneable
    //в одном файле может быть только один public класс
    //других классов может быть сколько угодно

    private int x;
    private int y;

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{"+
                "x="+x+", y="+y+
                '}';
    }

    @Override
    public boolean equals(Object o) {//если передается Object значит, может быть вписан любой объект, но он станет типа Object
        if (this == o) return true;//если ссылки равны то точно true
        if (o == null || getClass() != o.getClass()) return false;//если объект пустой или сравниваемые объекты разных классов, то точно false
        //объект instanceof тип данных - возвращает true если объект принадлежит данному типу данных
        Point point = (Point) o;//приводим объект о обратно к типу Point, после этого приведения будут доступны его характеристики
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
        //если объекты разные хэш-коды могут быть разные, если объекты равны по equals(), то хэш-коды точно должны быть одинаковы
    }

    @Override
    public Point clone() {
        try{
            return (Point) super.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
}
