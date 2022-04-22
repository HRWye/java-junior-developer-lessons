package ru.itmo.lessons.lesson22;

import java.util.HashSet;
import java.util.Set;

public class Sensor {
    private Set<Listener> listeners = new HashSet<>();
    private int temp;

    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void removeListener(Listener listener){
        listeners.remove(listener);
    }

    private void notifyListeners(int temp){
        listeners.forEach(listener -> listener.tempChanged(temp));//механизм подписки
    }

    public void changeState(){
        if (Math.random()<0.5) temp -=40;
        else temp+=40;
        notifyListeners(temp);
    }
}
