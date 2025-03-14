package a0314;

import java.util.Scanner;

public class If3_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("당신의 등급을 입력해주세요");
        int grade = scan.nextInt();
        int coupon;
        
        if(grade == 1){
            coupon = 1000;
        }else if(grade == 2){
            coupon = 2000;
        }else if(grade == 3){
            coupon = 3000;
        }else{coupon = 500;}

        scan.close();
        System.out.println("발급받은 쿠폰 " + coupon);
        

    }
}
