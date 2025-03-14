package a0314;

import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        // 사용자로부터 세 개의 정수를 입력받아, 가장 큰 수를 출력하는 프로그램을 작성하세요. if문 사용

        Scanner scan = new Scanner(System.in);
        System.out.println("첫번째 정수를 입력하시오");
        int a = scan.nextInt();
        System.out.println("두번째 정수를 입력하시오");
        int b = scan.nextInt();
        System.out.println("세번째 정수를 입력하시오");
        int c = scan.nextInt();

        if(a>b && a>c){System.out.println(a+"가 가장 큰 수");}else if(a>b && a<c){System.out.println(c+"가 가장 큰 수");}
        else if(b>a && b>c){System.out.println(b+"가 가장 큰 수");}else{System.out.println("잘못 입력하였습니다.");}


    }
}
