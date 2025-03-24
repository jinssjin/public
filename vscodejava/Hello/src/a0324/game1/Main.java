package a0324.game1;

public class Main {
    public static void main(String[] args) {
        Pikachu pikachu = new Pikachu();
            System.out.println("######## 피카츄#######");
            System.out.println("에너지 : "+ pikachu.energy);
            System.out.println("타입 : " + pikachu.type);
            System.out.println("레벨 : " + pikachu.level);
            System.out.println("공격 A : " + pikachu.aAttack());
            System.out.println("공격 B : " + pikachu.bAttack());

        Pikachu pikachu20 = new Pikachu(150,"전기,강철",20);
            System.out.println("######## 피카츄#######");
            System.out.println("에너지 : "+ pikachu.energy);
            System.out.println("타입 : " + pikachu.type);
            System.out.println("레벨 : " + pikachu.level);
            System.out.println("공격 A : " + pikachu.aAttack());
            System.out.println("공격 B : " + pikachu.bAttack());
    }
}
