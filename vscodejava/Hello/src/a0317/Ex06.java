package a0317;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("연산자입력");
        int a = Integer.parseInt(scan.nextLine());
        Scanner scan1 = new Scanner(System.in);
        System.out.println("첫 번째 숫자");
        int b = Integer.parseInt(scan1.nextLine());
        Scanner scan2 = new Scanner(System.in);
        System.out.println("두 번째 숫자");
        int c = Integer.parseInt(scan2.nextLine());
        boolean run = true;

        while (run) {
            System.out.println("------------------------------------");
            System.out.println("1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.종료");
            System.out.println("------------------------------------");
            System.out.println("선택>");
            System.out.println("첫 번째 숫자>"+b);
            System.out.println("두 번째 숫자>"+c);

            switch (a) {
                case 1:
                    System.out.println(b+c);
                    break;
                case 2:
                    System.out.println(b-c);
                    break;
                case 3:
                    System.out.println(b*c);
                    break;
                case 4:
                    System.out.println(b/c);
                    break;
                case 5:
                    run=false;
                    break;
            
            }
            break;
        }
        
    }
}
