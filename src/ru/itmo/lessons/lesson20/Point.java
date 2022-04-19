package ru.itmo.lessons.lesson20;

import java.io.*;
import java.util.Objects;

public class Point implements Externalizable /*Serializable*/  { // 13
    /**Сериализация - объект, как последовательность байт*/

    /**java.io.Serializable:
     1.по умолчанию все поля включаются в процесс сериализации;
     2.исключить поля из сериализации можно, если отметить их как transient;
     3.если дочерний класс (но не родитель) имплементирует данный интерфейс, то полученные от родителя свойства не участвуют в сериализации;
     4.если родительский класс имплементирует данный интерфейс, то полученные от родителя свойства участвуют в сериализации.
      */
    @Serial//аннотация подсказка, ругается если свойство неверно названо
    private static final long serialVersionUID = 1L;/**версия класса всегда будет 1*/
    /**Версия класса private static final long serialVersionUID задается, если предполагается менять описание класса (добавлять / удалять свойства) после сериализации.*/
    /**дело в том что при сохранении объекта в файл сохраняется и версия его класса, а когда мы меняем или добавляем свойства класса объекта, то версия меняется*/
    private int x;
    private int y;

    public Point() {}

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


    /**java.io.Externalizable // (при этом есть возможность включить поля в сериализацию)
     по умолчанию все поля исключены из процесса сериализации;
     только свойства перечисленные в методах (writeExternal / readExternal) участвуют в сериализации;
     для десериализуемых объектов должен быть задан конструктор без параметров.*/
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(x);
        out.writeInt(y);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        x = in.readInt();
        y = in.readInt();
    }
}
