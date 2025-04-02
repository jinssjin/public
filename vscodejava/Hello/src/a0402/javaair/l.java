package a0402.javaair;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FlightManager {
    private static ArrayList<Flight> flights; //항공편 정보를 저장 ArrayList
    private static ArrayList<Passenger> passengers; //예약된 승객정보

    //승객을 키로하고, 예약된 항공편을 값으로 가지는 Map
    private static Map<String, Flight> reservationMap = new HashMap<>();

    private static FileC fc = new FileC(); //파일 관련작업
    Scanner sc = new Scanner(System.in);
    public FlightManager(){
        flights = new ArrayList<>();
        flights.add(new Flight("제주","11:55", 78000, false));
        flights.add(new Flight("이스탄불","17:10",1200000,true));
        flights.add(new Flight("방콕","21:35",280000,true));
        passengers = new ArrayList<>();
        Flight sf = flights.get(0);
        reservationMap.put("테스트", sf);
    }
    public String airplane = "                       |                      \n" + "                      _|_                     \n" + "                    /_____\\                  \n" + "                   /oo   oo\\                 \n" + " \\_________________\\       /_________________/\n" + "  `-------|---|-----\\_____/-----|---|-------'\n" + "         ( ) ( )  O|OOo|oOO|O  ( ) ( )   \n";
    public void displayFlightList(String str) {
        //항공편 목록이 출력 -> flight 에서 toString 이용해서
        System.out.println("=========================== "+str+ " =========================" );
        int count = 1;
        for(Flight flight: flights){
            System.out.println(count + ""+ flight);
            count++;
        }
        System.out.println("============================================================");

    }
    public void bookFlight() throws InterruptedException {
        //국제선 - 사용자이름, 생년월일 받아서 나이확인하고 만 15미만 예약거절
        for(;;){//무한루프
            displayFlightList("항공편예매");
            System.out.print("예매할 항공편 입력 > ");
            try {
                int bookNum = Integer.parseInt(sc.next());
                if(bookNum > flights.size() || bookNum < 1){
                    //예약할 수 있는 목록의 갯수보다 크거나 목록이 없으면
                    System.out.println("잘못되 입력입니다.");
                    continue;
                    //유요하지 않은 입력은 받은 경우 루프 다음을 반복
                    //사용자에게 올바른 입력을 다시 요청
                }
                System.out.println("선택한 항공편");
                System.out.println("============================================================");
                System.out.println(bookNum + "" + flights.get(bookNum-1));
                System.out.println("============================================================");
                Flight sf =  flights.get(bookNum-1);
                if(flights.get(bookNum-1).getInternationalFlight()){//국제선이면
                    System.out.println("국제선은 만15세이상 예매가능");
                    passengerInfo(sf);
                }else{
                    passengerInfo(sf);
                }
                if(passengers != null && !passengers.isEmpty()){
                   String seatNum  = Integer.toString(seatSelection(sf)); //좌석
                   passengers.get(passengers.size()-1).setSeat(seatNum);
                   // 현재 passengers 리스트에서 가장 마지막에 추가된 승객 좌석 번호를 설정
                   System.out.println("예약중입니다.");
                   Thread.sleep(2000); //2초후 실행
                }
                System.out.println("==================================================");
                System.out.println("예약에 성공했습니다.");
                System.out.println("[" + passengers.get(passengers.size()-1).getName()+"] 님의 예약정보");
                System.out.println(bookNum + "" + sf);
                System.out.println("==================================================");
                System.out.println("잠시후 메인 화면으로 이동합니다.");
                Thread.sleep(2000);
                reservationMap.put(passengers.get(passengers.size()-1).getName(),sf);
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }

        }

    }
    private int seatSelection(Flight flight) { //좌석예약
        int seatNum =-1;
        while(true){
            try {
                System.out.println("========================================");
                flight.seatToString(); //빈좌석이 보이는 print
                System.out.println("좌선번호를 선택하세요");
                System.out.print("선택>");
                int seatInt= sc.nextInt() - 1;
                sc.nextLine();
                if(seatInt+1 < 1 || seatInt+1 > 20){//좌석 1~20
                    System.out.println("존재하지 않는 좌석입니다.");
                }else if(flight.getSeats().get(seatInt).equals("XX")){
                    System.out.println("이미 예약된 좌석입니다.");
                }else{
                    // 좌석이 비어있으면
                    flight.getSeats().set(seatInt, "XX"); //좌석수정
                    System.out.println("좌석 선택이 완료되었습니다.");
                    seatNum = seatInt;
                    break;
                }
            } catch (InputMismatchException e) {
                 System.out.println("잘못된 입력입니다.");
                 sc.nextLine();
            }
        }
        return seatNum;
      
    }
    private void passengerInfo(Flight flight) {// 사용자 입력해서 예약
        System.out.println("예매자 정보를 입력하세요");
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.printf("생년월일(6자리):");
        try {
            int birthDate = Integer.parseInt(sc.next());
            Passenger p = new Passenger(name, birthDate);
            if(!p.man15(p)  && flight.getInternationalFlight()){
                //왼쪽 과 오른쪽 true 이여야만 실행 - 15미만이고 국제선이면 
                System.out.println("만 15미만은 국제선 예약불가입니다.");
            }else{
                System.out.println("결제 비밀 번호");
                String pw = sc.next();
                p = new Passenger(name,birthDate,pw);
                passengers.add(p); //항공 예약 명단에 추가
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
            if(index !=-1){
                System.out.println("결제 비밀번호");
                String pw = sc.next();
                System.out.println();
                if(passengers.get(index).getPw().equals(pw)){
                    System.out.println("비밀번호가 일치합니다.");
                    System.out.println(ticketPrint(reservationMap, passengers.get(index).getName()));
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
        String name = sc.next();
        sc.nextLine();
        int index = -1;
        if(passengers != null){
            for(int i = 0; i < passengers.size();i++){
                if(passengers.get(i).getName().equals(name)){
                    index = i;
                }
            }
        }
        return index;
    }


}
