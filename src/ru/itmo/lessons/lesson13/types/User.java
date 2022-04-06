package ru.itmo.lessons.lesson13.types;

public class User<T> {

    private String login;
    private T id;//используем дженерики если не хотим задавать конкретный тип данных, внутри класса у этого свойства можно вызвать только методы Object

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(T id){
        this.id=id;
    }
    public T getId(){
        return id;
    }


}
