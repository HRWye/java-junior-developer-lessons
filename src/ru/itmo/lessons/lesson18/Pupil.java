package ru.itmo.lessons.lesson18;

import java.time.LocalDate;
import java.util.Objects;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private int number;
    private String name;
    private Gender gender;
    private LocalDate birth;

    public Pupil(int number, String name, Gender gender, LocalDate birth) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return number == pupil.number && Objects.equals(name, pupil.name) && gender == pupil.gender && Objects.equals(birth, pupil.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, gender, birth);
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}
