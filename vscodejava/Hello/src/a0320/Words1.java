package a0320;

import java.util.Scanner;

public class Words1 {
    public static void main(String[] args) {
        String [][] words = {
            {"chair","의자"},
            {"computer","컴퓨터"},
            {"integer","정수"}
        };

        Scanner scanner = new Scanner(System.in);

        for(int i=0; i < words.length; i++){
            System.out.printf("Q%d %s의 뜻은?",i+1,words[i][0]);

            String tmp = scanner.next().trim();
            if(tmp.equals(words[i][1])){  // 정수를 받을때는 == , 문자를 받을때는 equals
                System.out.println("정답입니다.");
            }else{
                System.out.println("틀렸어유 정답은 "+words[i][1] + "입니다.");
            }
        }

    }
}
