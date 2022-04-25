package ru.itmo.lessons.lesson23;

import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 git branch mybranchhrw - создали ветку

 git checkout mybranchhrw - переключились на созданную ветку

 git branch - показ веток (активная ветка горит зеленым)
 */





public class BaseInfo {
    public static void main(String[] args) {
        /**
         запуск программы -> создание процесса ОС
         -> создается основной поток (main поток)
         -> последовательное выполнение инструкций
         */

        /**
         после создания основного потока можно запускать
         дополнительные потоки, тогда инструкции процесса
         будут выполняться параллельно
         одно ядро процессора может обрабатывать один поток
         */

        // Жизненный цикл потока:
        // 1. NEW - поток создан (создан экземпляр класса Thread)
        // 2. RUNNABLE - управление потоком передается Thread Scheduler -
        // 'планировщику потоков jvm' (вызван метод start у экземпляра класса Thread)
        // 3. RUNNING - поток запущен планировщиком и начинает выполнять инструкции,
        // время запуска потока определяет сам 'планировщик потоков'
        // 4. NON-RUNNING (TIME WAITING, WAITING, BLOCKED) - поток может
        // находиться в состоянии ожидания
        // 5. TERMINATED - поток завершает работу

        /**
         Варианты описания ИНСТРУКЦИЙ потока:

        1. создать класс, который наследуется от класса Thread,
        инструкции, которые должен выполнять поток описываются в методе
        public void run(); - объект этого класса становится потоком

        2. инструкции, которые должен выполнять поток описываются в методе
        public void run() интерфейса Runnable (при этом набор инструкций
        можно описать в лямбде или создать отдельный класс) - объект этого класса потоком не будет

        3. воспользоваться возможностями пакета java.util.concurrent.
         */

        MyThread myThread1 = new MyThread();//этот объект является потоком
        myThread1.setName("myThread 1");//этот метод объект этого класса унаследовал от родителя
        myThread1.start();// передача потока в Thread Scheduler, поток не начинает сразу выполнять команды, а начинает только когда это решит сделать планировщик Thread Scheduler (он вызовет метод run())
        /*myThread.run();//инструкции выполнятся, но не параллельно, а тогда это нельзя считать за поток**/

        MyThread myThread2 = new MyThread();
        myThread2.setName("myThread 2");
        myThread2.start();

        MyTask myTask1 = new MyTask();//пока это просто объект, планировщику передать его нельзя
        Thread thread =  new Thread(myTask1);//передали ссылку на объект конструктору потокостроителю, создали поток
        thread.setName("myTask1");
        thread.start();// передача потока в Thread Scheduler, поток не начинает сразу выполнять команды, а начинает только когда это решит сделать планировщик Thread Scheduler (он вызовет метод run())

        //Runnable - функциональный интерфейс, поэтому можно воспользоваться лямбда выражениями
        new Thread(()->
                System.out.println(Thread.currentThread().getName())).start();

        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        File file = new File("C://Users//User//Desktop","file.txt");
        //1 поток - с консоли в список
        //2 поток - приостанавливает работу на 30 сек, после чего берет минимальную по размеру строку из strings и помещает ее в файл

        FromConsoleToStrings ThreadTask1 = new FromConsoleToStrings(strings);
        ThreadTask1.setName("ThreadTask1");
        ThreadTask1.start();

        MinimalStringToFile ThreadTask2 = new MinimalStringToFile(strings, file);
        ThreadTask2.setName("ThreadTask2");
        try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        ThreadTask2.start();
    }
}