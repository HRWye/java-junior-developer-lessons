package ru.itmo.lessons.lesson21;

public class User {
    private Level level;
    private String login;

    //доступ к перечислению вне класса - согласно
    //модификатору доступа: User.Level.элемент
    //это вложенный класс
    public enum Level{//если перечисление это свойство только одного класса, то это перечисление правильно будет написать в этом классе
       HIGH(10), MEDIUM(5), LOW(0);
       private int count;

       Level(int count){
           this.count=count;
       }

        public int getCount() {
            return count;
        }
    }

    public User(Level level, String login) {
        this.level = level;
        this.login = login;
    }


    //Внутренний класс - не статический внутри другого класса
    //1. область видимости - согласно модификаторам доступа
    //2. нельзя создать объект внутреннего класса без создания объекта внешнего
    // по сути это класс, который принадлежит объектам
    //3. внутренний класс не может содержать статических методов и свойств, только если статическое свойство не final
    public class Account{
        private float balance;
        private static final int MAX_BALANCE = 500;

        public Account(float balance) {
            this.balance = balance + User.this.level.getCount();//так можно обратиться даже к приватным свойствам
        }

        public User getUser(){
            //доступ к экземпляру внешнего класса
            //это можно прописать, потому что мы уверены что если создан экземпляр внутреннего класса, то создан экземпляр внешнего класса
            return User.this;//ссылка на экземпляр внешнего класса
        }
    }
    //вложенный класс - статический внутри другого класса


}
