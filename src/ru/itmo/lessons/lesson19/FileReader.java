package ru.itmo.lessons.lesson19;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class FileReader {

    //java.io
    //java.nio

    /**Для работы с IO API необходим import java.io.*
      Основные классы:
      File - класс для работы с файловой системой
      InputStream и OutputStream работают с потоком байт
      InputStream - описывает получение данные из различных источников
      OutputStream - описывает отправку данных в различные источники
      Reader и Writer работают с потоком символов
      Reader - описывает получение данные из различных источников
      Writer - описывает отправку данных в различные источники*/

    // new File (файл или директория)

    /**InputStream и его наследники:

     Основные методы:

     int read() - читает байт из потока, возвращает целочисленное представление байта. При достижении конца потока возвращает -1
     int read(byte[] buffer) - читает байты в буфер, возвращает количество прочитанных байт. При достижении конца потока возвращает -1
     int read(byte[] buffer, int byteOffset, int byteCount) - читает byteCount байт в буфер, начиная со смещения byteOffset. Возвращает количество прочитанных байт или -1, если достигнут конец потока
     close() - закрывает источник ввода. Следующие попытки чтения приведут к IOException
     int available() - возвращает количество байт, доступные в данный момент для чтения

     Наследники:

     FileInputStream - поток вывода, который содержит методы, записывающие данные в файл;
     ByteArrayInputStream - позволяет использовать буфер в памяти как InputStream. Входным источником является массив байт.
     ObjectInputStream - добавляет функциональность к другому входному потоку. Чтение ранее сериализованных данных из потока. Десериализует примитивные данные и объекты.
     FilterInputStream - абстрактный класс, предоставляющий интерфейс для классов-декораторов, которые добавляют к существующим потокам полезные свойства.
     BufferedInputStream - добавляет функциональность к другому входному потоку. Дает возможность буферизации входных данных.
     При создании BufferedInputStream создается внутренний буферный массив. Когда байты из потока считываются или пропускаются, внутренний буфер заполняется.
     DataInputStream - считывает из потока данные примитивных типов и строк. Соответственно для каждого примитивного типа определен свой метод для считывания XXX readXXX()*/

     public static boolean writeToFile (byte[] data, File file) /*throws FileNotFoundException - то есть тот участок когда в котором будет вызван этот метод будет реализовывать обработку исключения*/{

         boolean result = false;

               try(FileOutputStream fileOutput = new FileOutputStream(file, true)){
                   // true - дозапись в файл - new FileOutputStream(file, true)
                   // false - перезапись new - FileOutputStream(file)

                   //Если открытие источника прописать в ()try, то закрытие произойдет автоматическое закрытие если:
                   //1. данные переданы
                   //2. в блоке try произошла ошибка
                   //Ресурсы будут закрыты до перехвата исключения блоком catch

                   // Если класс, объект которого создается в try with resources,
                   // реализует  AutoCloseable интерфейс
                   // и его абстрактный метод void close()

                   // если try with resources не используется,
                   // закрывать ресурсы нужно в блоке finally

                   fileOutput.write(data);//записали данные в файл
                   result = true;
               } catch (FileNotFoundException e){
                   System.out.println("Не удалось найти файл");
               } catch (IOException e){
                   // throw new RuntimeException(e);
                   System.out.println("Не удалось прочитать данные из файла");
               }
               return result;
     }


    public static byte[] readFromFile(File file){
        byte[] result = null;
        try (FileInputStream fileInput = new FileInputStream(file)){
            result = fileInput.readAllBytes();//присвоили переменной данные из файла
        } catch (FileNotFoundException e) {
            // throw new RuntimeException(e);
            System.out.println("Не удалось использовать файл");
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.out.println("Не удалось прочитать данные из файла");
        }
        return result;
    }

    public static boolean writeFromConsole(File file){
        boolean result = false;
        // основной функционал
         try (FileOutputStream fileOutput = new FileOutputStream(file, true);
         // декоратор
              BufferedOutputStream buffer = new BufferedOutputStream(fileOutput)){//буфер накапливает данные
             Scanner scanner = new Scanner(System.in);
             while (true){
                 System.out.println("Введите данные или stop для выхода");
                 String userInput = scanner.nextLine();
                 if ("stop".equalsIgnoreCase(userInput)) break;
                 buffer.write(userInput.getBytes());//строчка переводится в массив байт
                 //когда буфер заполнится он автоматически, передаст данные в fileOutput
             }
             result = true;
         }catch (IOException e){
             System.out.println("Проблемы с записью в файл");
         }
         return result;
    }

    public static String readWithBuffer(File file){
          String result = null;
          try(FileInputStream filterInput = new FileInputStream(file);
          BufferedInputStream bufferedInput = new BufferedInputStream(filterInput);
          ByteArrayOutputStream byteArray = new ByteArrayOutputStream()){

              byte[] buffer = new byte[300];
              int count;

              while ((count = bufferedInput.read(buffer))!=-1){//возвращает -1 когда уже нечего читать
                    byteArray.write(buffer, 0, count);
              }

              result = byteArray.toString();

          } catch (IOException e){
              System.out.println("Проблемы с чтением");
          }
          return result;
    }

    public static boolean byteArrayToImage(File file, byte[] bytes) throws IOException {
         try(ByteArrayInputStream byteArray = new ByteArrayInputStream(bytes)) {
             BufferedImage image = ImageIO.read(byteArray);
             return ImageIO.write(image,"png",file);
         }
    }

    public static byte[] imageToBytes(File file) throws IOException {
         BufferedImage image = ImageIO.read(file);
         ByteArrayOutputStream arrayOutput = new ByteArrayOutputStream();
         ImageIO.write(image,"png", arrayOutput);
         return arrayOutput.toByteArray();
    }



}
