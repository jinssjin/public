package a0321.Acoount1;

public class AvengerTest {
    public static void main(String[] args) {
        // 객체를 만듦과 동시에 생성자 호출
        Avenger ironMan = new Avenger("아이언맨", 100, 120);
        Avenger hulk = new Avenger("헐크", 200, 80);
        // 객체 정보 출력
        System.out.println(ironMan.toStr());
        System.out.println(hulk.toStr());
            }
        }
        
        class Avenger{
            private String name;
            private int power;
            private int speed;
            public Avenger(String name, int power, int speed) {
                this.name = name;
                this.power = power;
                this.speed = speed;
            }
            String toStr() {
                return String.format("Averger{name : %s, power : %d, speed : %d}",name,power,speed);
                // .format 뒤 양식대로 보내줄 때 씀
            }
    
}