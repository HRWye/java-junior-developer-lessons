package ru.itmo.lessons.lesson12.exception;

public class Calculate {
    public static double sum(double a, double b)throws CalcException{//заставляем разработчика решить проблему
        if(a<0||b<0) {throw new CalcException("Числа должны быть положительные");}
        return a+b;
    }
    public static double minus(double a, double b)throws CalcException{//заставляем разработчика решить проблему
        if(a<0||b<0) {throw new CalcException("Числа должны быть положительные");}
        return a-b;
    }

    public static int random(int max){
         return (int)(Math.random()*max);
    }

    public static int random(int min, int max)throws CalcException{
        return (int)(min +Math.random()*minus(min,max));
    }
}

