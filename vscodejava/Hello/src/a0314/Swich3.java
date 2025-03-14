package a0314;

import java.util.Scanner;

public class Swich3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("당신의 등급을 입력해주세요");
        int grade = scan.nextInt();
        // 자바 14버전 이상 switch 문
        int coupon = switch (grade) {
            case 1 -> 1000;
            case 2 -> 2000;
            case 3 -> 3000;
            default -> 500;
        };

        scan.close();
        System.out.println("발급받은 쿠폰 "+coupon);
        
    }
}
