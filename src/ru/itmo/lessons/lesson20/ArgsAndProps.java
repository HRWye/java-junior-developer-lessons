package ru.itmo.lessons.lesson20;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArgsAndProps {
    public static void main(String[] args) {
        // запуск программы с аргументами:
        // ПКМ -> Modify Run Configuration
        // -> Program Arguments: перечислить через пробел
        for (String arg: args) {
            System.out.println(arg);
        }

        // директория с ресурсами (resources)
        // ПКМ -> Mark Directory As -> Resources Root
        // lesson20.properties

        Properties properties = new Properties();
        // хранит данные в паре: ключ и значение,
        // ключ и значение всегда строки
        // добавление
        properties.setProperty("ключ", "значение");
        // получение
        System.out.println(properties.getProperty("ключ"));
        // очистить
        properties.clear();

        // загрузить из *.properties файла
        // properties.load(InputStream);
        try (InputStream input = ArgsAndProps.class
                .getClassLoader()
                .getResourceAsStream("lesson20.properties")){
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        properties.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
// Client.java  (ip сервера (127.0.0.1 localhost), port)

// tcp протокол
// Connection.java -> SimpleMessage.java

// EchoServer.java
