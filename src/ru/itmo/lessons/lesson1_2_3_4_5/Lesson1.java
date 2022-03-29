package ru.itmo.lessons.lesson1_2_3_4_5;

public class Lesson1 {
    //psvm - shortcut
    /*
       многострочный комментарий
     */
    /**
     *документирование кода
     **/
    public static void main(String[] args) {
        //sout - shortcut
        System.out.println("Информация для вывода в консоль");
        /*
        задаем переменную:
        типДанных имяПеременной
         */
        int size;//объявили переменную size типа int
        size =56;

        int count=71899;
        System.out.println(count);

        int length =122, width =500;//если переменные одного типа, их можно объявлять в одну инструкцию

        count =800_000;//для удобства можно разделять нижним подчеркиванием
        System.out.println(count);

        //byte data=327; превышен допустимый диапазон

        //по умолчанию программа думает что мы работаем с типом int, поэтому надо ставить l
        long veryBig =67_000_000_000l;

        //деление целых чисел на 0
        //будет ошибка
        //System.out.println(count/0);

        //числа с плавающей точкой
        double price =56.7;
        //по умолчанию программа думает, что мы работаем с типом double, поэтому надо ставить f;
        float temp =-78.3f;

        //деление чисел с плавающей точкой на ноль
        //будет плюс или минус бесконечность
        System.out.println(price/0);
        System.out.println(temp/0);

        //double price = 34; задавать две переменные с одинаковыми именами нельзя

        price = count;//произошло автоматическое приведение типов
        System.out.println(price);

        //byte small = count; значение не умещается в необходимый диапазон

        //явное приведение типов
        byte small =(byte) count;
        System.out.println(small);

        //Операторы
        int a =9, b =4;
        double c = (double) a/b;//сначала выполнится деление и только потом приведение к типу переменной
        System.out.println(c);
        //один и операндов должен быть float или double, чтобы вывелось число с плавающей точкой

        //результат сложения byte'ов и результат сложения short'ов это int
        byte x =6, y =12;
        //byte z = (byte) x + y;// при такой записи явное приведение указывает только на x, поэтому выводит ошибку

        //%
        length =9;//переменная уже существует, мы просто обращаемся к ней и присваиваем ей новое значение
        width =2;
        System.out.println(length%width);//1
        //двойка уместилась в девятке четыре раза и остаток равен 9-8=1

        //операторы присваивания
        int num =10;
        //num = num +10; == num+=10;
        //num = num -10; == num-=10;
        //num = num *10; == num*=10;
        //num = num /10; == num/=10;
        //num = num %10; == num%=10;

        //операторы сравнения
        System.out.println(a>b);
        System.out.println(length==width);//значение сравнения либо false либо true, то есть всегда boolean

        //тернарный оператор
        int start =3, end =5000;
        int res = start> end ? end - start : 0;
        /*
        ? - это тернарный оператор,
        проверяется условие:
        если true, то оператор возвращает условие, которое стоит перед двоеточием,
        false - после двоеточия
        */
        System.out.println(res);}}