package a0403.movie;

import java.time.DateTimeException;
import java.util.Scanner;


public class Practice {
       
    public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

        try {
            System.out.println("입력해라");
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            System.out.println(a);
            System.out.println(b);
            
        } catch (DateTimeException e) {
            System.out.println("날짜형식");
        } 





    }}