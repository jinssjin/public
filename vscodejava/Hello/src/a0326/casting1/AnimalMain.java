package a0326.casting1;

public class AnimalMain {
    public static void main(String[] args) {
        Animal eagle = new Eagle();

        eagle.sleep();
        // eagle.eat;  // 에러

        Eagle eagleOBJ = (Eagle)eagle;  // 강제 형변환
        eagleOBJ.eat();  // Eagle 클래스의 eat() 메서드

        System.out.println(eagle instanceof Animal);
        System.out.println(eagleOBJ instanceof Animal);
    }   
}
