package ru.itmo.lessons.lesson7.base;

public class Infantry extends BattleUnit implements AttackAble {
    //можно свойству задать модификатор final так как его в ходе задачи мы никак не меняем
    private final int additionalAttack = 5;//можно прочитать но нельзя изменить

    public Infantry(int healthScore, int attackScore) {
        super(healthScore, attackScore);
    }

    public void infantryVoid() {
        System.out.println("Метод  Infantry");
    }

    //переопределение метода
    //модификатор может быть выше, но не ниже
    //название и аргументы как у родителя
    //можно вообще после переписать метод
    @Override//указание на то что разработчик собирается переопределить метод
    //если @Override горит красным, значит при переопределении допущена ошибка
    public boolean runFromField() {
        if (super.runFromField()) {
            //если юнит выжил у него отнимается атака(-3)
                attackScore -= 3;
            System.out.println("После бегства атака уменьшена");
            return true;
            }
        return false;
        }

    @Override
    public void rest() {
        plusHealth(1);
        System.out.println("Отдых пехотинца");
    }

    @Override
    public void attack(BattleUnit enemy) {
        if (enemy.isAlive()&&this.isAlive()) enemy.minusHealth(attackScore);
        if (enemy.isAlive())this.minusHealth(enemy.getAttackScore());
        if (this.isAlive())enemy.minusHealth(additionalAttack);
    }
}


