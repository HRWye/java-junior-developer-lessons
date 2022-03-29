package ru.itmo.lessons.lesson9_10;

import java.util.Arrays;

public final class Figure implements Cloneable {

    private final Point[] points;//если массив final, то мы не сможем перезаписать ссылку, то есть сослаться на другой массив, но элементы массива перезаписать можем
    //final по сути не дает перезаписать ссылку, а характеристики объекта изменить мы можем
    //значения final свойств должны задаваться, либо сразу, либо в конструкторе (поэтому к таким характеристикам нельзя написать сеттер)

    public Figure(int pointCount){
        if (pointCount<2){
            throw new IllegalArgumentException("Фигура должна состоять, минимум из двух точек");
        }
        this.points = new Point[pointCount];
    }

    public Point[] getPoints() {
        return points;
    }

    public void addPoint(Point point){
        for (int i =0;i< points.length;i++){
            if (points[i]!=null&&points[i].equals(point)){
                System.out.println("Точка "+point+"не была добавлена. Такая уже есть"); return;
            }
            if (points[i]==null){
                points[i]=point;
                System.out.println("Точка "+point+" была добавлена."); return;
            }
        }
        System.out.println("Точка "+point+"не была добавлена. У фигуры уже достаточно точек");
    }

    @Override
    public Figure clone() {
        Figure copy = new Figure(points.length);
        for (int i=0;i<points.length;i++){
            copy.points[i]=points[i].clone();
        }
        return copy;
    }
    //чтобы скопировать объект физически а не просто ссылаться на него то нужно вызвать метод clone

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Arrays.equals(points, figure.points);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
