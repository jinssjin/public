package a0402.javaair;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FlightManager {
    private static ArrayList<Flight> flights;  // 항공편 정보를 저장 ArrayList
    private static ArrayList<Passenger> passengers;  // 예약된 승객 정보
    
    // 승객을 키로하고, 예약된 항공편을 값으로 가지는 Map
    private static Map<String,Flight> reservationMap = new HashMap<>();

    private static FileC fc = new FileC();  // 파일 관련작업
    Scanner scan = new Scanner(System.in);
    public FlightManager(){
        flights = new ArrayList<>();
        flights.add(new Flight("제주","11:55", 78000, false));
        flights.add(new Flight("이스탄불","17:10",1200000,true));
        flights.add(new Flight("방콕","21:35",280000,true));
        passengers = new ArrayList<>();
        Flight sf = flights.get(0);
        reservationMap.put("테스트",sf);
    }
    public String airplane = "                       |                      \n" + "                      _|_                     \n" + "                    /_____\\                  \n" + "                   /oo   oo\\                 \n" + " \\_________________\\       /_________________/\n" + "  `-------|---|-----\\_____/-----|---|-------'\n" + "         ( ) ( )  O|OOo|oOO|O  ( ) ( )   \n";
    
    
    public void displayFlightList(String str) {
        // 항공편 목록이 출력 -> flight에서 toString 이용해서
        System.out.println("==============================="+str+"===============================");
        int count = 1;
        for(Flight flight:flights){
            System.out.println(count+""+flight);
            count++;
        }
        System.out.println("===================================================================");
    }

    public void bookFlight() throws InterruptedException {  // InterruptedException는 Tread를 쓰기 위해서 예외를 사용
        // 국제선 - 사용자 이름, 생년월일 받아서 나이 확인하고 만 15세 미만은 예약 거절
        for(;;){  // 무한루프  
            displayFlightList("항공편예매");  // 메서드 안에 들어갈 String이 쓸 떄마다 달라져서 직접""안에 입력
            System.out.print("예매할 항공편 입력 > ");
            try {
                int bookNum = Integer.parseInt(scan.next());
                if(bookNum > flights.size() || bookNum < 1 ){
                    //예약할 수 있는 목록의 갯수보다 크거나 목록이 없으면
                    System.out.println("잘못된 입력입니다.");
                    continue;
                    // 유효하지 않은 입력을 받은 경우 루프 다음을 반복
                    // 사용자에게 올바른 입력을 다시 요청
                }
                System.out.println("선택한 항공편");
                System.out.println("===================================================================");
                System.out.println(bookNum + "" + flights.get(bookNum-1));
                System.out.println("===================================================================");
                Flight sf = flights.get(bookNum-1);  // 선택한 항권편 객체를 sf에 저장
                if(flights.get(bookNum-1).isInternationalFlight()){ // 국제선이면
                    System.out.println("국제선은 만15세이상 예매가능");
                    passengerInfo(sf);
                }else{
                    passengerInfo(sf);
                }
                if(passengers != null && !passengers.isEmpty()){
                    String seatNum = Integer.toString(seatSelection(sf));  // 좌석
                    passengers.get(passengers.size()-1).setSeat(seatNum);
                    //현재 passengers 리스트에서 가장 마지막에 추가된 승객 좌석 번호를 설정
                    System.out.println("예약중입니다.");
                    Thread.sleep(2000); // 2초후 실행  // InterruptedException 예외를 만든 이유
                    System.out.println("===================================================================");
                    System.out.println("예약에 성공했습니다.");
                    System.out.println("["+passengers.get(passengers.size()-1).getName()+"] 님의 예약정보");
                    System.out.println(bookNum + "" + sf);
                    System.out.println("===================================================================");
                    System.out.println("잠시후 메인 화면으로 이동합니다.");
                    Thread.sleep(2000);
                    reservationMap.put(passengers.get(passengers.size()-1).getName(),sf);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private int seatSelection(Flight flight) {
        int seatNum = -1;
        while (true) {
            try {
                System.out.println("===================================================================");
                flight.seatToString();  // 빈 좌석이 보이는 print
                System.out.println("좌석번호를 선택하세요");
                System.out.print("선택>");
                int seatInt = scan.nextInt()-1;
                scan.nextLine();
                if(seatInt+1 < 1 || seatInt+1 > 20){  // 좌석이 1~20사이에 있는지 확인
                    System.out.println("존재하지 않는 좌석입니다.");
                }else if(flight.getSeats().get(seatInt).equals("XX")){  // 좌석에 문자 XX가 있다면
                    System.out.println("이미 예약된 좌석입니다.");
                }else{ // 좌석이 비어있으면
                    flight.getSeats().set(seatInt, "XX");  // 좌석 수정
                    System.out.println("좌석 선택이 완료되었습니다.");
                    seatNum = seatInt;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                scan.nextLine();
            }
        }
        return seatNum;
    }

    private void passengerInfo(Flight flight) {
        System.out.println("예매자 정보를 입력하세요");
        System.out.print("이름 : ");
        String name = scan.next();
        System.out.print("생년월일(6자리) : ");
        try {
            int birthDate = Integer.parseInt(scan.next());
            Passenger p = new Passenger(name, birthDate);
            if(!p.man15(p) && flight.isInternationalFlight()){  // 15세 미만이면서 국제선이면
                System.out.println("만 15세 미만은 국제선 예약이 불가합니다.");
            }else{
                System.out.print("결제 비밀번호 : ");
                String pw = scan.next();
                Passenger p2 = new Passenger(name, birthDate, pw);
                passengers.add(p2);  // 항공 예약 명단에 추가
            }
            
        } catch (DateTimeException e) {
            System.out.println("생년월일을 6자리로 입력해주세요 ex)010225");
        }
    }

    public void checkReservation() {
        int index = search("예약확인");
        checkPassword(index);
    }

    private void checkPassword(int index) {
        for(;;){
            if(index != -1){
                System.out.print("결제 비밀번호 : ");
                String pw = scan.next(); // 비밀번호 키보드 입력
                System.out.println();
                if(passengers.get(index).getPw().equals(pw)){
                    System.out.println("비밀번호가 일치합니다.");
                    System.out.println(ticketPrint(reservationMap,passengers.get(index).getName()));
                    break;
                }
            }
        }
    }

    String ticketPrint(Map<String, Flight> reservationMap, String name) {
        int index = -1;
         if(passengers != null){
             for(int i = 0; i < passengers.size();i++){
                 if(passengers.get(i).getName().equals(name)){
                     index = i;
                 }
             }
         }
         // reservationMap("이미리","방콕에관한항공편")
         int seat = Integer.parseInt(passengers.get(index).getSeat())+1;
         return  "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n\n" +
                 "\t" + name + "님의 티켓정보" +
                 "| 좌석 : " + seat + "번\n"+
                 "." + reservationMap.get(name) + "\n\n" +
                 "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ";
     }

    private int search(String str) {
        System.out.println("===================== " + str + " =====================");
            System.out.print("예약자 이름: ");
            String name = scan.next();
            scan.nextLine();
            int index = -1;
            if(passengers != null){
                for(int i=0; i <passengers.size();i++){
                    if(passengers.get(i).getName().equals(name)){
                        index = i;
                    }
                }
            }
            return index;
    }

    public void ticketSave() {
        int index = search("티켓조회");
        checkPassword(index);
        fc.ticketSaveFile(reservationMap,passengers.get(index).getName());
    }

    // 항공편 목록(flights)을 외부에서 접근하는 getter 메서드
    public static ArrayList<Flight> getFlights() {
        return flights;
    }

    // 예약정보 목록(reservationMap)을 외부에서 접근하는 getter 메서드
    public static Map<String,Flight> getReservationMap() {
        return reservationMap;
    }
}
