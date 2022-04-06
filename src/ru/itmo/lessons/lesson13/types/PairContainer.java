package ru.itmo.lessons.lesson13.types;

public class PairContainer<T,K> {
    private T key;
    private K value;

    public T getKey() {
        return key;
    }
    public void setKey(T key) {
        this.key = key;
    }

    public K getValue() {
        return value;
    }
    public void setValue(K value) {
        this.value = value;
    }

    public PairContainer(T key, K value) {
        this.key = key;
        this.value = value;
    }
}
