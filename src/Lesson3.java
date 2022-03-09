import java.util.Scanner;//импортировали класс Scanner

public class Lesson3 {
    public static void main(String[] args) {
        //проверка дз2
        double x = 5.7;
        System.out.println((int)x);//можно изменять тип переменной прям при выводе, но если число и будет например округлено, то не по правилам математики

         //пользовательский ввод
        Scanner in = new Scanner(System.in);
        //написан класс Scanner для ввода данных, который находится в java.util
        System.out.print("Введите целое число число: ");
        int userNum = in.nextInt();//вызываем необходимый метод класса Scanner, в зависимости он типа необходимой переменной
        System.out.println(userNum*userNum);

        //цикл while
        while (true){
            System.out.print("Введите целое положительное число число или ноль для выхода: ");
            userNum = in.nextInt();
            if (userNum==0) break;//завершение итерации и цикла при вводе нуля
            if (userNum<0) continue;//переход на следующую итерацию, цикл начинается заново
            System.out.println(userNum*userNum);
        }
        /*
        while (true) - бесконечный цикл
        while (false) - цикл который не будет выполнятся
        */

        //цикл do while
        do {
            System.out.print("Введите целое положительное число число или ноль для выхода: ");
            userNum = in.nextInt();
            if (userNum<0) continue;
            System.out.println(userNum*userNum);
        } while (userNum!=0);
        /*
       do{} while (true) здесь первая итерация выполняется безусловно и уже потом проверяется условие в ()
       do{} while (false)
         */

        int start=1, end =12;
        //вывести все четные числа от 1 до 12
        while (start<=end){
            if (start%2==0) System.out.println(start);
            start+=1;
        }
        System.out.println();
        do {
            if (start%2==0) System.out.println(start);
            start+=1;
        } while (start<=end);

        //цикл for
        //for (инициализация переменных;булевое выражение (условие);обновление значений переменных){тело цикла}
          for (start =1,end=12;start<=end;start++){if (start%2==0) System.out.println(start);}
        System.out.println();

        //вывести все неотрецательные элементы последовательности
        //90 85 80 ... 0
          for (int num=90;num>=0;num-=5){System.out.println(num);}
        System.out.println();

        //вывести на экран первые 10 элементов последовательности
        // 2 4 6 7 8 9 10 ...
        int y=1;
          for(start=2; y<=10; start+=2,y++){System.out.println(start);}
        System.out.println();

        //Задача на тарелки и моющее средство. Герасимов Егор
        System.out.print("Введите количество тарелок: ");
        int plates= in.nextInt();
        System.out.print("Введите количество моющего средства: ");
        double fairy = in.nextDouble();
        while (plates>0&&fairy>0){
            plates-=1;
            fairy-=0.5;
            System.out.println("Осталось "+plates+" тарелок и "+fairy+" моющего средства");}
        System.out.println("В итоге осталось осталось "+plates+" тарелок и "+fairy+" моющего средства");
    }
}