package a0314;

import java.util.Scanner;

public class Scanner4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("실수를 입력하세요"); 
        float float1 = scanner.nextFloat();

        // System.out.printf("%.2f",float1);

        float1 = (float1 + 0.005f)*100;
        System.out.println(float1);
        int i = (int) float1;
        System.out.println(i);
        float1 = (float) i / 100;
        
        scanner.close();
    }
}
