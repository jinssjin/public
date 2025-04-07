package a0403.movie;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
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
    private static FileD fd = new FileD();
    
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
        int count = 1;
        for(int i =0; i < screens.size(); i++){  // 스크린에 있는 영화를 돌면서
            LocalTime MovieTime = LocalTime.parse(screens.get(i).getTime(),formatterDisplay); // 영화 시간 String을 LocalTime 타입으로 형변환
            if(MovieTime.isAfter(currentTime)){   //  영화 시간이 현재 시간보다 뒤에 있다면
                System.out.println(count+""+screens.get(i));  // 영화 목록을 출력
                count++;
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
            
            try {
                System.out.println("예매자 정보를 입력하세요");
                System.out.print("이름 : ");
                String name = scan.next();
                System.out.print("생년월일(6자리) : ");
                int customerbirthDay = scan.nextInt();
                scan.nextLine();
                int y = customerbirthDay / 10000;
                int m = (customerbirthDay % 10000) /100;
                int d = customerbirthDay % 100;
                if(y > 0 && y <= 25){
                    y += 2000;
                }else{
                    y += 1900;
                }
                LocalDate customerbirthDayformat = LocalDate.of(y, m, d);
                LocalDate currentDate = LocalDate.now();
                int customerAge = Period.between(customerbirthDayformat,currentDate).getYears();
                System.out.print("예매할 영화 번호 입력 > ");
                int bookNum = scan.nextInt();
                scan.nextLine();
                if(bookNum > screens.size() || bookNum < 1){
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
                
                System.out.println("선택하신 영화");
                System.out.println("=====================================================================================");
                System.out.println(bookNum+ "" +screens.get(bookNum-1));
                System.out.println("=====================================================================================");
                 Screen choiceMovie = screens.get(bookNum-1);  // 선택한 영화 배열 전체를 choiceMovie에 저장
                 if(screens.get(bookNum-1).getRating().equals("전체이용가")){
                    Customer c = new Customer(name, customerbirthDay);
                    System.out.print("결제 비밀번호 : ");
                    String pw = scan.next();
                    Customer cS = new Customer(name, customerbirthDay, pw);
                    customers.add(cS);
                }else if(screens.get(bookNum-1).getRating().equals("청소년관람불가") && customerAge < 19){
                    System.out.println("청소년 관람 불가입니다.");
                 }else if(customerAge < Integer.parseInt(screens.get(bookNum-1).getRating().substring(0,2))){
                    System.out.println("연령제한 영화입니다.");
                }else{
                    Customer c = new Customer(name, customerbirthDay);
                    System.out.print("결제 비밀번호 : ");
                    String pw = scan.next();
                    Customer cS = new Customer(name, customerbirthDay, pw);
                    customers.add(cS);
                }
                if(customers != null && !customers.isEmpty()){
                    String seatNum = Integer.toString(seatSelection(choiceMovie));
                    customers.get(customers.size()-1).setSeat(seatNum);
                    System.out.println("예약중입니다.");
                    Thread.sleep(2000);
                    System.out.println("===================================================================");
                    System.out.println("예약에 성공했습니다.");
                    System.out.println("["+customers.get(customers.size()-1).getName()+"] 님의 예약정보");
                    System.out.println(bookNum + "" + choiceMovie);
                    System.out.println("===================================================================");
                    System.out.println("잠시후 메인 화면으로 이동합니다.");
                    Thread.sleep(2000);
                    myMovieMap.put(customers.get(customers.size()-1).getName(),choiceMovie);
                    break;

                }
                }catch (NumberFormatException e) {

                    System.out.println("잘못된 입력입니다. 숫자만 입력해주세요");
                }
            
        }
    }

    private int seatSelection(Screen screen) {
        int seatNum = -1;
        while (true) {
            try{
            System.out.println("===================================================================");
            screen.seatToString();
            System.out.println("좌석번호를 선택하세요");
            System.out.print("선택 > ");
            int seatIndex = scan.nextInt()-1;
            scan.nextLine();
            if(seatIndex+1 < 1 || seatIndex+1 > 52){
                System.out.println("유효하지않은 선택입니다. 1 ~ 48 사이 선택");
            }else if(screen.getSeats().get(seatIndex).equals("■■")){
                System.out.println("이미 선점된 좌석입니다.");
            }else{
                screen.getSeats().set(seatIndex,"■■");
                System.out.println("좌석 선택이 완료되었습니다.");
                seatNum = seatIndex + 1;
                break;
            }
        }catch(InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
            scan.nextLine();
        }
            
        }
        return seatNum;
    }

    public void checkReservation() {
        if(customers.isEmpty()){
            System.out.println("예약된 내역이 없습니다.");
            System.out.println("===================================================================");
            return;
        }
        int index = search("예약확인");
        checkPassword(index);
    }

    public void cancelTicket() {
        int cancelIndex = -1;
        cancelIndex = search("예매취소");  // 예매 취소할 자리의 인덱스 번호를 찾아서
        if(cancelIndex >= 0){
            String returnToIndex = Integer.toString(cancelIndex+1);
            Screen cancelMovie = myMovieMap.get(customers.get(cancelIndex).getName());
            cancelMovie.getSeats().set(cancelIndex,returnToIndex);
            myMovieMap.remove(customers.get(cancelIndex).getName());
            customers.remove(cancelIndex);
            System.out.println("예매가 취소되었습니다.");
        }else{
            System.out.println("선택하신 차량을 찾을 수 없습니다.");
        }
        
    }

    private void checkPassword(int index) {
        for(;;){
            if(index != -1){
                System.out.print("결제 비밀번호 : ");
                String searchPw = scan.next();
                System.out.println();
                if(customers.get(index).getPw().equals(searchPw)){
                    System.out.println("비밀번호가 일치합니다.");
                    System.out.println(ticketPrint(myMovieMap,customers.get(index).getName()));
                    break;
                }
            }
        }
    }

    String ticketPrint(Map<String,Screen> myMovieMap, String n) {
        int index = -1;
        if(customers != null){
            for(int i =0; i < customers.size(); i++){
                if(customers.get(i).getName().equals(n)){
                    index = i;
                }
            }
        }
        int seat = Integer.parseInt(customers.get(index).getSeat())+1;
        return  "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n\n" +
                 "\t" + n + "님의 티켓정보" +
                 "| 좌석 : " + seat + "번\n"+
                 "." + myMovieMap.get(n) + "\n\n" +
                 "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n\n";
    }
    
    public static ArrayList<Screen> getScreens() {
    return screens;
    }

    public static Map<String,Screen> getReservationMap() {
        return myMovieMap;
    }

    private int search(String str) {
        System.out.println("===================== " + str + " =====================");
        System.out.print("예약자 이름 : ");
        String searchName = scan.next();
        scan.nextLine();
        int index = -1;
        if(customers != null){
            for(int i=0; i<customers.size(); i++){
                if(customers.get(i).getName().equals(searchName)){
                    index = i;
                }
            }
        }
        return index;
    }
    public void ticketSave() {
        if(customers.isEmpty()){
            System.out.println("예약된 내역이 없습니다.");
            System.out.println("===================================================================");
            return;
        }
        int index = search("티켓조회");
        checkPassword(index);
        fd.ticketSaveFile(myMovieMap,customers.get(index).getName());
    }

    String photocardPrint(Map<String,Screen> myMovieMap, String a) {
        int index = -1;
        if(customers != null){
            for(int i =0; i < customers.size(); i++){
                if(customers.get(i).getName().equals(a)){
                    index = i;
                }
            }
        }
        
        String choiceMovieTittle = myMovieMap.get(a).getTitle();
        switch (choiceMovieTittle) {
            case "공포특급":
             return "       .-`      `-.\n      /            ＼\n     |                |\n     |,  .-.  .-.  ,   |\n     | )(_o/ ＼o_)( |\n     |/     /＼   ＼|\n     (_     ^^   _)\n     ＼__|IIIIII|__/\n       |＼IIIIII/   |\n      ＼          /\n        `--------`\n";
                
            case "로비":
            return "     ________________________\n  |＼＼____________________//|\n  ||     ******    ******       ||\n  ||     ******    ******       ||\n  ||                               ||\n  ||      TOP SECRET         ||\n  ||       CONTRACT         ||\n  ||         ******               ||\n  ||         LOBBY             ||\n  ||                               ||\n  ||   ******       ******      ||\n  ||   ******      ******       ||\n  ||//__________________＼＼||   ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n";
                
            case "승부":
            return " ────────────────\n│                                               \n│    ╋╋╋╋╋╋╋╋╋╋╋╋╋╋\n│    ╋○●╋╋●╋╋╋╋╋╋╋╋\n│    ╋╋●╋╋╋╋╋╋╋╋╋╋╋\n│    ╋○○●╋╋╋╋╋╋╋╋╋╋\n│    ╋╋╋●╋○╋╋╋╋╋╋╋╋\n│    ╋╋╋╋╋╋╋╋╋╋╋╋╋╋\n│    ╋○╋╋╋╋╋╋╋╋╋╋╋╋\n│    ╋╋╋╋╋╋╋╋╋╋╋╋╋╋\n│    ╋╋╋╋╋╋╋╋╋╋╋╋╋╋\n│    ╋╋╋╋╋╋╋╋╋╋╋╋╋╋\n";
                
            case "세븐틴":
            return "                      ☆\n                   ☆   ☆\n                 ☆       ☆\n   ☆☆☆☆☆           ☆☆☆☆☆\n     ☆                                ☆\n        ☆     SEVENTEEN     ☆\n           ☆         ☆         ☆\n         ☆        ☆   ☆          ☆\n       ☆    ☆               ☆       ☆\n    ☆  ☆                        ☆  ☆   \n";
                
            case "김동하:커넥트":
            return "˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚\n\n                        CONNECT\n\n˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚˚\n";
                
            case "고독한 미식가 더 무비":
            return "         (\n          )\n     __..---..__\n ,-='  /  |  ＼  `=-.\n:--..___________..--;\n＼.,_____________,./\n";
        }
        return "";
    }
    
}




    // private void customerInfo(Screen choiceMovie) {
    //     System.out.println("예매자 정보를 입력하세요");
    //     System.out.print("이름 : ");
    //     String name = scan.next();
    //     System.out.print("생년월일(6자리) : ");
    //     try {
    //         int birthDate = Integer.parseInt(scan.next());
    //         Customer c = new Customer(name, birthDate);
            
    //         }

    //     } catch (DateTimeException e) {
    //         System.out.println("생년월일을 6자리로 입력해주세요 ex)010225");
    //     }

// Integer.parseInt(get(i).getRating().substring(0,2)); 
// 12세이용가의 앞 두글자를 따서 숫자로 형변환
//Integer.parseInt(customers.get(i).getBirthDate().substring(0,2))


// boolean membershipSignup = false;
//         int membershipPoint = 0;
//         System.out.println("연간회원권에 가입하시겠습니까? (연간회원 영화 50% 할인)");
//         System.out.print("예(Y)    아니오(N) : ");
//         String membershipAnswer = scan.next();
//         if(membershipAnswer.equalsIgnoreCase("y")||membershipAnswer=="예"){
//             membershipSignup = true;
//             System.out.println("더조은무비 멤버쉽에 오신걸 환영합니다.");
//             System.out.println("아래 계좌로 무통장 입금 후 포인트 충전을 완료해주시면 감사하겠습니다.");
//             System.out.println("더조은 은행 000-0000-00000 (예금주 : 더조은무비)");
//             System.out.println("충전하실 더조은포인트 금액을 입력해주세요. (연회비는 포인트에서 차감됩니다.)");
//             System.out.print("충전 포인트(10,000원 이상) >");
//             try {
//                 membershipPoint = Integer.parseInt(scan.next());
//             } catch (NumberFormatException e) {
//                 System.out.println("잘못된 입력입니다. 숫자만 입력해주세요");
//             }

// ♡♥만약 오류나면 비회원은 멤버쉽 포인트 0 추가해볼래

// }else if(membershipAnswer.equalsIgnoreCase("n")||membershipAnswer=="아니오"){
//     membershipSignup = false;
// }else{
//     System.out.println("잘못 입력하셨습니다.");
// }

// try {
//     int birthDate = Integer.parseInt(scan.next());
//     Customer c = new Customer(name, birthDate, membershipSignup,membershipPoint);
    
//     if(!c.rateTop(c) > Integer.parseInt(screens.get(i).getRating().substring(0,2))){
//         System.out.println("이 영화는 "+screens.get(bookNum).getRating()+"입니다.");       
//     }

// } catch (DateTimeException e) {
//     System.out.println("생년월일을 6자리로 입력해주세요 ex)010225");
// }
// }


// for(int i=0; i<screens.size();i++){
                //     if(13 < Integer.parseInt(screens.get(i).getRating().substring(0,2))){
                //         System.out.println("이 영화는 "+screens.get(bookNum).getRating()+"입니다.");       
                // }else{
                    
                // }
                

                // for(int i =0; i < screens.size(); i++){
                //     if( customers.getbirthDate(i)-now > Integer.parseInt(screens.get(i).getRating().substring(0,2))){

// ☆★☆★birthDate-now 구해야됨★☆★☆

// System.out.println("예매자 정보를 입력하세요");
//                 System.out.print("이름 : ");
//                 String name = scan.next();
//                 System.out.print("생년월일(6자리) : ");
        
//                 try {
//                     int birthDate = Integer.parseInt(scan.next());
//                     Customer c = new Customer(name, birthDate);
//                     System.out.print("결제 비밀번호 : ");
//                     String pw = scan.next();
//                     Customer cS = new Customer(name, birthDate, pw);
//                     customers.add(cS);
                    
//                     } catch (DateTimeException e) {
//                         System.out.println("생년월일을 6자리로 입력해주세요 ex)010225");
//                     }
//                 if(customers != null && !customers.isEmpty()){
//                     String seatNum = Integer.toString(seatSelection(choiceMovie))
//                 }