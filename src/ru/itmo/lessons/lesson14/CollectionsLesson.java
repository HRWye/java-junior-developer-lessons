package ru.itmo.lessons.lesson14;

import java.util.*;

public class CollectionsLesson {
    public static void main(String[] args) {
        //Коллекции различаются:
        //1. многопоточная или однопоточная
        //2. возможность хранить дублирующие элементы
        //3. возможность хранить элементы в порядке добавления
        //4. возможность хранить элементы в отсортированном виде

        System.out.println("ArrayList - динамический массив");
        //реализован на основе массива
        //можно хранить null
        //можно хранить дублирующиеся элементы
        //порядок хранения элементов соответствует порядку добавления

        Student student1 = new Student(1,"Maxim",17);
        Student student2 = new Student(2,"Anna",21);
        Student student3 = new Student(3,"Paul",23);
        Student student4 = new Student(4,"Helen",19);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        //по умолчанию создается массив на 10 элементов
        studentArrayList = new ArrayList<>(30);
        //тогда по умолчанию будет создан массив на 30 элементов,
        //но емкость легко изменяется динамически
        System.out.println(studentArrayList.size());
        //метод показывает количество элементов в коллекции, именно элементов!!
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        //studentArrayList.add(10,student2);
        //обращение к несуществующему индексу (IndexOutOfBoundsException), так как пока у нас только два элемента в коллекции
        studentArrayList.add(1,student3);//не считается заменой, так как элемент на этом месте просто "подвинулся"
        System.out.println(studentArrayList.size());
        //studentArrayList.add(null);//теперь в коллекции было бы 4 элемента

        studentArrayList.trimToSize();
        //этим методом урезаем массив до количества добавленных элементов (только если уверены, что больше будем добавлять элементы)

        System.out.println(studentArrayList.get(1));
        //возвращаем элемент по индексу

        studentArrayList.remove(3);
        //удаляем элемент по индексу, возвращает ссылку на удаленный элемент
        studentArrayList.remove(student1);
        //возвращает true-false,
        //удаляет первый найденный элемент

        Student[] students = {student1, student2};
        studentArrayList.removeAll(Arrays.asList(students));
        //преобразовали массив в элементы коллекции
        //метод removeAll удаляет все указанные элементы

        studentArrayList.clear();
        //удаляем все из коллекции
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.add(student4);
        for (Student student : studentArrayList) {
            //к имени каждого студента добавляем строчку Student:
            student.setName("Student: "+student.getName());
            //удаление элемента в цикле делать нельзя иначе это приведет к ошибке ConcurrentModificationException
        }

        Iterator<Student> iterator = studentArrayList.listIterator();
        //позволяет перебирать и удалять элементы из коллекции
        while (iterator.hasNext()){//=пока есть следующий элемент
            if (iterator.next().getAge()>20){//удаляем студентов старше 20 лет
                //next() возвращает ссылку на экземпляр коллекции
                iterator.remove();
            }
        }

        System.out.println("LinkedList - двунаправленный связный список");
        LinkedList<Student> studentLinkedList
                = new LinkedList<>(studentArrayList);//добавили в новою коллекцию ссылки из предыдущей коллекции
        //внутри не массив
        //можно хранить null
        //можно хранить дублирующиеся элементы
        //порядок хранения элементов соответствует порядку добавления
        studentLinkedList.add(student1);
        studentLinkedList.add(student2);
        studentLinkedList.add(student3);
        //создается объект типа Node(student1) и Node(student3), то есть хранит ссылку только на первый и последний созданные объекты,
        //а вот уже Node(student1) хранит ссылку на следующий объект Node(student2)
        //Node(student2) хранит ссылку на следующий и на предыдущий объекты,
        //Node(student3) - последний объект - хранит ссылку на предыдущий элемент и на элемент null("предполагаемый следующий")
        //LinkedList->Node(student1)<->Node(student2)<->Node(student3)->null

        //Set
        //используются для хранения уникальных элементов
        //обязательно должен быть переопределен метод equals
        System.out.println("HashSet - множества");
        //позволяет хранить null, при этом он будет на первом месте
        //порядок хранения может отличаться от порядка добавления
        //основан на hash таблице
        //обязательно должен быть переопределен метод hashcode
        //самый быстрый из множеств, поэтому если нет разницы в каком порядке хранить элементы, то нужно использовать его
        Student student5 = new Student(5,"Maxim",17);
        Student student6 = new Student(6,"Anna",21);
        Student student7 = new Student(7,"Paul",23);
        Student student8 = new Student(8,"Helen",19);
        HashSet<Student> studentHashSet = new HashSet<>();
        List<Student> list = Arrays.asList(student5,student6,student7,student8);
        studentHashSet = new HashSet<>(list);
        studentHashSet.add(student1);
        studentHashSet.remove(student1);
        double avAge = 0;
        for (Student student : studentHashSet) {
            avAge+=student.getAge();
        }
        System.out.println(avAge/studentHashSet.size());

        System.out.println("LinkedHashSet - множества");
        //медленнее чем HashSet
        //порядок хранения элементов не отличается от порядка добавления

        System.out.println("TreeSet - множества");
        //Хранит элементы в отсортированном виде
        //нельзя добавлять null
        //основан на алгоритме красно-черного дерева
        //для добавления элемента необходимо: 1вар. Класс, элементы которого будут храниться в TreeSet реализовывал интерфейс Comparable и его метод compareTo
        TreeSet<Student> treeSet1 = new TreeSet<>();
        treeSet1.add(student1);
        treeSet1.add(student2);
        treeSet1.add(student3);
        treeSet1.add(student4);
        treeSet1.add(student5);
        //2вар. написать экземпляры класса Comparator
        Comparator<Student> studentComparator = new NameComparator().thenComparing(new AgeComparator());//порядок сравнения
        TreeSet<Student> treeSet2 = new TreeSet<>(studentComparator);
        treeSet2.add(student7);
        treeSet2.add(student8);


    }
}
