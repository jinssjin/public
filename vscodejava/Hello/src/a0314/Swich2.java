package a0314;

import java.util.Scanner;

public class Swich2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("당신의 등급을 입력해주세요");
        int grade = scan.nextInt();
        int coupon;

        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2:  // 2 혹은 3번일 경우 3000원의 쿠폰 출력, break;가 없으면 통과함
            case 3:
                coupon = 3000;
                break;
        
            default:
                coupon = 500;
        }

        scan.close();
        System.out.println("발급받은 쿠폰 "+coupon);
        
    }
}
