package a0319;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean run = true;

        int students=0;
        int [] score;

        while (run){
        System.out.println("=====================================================");
        System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
        System.out.println("=====================================================");
        System.out.print("선택> ");

        int menuNum = Integer.parseInt(scan.nextLine());
            
        switch (menuNum) {
            case 1:
                System.out.print("학생수>");
                students = Integer.parseInt(scan.nextLine());
                break;

            case 2:
                System.out.print("scores[0]>");
                int scores[0] = Integer.parseInt(scan.nextLine());
                System.out.print("scores[1]>");
                int scores[1] = Integer.parseInt(scan.nextLine());
                System.out.print("scores[2]>");
                int scores[2] = Integer.parseInt(scan.nextLine());
                break;

            case 3:
                System.out.print("학생수>");
                students += Integer.parseInt(scan.nextLine());
                break;

            case 4:
                System.out.print("학생수>");
                students += Integer.parseInt(scan.nextLine());
                break;

            case 5:
                run = false;
                break;
        
        }
        System.out.println("프로그램 종료");
    }
    }
}
