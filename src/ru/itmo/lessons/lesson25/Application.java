package ru.itmo.lessons.lesson25;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application {
    public static void main(String[] args) {
        // потокобезопасные коллекции, мапы
        // Vector, HashTable, Stack - но уже не пользуются

        // создание потокобезопасных коллекций, мап (обычную мапу в потокобезопасную)
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        Set<String> synchronizedSet = Collections.synchronizedSet(set);
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
        //если поток обращается к такому сету, мапе или листу, то они блокируются

        /**
         Пакет java.util.concurrent
         Коллекции и мапы
         - допускают одновременное чтение и внесение изменений разными потоками
         - не вызывают исключение ConcurrentModificationException при удалении в цикле
         - коллекции предоставляют метод addIfAbsent(obj), который позволяет добавить элемент, в случае отсутствия данной записи, причем сделать это атомарно.
         - мапы предоставляют метод putIfAbsent(key, value), который позволяет добавить в Map ключ-значение, в случае отсутствия данной записи, причем сделать это атомарно.

         CopyOnWriteArrayList, CopyOnWriteArraySet используют алгоритм CopyOnWrite, что предполагает создание копии внутреннего массива на каждое изменение коллекции (add, set, remove).

         ConcurrentSkipListSet хранит элементы в отсортированном виде, использует алгоритм SkipList - набор связных списков

         ConcurrentHashMap использует несколько (по умолчанию 16) сегментов, каждый сегмент представляет собой HashMap. При работе с данной мапой сначала определяется сегмент, в который необходимо добавить/удалить/изменить пару ключ-значение, после чего данный сегмент блокируется, остальные сегменты остаются доступны.

         ConcurrentNavigableMap обеспечивает возможность получения элементов отображения относительно других элементов (наименьший/наибольший ключ, первый/последний элементы и тд)

         ConcurrentSkipListMap хранит элементы в отсортированном по ключам порядке, использует алгоритм SkipList - набор связных списков*/

        /**
         Очереди (в том числе блокирующие)
         Блокирующие очереди используются, если необходимо приостановить работу потока, если не соблюдены определенные условия, например, очередь переполнена, в очереди нет элементов и тп

         - реализуют интерфейсы BlockingQueue, BlockingDeque, TransferQueue.
         - реализация BlockingQueue гарантирует, что любая попытка извлечь элемент (метод take) из пустой очереди заблокирует вызывающий поток до тех пор, пока не появится доступный элемент, а любая попытка вставить элемент (метод put) в заполненную очередь заблокирует вызывающий поток до тех пор, пока не освободится место для нового элемента.
         - реализация интерфейса TransferQueue позволяет при добавлении элемента в очередь заблокировать вставляющий поток до тех пор, пока другой поток не заберет элемент из очереди.

         ArrayBlockingQueue реализует кольцевой буфер. Параметр fair в конструкторе позволяет управлять соблюдением очередности ожидающих и извлекающих потоков. Размер очереди задается в конструкторе и не меняется.

         SynchronousQueue - очередь, в которой каждая операция добавления должна ждать соответствующей операции удаления в другом потоке и наоборот (принцип «один вошел, один вышел»).

         LinkedTransferQueue позволяет при добавлении элемента в очередь (метод transfer) заблокировать вставляющий поток до тех пор, пока другой поток не заберет элемент из очереди. Дает гарантию, что элемент будет получен из очереди. Размер очереди можно задать в конструкторе, по умолчанию - максимальный int

         DelayQueue позволяет извлекать элементы только после некоторой задержки, определенной в каждом элементе, те позволяет выполнять задачи по расписанию.

         LinkedBlockingQueue (более высокую производительность и более высокий расход памяти) - очередь на связанных узлах.

         LinkedBlockingDeque — двунаправленная блокирующая очередь на связанных узлах.*/

        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        strings = new LinkedBlockingQueue<>(30);

        ArrayBlockingQueue<Message> messages =
                new ArrayBlockingQueue<>(30);//всегда указываем размер очереди
        messages = new ArrayBlockingQueue<>(30, true);

        // new Thread(new WriteThread(messages)).start();
        // new Thread(new WriteThread(messages)).start();
        // new Thread(new WriteThread(messages)).start();
        // new Thread(new ReadThread(messages)).start();

        // Блокирующая очередь DelayQueue:
        // 1. класс, экземпляры которого помещаются в очередь
        // должен имплементировать интерфейс Delayed
        // 2. take блокирует поток, если данных в очереди нет
        // или если элемент нельзя извлечь из очереди
        DelayQueue<Task> tasks = new DelayQueue<>();
        // метод put вызывает метод compareTo объекта task,
        // чтобы разместить элементы в отсортированном порядке
        tasks.put(new Task(()->{
            System.out.println("old task");
        }, LocalDateTime.now().minusDays(1)));

        tasks.put(new Task(()->{
            System.out.println("future task");
        }, LocalDateTime.now().plusMinutes(3)));

        tasks.put(new Task(()->{
            System.out.println("now task");
        }, LocalDateTime.now().plusSeconds(20)));

        while (true) {
            try { // метод take вызывает метод getDelay объекта Task,
                // и если метод вернет положительное число,
                // то поток (в данном случае main) блокируется
                Runnable runnable = tasks.take().getAction();
                new Thread(runnable).start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    }
