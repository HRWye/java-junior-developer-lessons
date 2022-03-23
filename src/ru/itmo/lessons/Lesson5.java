package ru.itmo.lessons;

import java.util.Arrays;

public class Lesson5 {
    public static void main(String[] args) {
//Строки//

//char примитивный тип данных 16 битный символ Unicode
        //от 0 до 65536 (номера символов) / '\u0000' до '\uffff'
        char char1 = 'J';//одинарные кавычки и один символ
        char char2 = 74;//символ можно задать через номер из таблицы Unicode
        char char3='\u0044';//16-ричное представление символа в escape последовательности
        System.out.print(char1);//J
        System.out.print(char2);//J
        System.out.print(char3);//D
        System.out.println("\nПеренос строки");//перенос строки \n

//Строка - упорядоченная последовательность символов
        //Строки относятся к ссылочным типам данных
        //Строка - ссылочный тип, экземпляр класса String
        /*Строки задаются:
        1. в двойных кавычках
        2. new String() - через коллекции, используем только если двойные кавычки никак нельзя использовать */
        //строки в языке неизменны, можно лишь создать новую строку на основе существующей
        System.out.println("Строковый литерал");

        char[] chars = {'\u004A','\u004A', '\u0044' };//массив чаров
        String jjdString = new String(chars);
        System.out.println(jjdString);
        System.out.println("Длина строки: "+jjdString.length());//вернет длину строки

        char[] chars1 = {'\uD83D','\uDC38'};//это суррогатная пара, они без друг друга не имеют смысла
        String frogString = new String(chars1);
        System.out.println(frogString);//🐽🐸ляяягушка
        System.out.println("Длина строки: "+frogString.length());
        System.out.println("Действительное количество символов: "+frogString.codePoints().count());

        /*Хранение строк до Java 9: строки хранились как массив char[] в кодировке UTF-16, каждый чар был представлен двумя байтами*/
        /*Начиная с 9 версии строки хранятся как массив byte[] + кодировка LATIN1(если для одного символа достаточно 1 байта) или UTF-16(если нужно 2 байта) -
        -это оптимизация называется компактные строки*/

//Пул строк хранит только одну копию строкового литерала
        //Пул строк: "Строка"
        String string1="Строка";//создается новый объект в пуле строк
        String string2="Строка4";//новый объект в пуле не создался, создалась лишь ссылка на уже имеющийся участок памяти
        String string3=new String("Строка");//так строка в пул строк не попадает, а попадает в хранилище объектов вне пула
        string1 = "Строка4";//изменился не объект в пуле, а создалась ссылка на новый созданный объект в пуле строк
        //если на какой-то объект в пуле нет ссылки, то рано или поздно сборщики мусора удалит безссылочный объект

        System.out.println(string1==string2);//true так как ссылаются на объект в пуле строк
        System.out.println(string1==string3);//false так как ссылаются на разные объекты

        String internString = string3.intern();// метод intern смотрит есть ли в пуле строк искомая строка и возвращает ссылку на эту строку из пула
        //интернированные строки - это строки из пула

        //сравнение строк через equals
        System.out.println(string1.equals(string2));//true, string1 сравнивается со string2
        System.out.println("Строка4".equals(string2));//true
        System.out.println(string2.equals("Строка4"));//true, но вариант выше безопаснее, так как возможно string2 это null
        System.out.println("строка4".equalsIgnoreCase(string2));//true, equalsIgnoreCase будет игнорировать регистры

        //string2 = null; это значит что переменная ни на что не ссылается
        System.out.println(string1==null);//если необходимо сравнить с null, то можно использовать ==

        string1 = "Java";
        string2 = "Python";

//Конкатенация строк
        String concatString = string1 + "::"+string2;
        System.out.println(concatString);

        concatString = string1.concat("::").concat(string2);//метод concat возвращает строчку как результат объединения string1 и ::, и потом вступает concat второй раз
        concatString = String.join("::",string1,string2);//метод join - это объединение строк по разделителю

        concatString="";
        for (int i=0;i<10;i++){
            concatString+=i+"";
        }
        System.out.println(concatString);//так делать нельзя, так как каждая переменная начинает ссылаться на новую строку

        /*для того чтобы собирать строки и не создавать мусор в пуле используют:
        StringBuilder - работает быстрее
        StringBuffer - потокобезопаснее*/
        concatString = "Начало строки ";
        StringBuilder sb = new StringBuilder(concatString);//создаем объект класса StringBuilder, в кавычках передаем строку с которой начинается склейка
        sb.append(string1).append("::").append(string2);/*метод append объединяет строки,
        таким образом буфер накапливает значения объединяемых строк, при этом новых объектов не создается*/
        StringBuilder sb2 = new StringBuilder(concatString);
        concatString="";
        for (int i=0;i<10;i++){
            sb2.append(i).append(" ");
        }
        System.out.println(sb2);
        String sbString = sb2.toString();//вызываем накопленные стрингбилдером в буфере строки с помощью toString()
        System.out.println(sbString);

//Метод split()
        String langs="Java, Python, JavaScript";
        String[] kangArr = langs.split(", ");//в кавычках указан разделитель, split будет в строчке искать эту последовательность и формировать массив
        //разделитель в массив не включается
        System.out.println(Arrays.toString(kangArr));

//Методы замены и проверки содержания
        String newString = langs.replaceAll(", ", " - ");//в метод .replaceAll передаем сначала то что хотим заменить, то на что хотим заменить
        //поддерживает регулярное выражение
        System.out.println(newString);

        String newString1 = langs.replaceFirst(", ", " - ");//заменяет только первое вхождение
        System.out.println(newString1);

        String newString2 = langs.replace(", ", " - ");//заменяет только первое вхождение
        //поддерживает только последовательность символов
        System.out.println(newString2);

        System.out.println(langs.contains("th"));// метод .contains проверяет, содержит ли строка данную последовательность символов
        System.out.println(langs.startsWith("j"));// проверяет начало строки
        System.out.println(langs.endsWith("Script"));// проверяет конец строки
        System.out.println(langs.startsWith("av",1));//проверяет начало строки c конкретного символа
    }
}
