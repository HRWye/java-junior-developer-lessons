package ru.itmo.lessons.lesson11.enums;

import java.time.LocalDateTime;

public class Article {
    private String title;
    private String text;
    private LocalDateTime created;//хранит в себе время и дату
    private Country country;//изначально значение переменной null, но в последствии может быть только AUSTRALIA, UK, FRANCE


    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }


    public Article(String title){
        this.title=title;
        created = LocalDateTime.now();//вызываем статический метод now(), сохраняет значение текущей даты и времени
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }
    public LocalDateTime getCreated() {
        return created;
    }
}
