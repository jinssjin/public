package a0314;

import java.util.Scanner;

public class Swich4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("당신의 학점을 입력하시오 grade :");
        String grade = scan.next();
        
        switch (grade) {
            case "A":
                System.out.print("탁월한 성과입니다.");
                break;
            case "B":
                System.out.println("좋은 성과입니다.");
                break;
            case "C":
                System.out.println("준수한 성과입니다.");
                break;
            case "D":
                System.out.println("향상 성과입니다.");
                break;
            case "F":
                System.out.println("불합격입니다.");
                break;
        
            default: System.out.println("잘못된 학점입니다.");
                break;
        }
    }
}
