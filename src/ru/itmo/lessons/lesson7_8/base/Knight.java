package ru.itmo.lessons.lesson7_8.base;

public class Knight extends BattleUnit implements AttackAble{
    //implements, то есть этот класс реализует данный интерфейс и обязан определить все его методы
    private int additionalHealth = 10;
    public Knight(int healthScore,int attackScore){
        super(healthScore, attackScore);
    }

    public void  knightVoid(){
        System.out.println("Метод  Knight");}

    @Override
    public void rest() {
        plusHealth(3);
        System.out.println("Рыцарь отдыхает");
    }
    @Override
    public void attack(BattleUnit enemy) {
       if (enemy.isAlive()&&this.isAlive()) enemy.minusHealth(attackScore);
       if (enemy.isAlive())this.minusHealth(enemy.getAttackScore());
       if (this.isAlive())plusHealth((int)(Math.random()*additionalHealth));
    }
}
