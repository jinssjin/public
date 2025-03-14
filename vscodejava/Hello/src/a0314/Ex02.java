package a0314;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("거리를 입력해 :");
        int distance = scan.nextInt();

        if(distance <= 1){System.out.println("출력 : 도보를 이용하세요.");}
        else if(distance <= 10){System.out.println("출력 : 자전거를 이용하세요.");}
        else if(distance <= 100){System.out.println("출력 : 자동차를 이용하세요.");}
        else{System.out.println("출력 : 비행기를 이용하세요.");}



        scan.close();
    }    
    
}
