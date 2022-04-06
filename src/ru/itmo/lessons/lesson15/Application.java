package ru.itmo.lessons.lesson15;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        //TODO: 1)
        User user1 = new User("us1log","us1pas",Role.USER,23);
        User user2 = new User("us2log","us2pas",Role.ADMIN,24);
        User user3 = new User("us3log","us3pas",Role.USER,25);
        User user4 = new User("us4log","us4pas",Role.ADMIN,23);

        //TODO: 2)
        HashMap<String,User> hashMap = new HashMap<>();

        //TODO: 3)
        hashMap.put(user1.getLogin(), user1);
        hashMap.put(user2.getLogin(),user2);
        hashMap.put(user3.getLogin(),user3);
        hashMap.put(user4.getLogin(),user4);

        //TODO: 4)
        List<String>loginList = new ArrayList<>();
        for (Map.Entry<String, User> pair: hashMap.entrySet()){
            if (pair.getValue().getAge()>20){
                loginList.add(pair.getValue().getLogin());
            }
        //TODO: 5)
            if (pair.getValue().getRole()==Role.ADMIN){
                System.out.println("Логин: "+pair.getValue().getLogin()+"; Пароль: "+pair.getValue().getPwd());
            }
        }

        //TODO: 6)
        HashMap<Integer, List<User>> ageMap = new HashMap<>();
        for (User user : hashMap.values()) {
            if (!ageMap.containsKey(user.getAge())){
                ArrayList<User>users = new ArrayList<>();
                users.add(user);
                ageMap.put(user.getAge(),users);
            }else{
                ageMap.get(user.getAge()).add(user);
            }
        }


        System.out.println("Задача 2");
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);
        ArrayList<User> admins = new ArrayList<>(Arrays.asList(user2,user4));
        ArrayList<User> users = new ArrayList<>(Arrays.asList(user1,user3));
        enumMap.put(Role.ADMIN,admins);
        enumMap.put(Role.USER,users);

        for (Map.Entry<Role, ArrayList<User>> pair: enumMap.entrySet()){
            if (pair.getKey()==Role.USER){
                System.out.println(pair.getValue().toString());
            }
        }
        for (User user:enumMap.get(Role.USER)){
            System.out.println(user.toString());
        }

        User user5 = new User("us5log","us5pas",Role.ADMIN,23);
        enumMap.get(user5.getRole()).add(user5);//get возвращает value

    }
}
