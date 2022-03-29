package ru.itmo.lessons.lesson7_8.base;

public final class King extends Unit{//final перед классом запрещает наследование
    private int gold = 500;
    private BattleUnit[] army;

    public King(int healthScore){
        super(healthScore);
    }

    public void plusGold(int count){gold+=count;}

    public void minusGold(int count) {
        if (gold < count) return; // если золота у короля меньше count, уменьшения не происходит
        gold -= count;
    }

    public void generateArmy(){ // 250
        if (gold < 250) {
            System.out.println("Стоимость армии 250. У короля " + gold);
            return;
        }
        gold -= 250;
        army = BattleUnit.getBattleUnits(20);
    }

    // заменяет погибших юнитов новыми
    public void changeUnits(){  // 20
        for (int i = 0; i < army.length; i++) {
            if (gold < 20) {
                System.out.println("Стоимость одного юнита 20. У короля" + gold);
                return;
            }
            if (army[i] != null && !army[i].isAlive()) {
                gold -= 20;
                army[i] = BattleUnit.getBattleUnit();
            }
        }
    }

    public void startBattle(King enemy){
        // iter - так среда быстро сгенерирует for each
        /* for (BattleUnit battleUnit : army) { } */
        for (int i = 0; i < army.length; i++) {
            int unitIndex = (int) (Math.random() * army.length);
            int enemyUnitIndex = (int) (Math.random() * enemy.army.length);
            army[unitIndex].attack(enemy.army[enemyUnitIndex]);
            army[unitIndex].rest();
            enemy.army[enemyUnitIndex].rest();
        }
    }

    // возвращает количество живых юнитов в армии
    public int getBattleUnitsCount() {
        int count = 0;
        for (BattleUnit battleUnit : army) {
            if (battleUnit.isAlive()) count += 1;
        }
        return count;
    }

    //реализация абстрактного метода
    @Override
    public void rest() {
        minusGold(50);
        plusHealth(50);
        System.out.println("Отдых короля");
    }
}