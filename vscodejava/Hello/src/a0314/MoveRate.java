package a0314;

import java.util.Scanner;

public class MoveRate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("원하시는 영화의 평점대를 입력하시오 : ");
        double rating = scan.nextDouble();

        if(rating >= 9){System.out.println("어바웃타임을 추천합니다.");}
        if(rating >= 8){System.out.println("토이스토리를 추천합니다.");}
        if(rating >= 7){System.out.println("고질라를 추천합니다.");}
            
        scan.close();
    }
}
