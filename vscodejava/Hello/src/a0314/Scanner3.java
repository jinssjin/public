package a0314;

import java.util.Scanner;

public class Scanner3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요"); 
        int integer1 = scanner.nextInt();
        System.out.print("정수를 입력하세요"); 
        int integer2 = scanner.nextInt();

        System.out.print(integer1+" "+integer2);
        System.out.printf("%d %d",integer1,integer2);
        
        scanner.close();
    }
}
