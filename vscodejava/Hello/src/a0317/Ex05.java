package a0317;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        int ballance = 0;

        while (true) {
            System.out.println("------------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("------------------------------------");
            System.out.print("선택>");

            int meneNum = Integer.parseInt(scan.nextLine()); //문자로 받아서 숫자로 바꿔줌

            switch (meneNum) {
                case 1:
                    System.out.print("예금액>");
                    ballance = ballance + Integer.parseInt(scan.nextLine());
                    break;

                case 2:
                    System.out.print("출금액>");
                    ballance = ballance - Integer.parseInt(scan.nextLine());
                    break;

                case 3:
                    System.out.print("잔고>");
                    System.out.println(ballance);
                    break;

                case 4:
                    run = false;
                    break;
            }
            System.out.println();    
        }
        System.out.println("프로그램 종료");
    }
}
