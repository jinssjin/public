package a0317;

import java.util.Scanner;

public class Ex07_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("삼각형의 높이를 입력하세요?");
        int row = scan.nextInt();

        for(int i=1; i <= row; i++){
            for(int j=1; j<=row-i; j++){
                System.out.print(" ");
            }
            for(int k=1; k <= (2*i-1);k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
