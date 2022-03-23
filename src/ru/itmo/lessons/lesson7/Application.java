package ru.itmo.lessons.lesson7;

import ru.itmo.lessons.lesson7.base.BattleUnit;
import ru.itmo.lessons.lesson7.base.Infantry;
import ru.itmo.lessons.lesson7.base.Knight;
import ru.itmo.lessons.lesson7.base.Unit;

//public class King extends Unit
//public class Infantry extends BattleUnit
//public class Knight extends BattleUnit
//abstract public class BattleUnit extends Unit
public class Application {
    public static void main(String[] args) {
        Knight knight1 = new Knight(20,17);
        knight1.knightVoid();
        knight1.battleUnitVoid();
        knight1.unitVoid();
        knight1.runFromField();

        BattleUnit knight2 = new Knight(20,17);
        knight2.battleUnitVoid();//не сможем вызвать методы Knight, а можем вызвать только методы BattleUnit и Unit
        knight2.unitVoid();

        Unit knight3 = new Knight(20,17);
        knight3.unitVoid();
        knight3.plusHealth(4);

        Infantry infantry1 = new Infantry(18,15);
        infantry1.runFromField();
    }

}
