package ru.itmo.lessons.lesson22;

public class Controller implements Listener {
    private final String name;
    private final int maxTemp;
    private boolean up;

    public Controller(String name, int maxTemp) {
        this.name = name;
        this.maxTemp = maxTemp;
    }

    @Override
    public void tempChanged(int temp) {
            if (temp>=maxTemp&&!up){
                 System.out.println(name+": "+temp);
                 up =true;
            }
            if (temp<maxTemp) up = false;
    }
}
