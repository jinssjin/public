package a0324.rpg;

public class RpgTest1 {
    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        wizard.name = "간달프";
        wizard.hp = 100;
        wizard.mp = 80;
        wizard.speed = 2;
        wizard.punch();
        wizard.fireball();
        wizard.move();

        Knight knight = new Knight();
        knight.name = "킹아서";
        knight.hp = 150;
        knight.stamina = 70;
        knight.speed = 3;
        knight.punch();
        knight.slash();
        knight.move();
    }
}

class Novice {
    String name;
    int hp;
    int speed;
    void punch(){
        System.out.printf("%s(HP : %d)의 펀치!\n",name,hp);
    }
    void move(){
        System.out.printf("%d 만큼 이동합니다.\n",speed);
    }
}

class Wizard extends Novice {
    int mp;
    void fireball(){
        System.out.printf("%s(HP : %d, MP : %d)의 파이어볼!\n",name,hp,mp);
    }
}

class Knight extends Novice{
    int stamina;
    void slash(){
        System.out.printf("%s(HP : %d, ST : %d)의 슬래쉬!\n",name,hp,stamina);
    }
}