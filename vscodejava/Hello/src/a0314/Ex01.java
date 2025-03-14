package a0314;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("당신의 나이는 무엇이당가요?");
        int age = a.nextInt();

        if(age <= 7){System.out.println("미취학");}else if(age <= 13 && age >= 8){System.out.println("초등학생");}
        else if(age <= 16 && age >= 14){System.out.println("중학생");}else if(age <= 19 && age >= 17){System.out.println("고등학생");}else{System.out.println("성인");}

        a.close();
    }
}
