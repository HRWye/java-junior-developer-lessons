package ru.itmo.lessons.lesson7.base;
//родительский класс всех персонажей
abstract public class Unit {//abstract класс, нельзя на основе него создать новый экземпляр (new Unit); может содержать абстрактные методы
    protected int healthScore;//доступ к свойствам и методам с модификатором protected разрешен из родительского и дочерних классов
    private int maxHealthScore;
    public Unit(int healthScore){
        if (healthScore<1){
            throw new IllegalArgumentException("Здоровье должно быть положительным значением");
        }
        this.healthScore=healthScore;
        maxHealthScore=healthScore;
    }
    //добавить здоровье, но не больше изначального
        public void plusHealth(int healthScore){
            if (!isAlive()) return;
            this.healthScore=Math.min(this.healthScore+healthScore,maxHealthScore);//будет присвоено минимальное из значений
        }
    //уменьшить здоровье, но не меньше нуля
        public void minusHealth(int healthScore){
            if (!isAlive()) return;
            this.healthScore-=healthScore;
        }
    //метод вернет true если здоровье больше 0, false если нет
        public boolean isAlive(){
            return healthScore>0;
        }

    public int getHealthScore() {
        return healthScore;
    }

    public void unitVoid() {
        System.out.println("Метод Unit");
    }

    //если метод должен быть у всех объектов этого класса, но реализации его у всех объектов будет разная,
    //то необходимо создать абстрактный метод - метод без реализации(буз {})
    //обычные классы не могут содержать абстрактные методы,
    //из-за того что мы создали такой метод, теперь его необходимо прописать в каждом классе который наследуется от класса Unit
    public abstract void rest();//написать такой метод нужно, чтобы заставить разработчиков или себя, написать для каждого наследуемого класса
}
