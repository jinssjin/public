package a0403.movie;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter formatterDisplay = DateTimeFormatter.ofPattern("HH:mm");
    // LocalTime currentTime = LocalTime.parse(now(),formatterDisplay); 필요없음
    // LocalTime currentTime = LocalTime.parse("14:10",formatterDisplay); 필요없음
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM월 dd일 hh:mm a");
    // DateTimeFormatter dateFormatDisplay = DateTimeFormatter.ofPattern("HH:mm"); 필요없음
    String formatingDate = now.format(dateFormat);
    // String formatingDateDisplay = now.format(dateFormatDisplay); 필요없음
    

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
        for(int i =0; i < screens.size(); i++){  // 스크린에 있는 영화를 돌면서
            LocalTime MovieTime = LocalTime.parse(screens.get(i).getTime(),formatterDisplay); // 영화 시간 String을 LocalTime 타입으로 형변환
            if(MovieTime.isAfter(currentTime)){   //  영화 시간이 현재 시간보다 뒤에 있다면
                System.out.println(screens.get(i));  // 영화 목록을 출력
            }else{
                continue;  // 영화 시간이 현재 시간에서 지나갔다면 넘어가
            }
        }
        System.out.println("=====================================================================================");
    };

//영화예매
    public void bookMovie() throws InterruptedException {  // 스레드로 늦출거라서 중간에 멈춰도 예외로 처리할 수 있게 해줌
        for(;;){
            currentMovieList();
            System.out.print("예매할 영화 번호 입력 > ");
            try {
                int bookNum = Integer.parseInt(scan.next());
                if(bookNum > screens.size() || bookNum < 1){
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
                System.out.println("선택하신 영화");
                System.out.println("=====================================================================================");
                System.out.println(bookNum+ "" +screens.get(bookNum-1));
                System.out.println("=====================================================================================");
                Screen choiceMovie = screens.get(bookNum-1);  // 선택한 영화 배열 전체를 choiceMovie에 저장
                for(int i =0; i < screens.size(); i++){
                    if( birthDate-now > Integer.parseInt(screens.get(i).getRating().substring(0,2))){
                        customerInfo(choiceMovie);

                        // birthDate-now 구해야됨
                }
            }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    
}

// Integer.parseInt(get(i).getRating().substring(0,2)); 
// 12세이용가의 앞 두글자를 따서 숫자로 형변환
