package ru.itmo.lessons.lesson7.base;

abstract public class BattleUnit extends Unit implements AttackAble {//BattleUnit наследуется от класса Unit.
    //Unit - родительский класс (super-класс);
    //BattleUnit - дочерний класс, в наследство получает методы и свойства родительского класса, а конструкторы нет;
    //так как класс абстрактный то он не обязан переопределять метод rest() который мы определили в классе Unit
    protected int attackScore;
    public BattleUnit(int healthScore,int attackScore){
        super(healthScore);//в конструкторе должен либо быть вызван родительский конструктор super() и в нем указано требуемое значение свойства
        //либо это значение свойства должно быть указано в () дочернего конструктора
        if (attackScore<1){
            throw new IllegalArgumentException("Атака должна быть положительным значением ");
        }
        this.attackScore=attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }

    //переопределить final метод нельзя
    public final void battleUnitVoid(){
        System.out.println("Метод BattleUnit");
    }

    public boolean runFromField(){
        //при бегстве юнит теряет 1ед здоровья
        if(!isAlive()) {
            System.out.println("Юнит не сможет сбежать"); return false;}
            minusHealth(1);
            if (!isAlive()) {
                System.out.println("Юнит не сможет сбежать");
                return false;
            }
            return true;
        }

    // фабричные методы
    public static BattleUnit getBattleUnit(){
        String[] types = {"knight", "infantry"};
        BattleUnit unit = null;//переменная для сохранения ссылки
        int randomIndex = (int) (Math.random() * types.length);
        switch (types[randomIndex]) {
            case "knight":
                unit = new Knight(30, 18);
                break;
            case "infantry":
                unit = new Infantry(35, 20);
                break;
        }
        return unit;
    }

    //методы static обычно являются обслуживающими, либо генерируют какой-либо объект
    //для того чтобы обратится к такого методу надо написать названиекласса.метод(), то есть не надо создавать объект
    //статические методы не являются возможностями объек
    public static BattleUnit[] getBattleUnits(int count) {
        BattleUnit[] units = new BattleUnit[count];//создается массив боевых юнитов на такое количество какое пользователь задает в count
        for (int i = 0; i < units.length; i++) {
            // в статических методах можно обратиться только к статическим методам или свойствам
            units[i] = getBattleUnit();
        }
        return units;
    }
    }


