package a0403.movie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Practice {
       
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
    
    
        LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM월 dd일 hh:mm a");
    String formatingDate = now.format(dateFormat);

        String openning = "____________________________________________________\n|                                                   |\n|      *   더조은 극장에 오신걸 환영합니다   *      |\n|                                                   |\n|          "+"현재시각 : "+formatingDate+"          |\n|                  \t                            |\n|___________________________________________________|";
        System.out.print(a);

        
    }
}


