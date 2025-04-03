package a0403.movie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieManager {
    Scanner scan = new Scanner(System.in);
    private static ArrayList<Screen> screens;
    private static ArrayList<Customer> customers;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM월 dd일 hh:mm a");
    String formatingDate = now.format(dateFormat);
    

    private static Map<String,Screen> myMovieMap = new HashMap<String,Screen>();
    // private static FileD fd = new FileD();
    
    public MovieManager(){
        screens = new ArrayList<>();
        screens.add(new Screen("공포특급", "특별2관", "16:00", "15세이용가", 15000));
        screens.add(new Screen("로비", "10관", "18:40", "15세이용가", 10000));
        screens.add(new Screen("승부", "3관", "19:10", "12세이용가", 10000));
        screens.add(new Screen("세븐틴", "특별1관", "18:20", "전체이용가", 20000));
        screens.add(new Screen("김동하:커넥트", "6관", "18:00", "청소년관람불가", 10000));
        screens.add(new Screen("고독한 미식가 더 무비", "2관", "17:10", "전체이용가", 10000));

        customers = new ArrayList<>();
        
    }
//시작화면
    public String openning = "____________________________________________________\n|                                                   |\n|      *   더조은 극장에 오신걸 환영합니다   *      |\n|                                                   |\n|          "+"현재시각 : "+formatingDate+"          |\n|                  \t                            |\n|___________________________________________________|";

//영화목록조회
    public void displayMovieList(String str) {
        System.out.println();
        System.out.println("===================================="+str+"====================================");
        int count = 1;
            for(Screen movie:screens){  // Screen클래스에 있는 screens(목록)에서 movie 하나하나(정보가 담긴 리스트)를 뽑느다
                System.out.println(count+""+movie);
                count++;  // 순번 높여준다. 1번돌때 1. / 2번돌때 2. / 3번돌때 3.
            }
            System.out.println("=====================================================================================");
            
    }
    public void currentMovieList(){
        System.out.println("===================================예매가능한 영화====================================");
        
        System.out.println("=====================================================================================");
    };

//영화예매
    public void bookMovie() throws InterruptedException {  // 스레드로 늦출거라서 중간에 멈춰도 예외로 처리할 수 있게 해줌
        for(;;){
            currentMovieList();

        }
    }

    
}
