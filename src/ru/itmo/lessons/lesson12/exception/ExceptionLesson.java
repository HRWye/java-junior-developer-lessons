package ru.itmo.lessons.lesson12.exception;

import java.io.IOException;

public class ExceptionLesson {
    public static void main(String[] args) {

    /*Error - ошибки, связанные с проблемами уровня JVM
    Например, нехватка памяти
    errors нет смысла обрабатывать (т.е. писать строчки кода которые бы могли помочь программе работать)*/

    /*Exception - исключения
    1. Исключения времени выполнения (наследники RuntimeException)
    unchecked, необрабатываемые, неотслеживаемые, неконтролируемые
    разработчики могут обработать исключения при желании
    2. Исключения времени выполнения - все остальные наследники Exception
    checked, обрабатываемые, отслеживаемые, контролируемые*/

    //RuntimeException
        int a =1;
        int b =0;
        int res;
        res = a/b;//деление на ноль - это ошибка времени выполнения "ArithmeticException"

        int[] ints = new int[3];
        ints[100]=90;//outofbounds

        String s =null;
        s.equals("data");//nullpointerexception

        Object obj = "123";
        Integer integer = (Integer) obj;//ошибка невозможности приведения

        //обработка исключений (unchecked/checked)
        try{//в блок try помещается потенциально опасный код, который может привести к исключению
            res = a/b;//как только произойдет ошибка, сразу будет произведен переход в блок catch и неважно сколько инструкций дано после этого
        } catch (ArithmeticException e/*здесь указывает класс ошибки (только тот который реально создается) и рандомную переменную*/){/*должен присутствовать*/
            System.out.println(e.getMessage());
            res = a;
        }
        System.out.println(res);
        //одному блоку try могут соответствовать множество блоков catch

        //Объединение блоков catch
        //1. несколько блоков catch - позволяет разные исключения обрабатывать разными способами
        try  {
            if (System.currentTimeMillis()%2==0) integer = (Integer) obj;
            else ints[90]=100;
        } catch (ClassCastException e){//перехват ClassCastException и всех его потомков
            System.out.println("Проблемы с приведением типов "+e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Проблемы с приведением типов "+e.getMessage());
        } // в блоках catch должны быть разные инструкции, если классы ошибок являются наследниками и родителя, то нужно соблюдать порядок
        //2. несколько исключений обрабатываются одним способом
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) obj;
            else ints[90] = 100;
        }
        catch (ClassCastException | ArrayIndexOutOfBoundsException e){
            System.out.println("Проблемы с приведением типов или проблемы с приведением типов "+e.getMessage());
        }
        finally {//необязательный блок, может быть только один
            //инструкция выполняется в случае любого исключения в блоке try
            //инструкции связанные с закрытием ресурса
        }
        //3. несколько исключений обрабатываем через общего родителя
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) obj;
            else ints[90] = 100;
        }
        catch(RuntimeException e){//перехват всех наследников RuntimeException
            System.out.println("Исключение времени исполнения "+e.getMessage());
        }
        //4. несколько исключений обрабатываем через общего родителя, но некоторые из них обрабатываются другим способом
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) obj;
            else ints[90] = 100;
        }
        catch (ClassCastException e){//перехват ClassCastException и всех его потомков
            System.out.println("Проблемы с приведением типов "+e.getMessage());
        }
        catch(RuntimeException e){//перехват всех наследников RuntimeException
            System.out.println("Исключение времени исполнения "+e.getMessage());
        }
        //в этом случае сначала необходимо указать наследников потом родителей

        //readFromJsonFile("file.txt");

    }
    //public static void readFromJsonFile(String fileName) throws IOException{//если так записано, то обработка падает на плечи того кто увидит это, перекинули ответственность}
}