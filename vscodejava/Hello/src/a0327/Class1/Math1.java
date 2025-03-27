package a0327.Class1;

public class Math1 {
    public static void main(String[] args) {
        System.out.println(Math.ceil(10.0));  // 10.0 ceil : 올림
        System.out.println(Math.ceil(10.1));  // 11.0

        System.out.println(Math.floor(10.0));  // 10.0
        System.out.println(Math.floor(10.9));  // 10.0

        System.out.println(Math.round(10.0));  // 10
        System.out.println(Math.round(10.4));  // 10
        System.out.println(Math.round(10.5));  // 11

        System.out.println(Math.max(3.14, 3.14159));  // 3.14159
        System.out.println(Math.min(3.14, 3.14159));  // .3.14
        System.out.println();

        System.out.println(Math.max(-10, -11));  // -10
        System.out.println(Math.min(-10, -11));  // -11
        System.out.println((int)(Math.random()*100));  // 0~99 중에 랜덤한 숫자
    }
}
