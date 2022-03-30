package ru.itmo.lessons.lesson11.enums;

//каждый элемент перечисления может иметь собственную реализацию метода

public enum Operation {
    //абстрактные методы переопределяются во время перечисления переменных
    SUM {
        @Override
    public  int action(int a, int b){
      return a+b;
    }
    public void some(){
        System.out.println("some");//метод который задан только в фигурных скобках переменной, нельзя будет вызвать в главном методе
    }
    },
    MULTI{
        @Override
        public  int action(int a, int b){
         return a*b;
        }
    };

    public abstract int action(int a, int b);//задаем метод абстрактным, чтобы переопределить этот метод для каждого объекта перечисления



}
