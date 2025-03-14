package a0314;

import java.util.Scanner;

public class Swich1 {
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        // System.out.println("당신의 등급을 입력해주세요");
        // int grade = scan.nextInt();
        // int coupon;
        
        // switch (grade) {
        //     case 1:
        //         System.out.println("발급받은 쿠폰 1000");
        //         break;
        //     case 2:
        //         System.out.println("발급받은 쿠폰 2000");
        //         break;
        //     case 3:
        //         System.out.println("발급받은 쿠폰 3000");
        //         break;
        
        //     default:
        //     System.out.println("발급받은 쿠폰 500");
        // }

        Scanner scan = new Scanner(System.in);
        System.out.println("당신의 등급을 입력해주세요");
        int grade = scan.nextInt();
        int coupon;

        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2:
                coupon = 2000;
                break;
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
