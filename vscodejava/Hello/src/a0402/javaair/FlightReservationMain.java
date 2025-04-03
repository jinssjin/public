package a0402.javaair;

import java.util.Scanner;

public class FlightReservationMain {
    public static void main(String[] args) {
        FlightManager fm = new FlightManager();  // FlightManager(); 객체 생성과 동시에 더미데이터 삽입
        Scanner scan = new Scanner(System.in);
        FileC fc = new FileC();
        System.out.println(fm.airplane);
        System.out.println("===============JavaAir에 오신걸 환영합니다.===============");

        Outter:while (true) {
            System.out.println("1. 항공편 목록\n2. 항공편 예매\n3. 예약 조회\n4. 티켓 저장\n5. 항공편 업로드 \n0. 종료\n");
            System.out.print("메뉴입력>");

            String menuStr = scan.next();
            scan.nextLine(); //버퍼 비우기

            int menu = -1;
            try {
                menu = Integer.parseInt(menuStr);
            } catch (NumberFormatException e) {
                menu = 9;
            }
            switch (menu) {
                case 1:  // 항공편목록
                    fm.displayFlightList("항공편 목록");
                    break;
                case 2:  // 항공편 예매
                    try {
                        fm.bookFlight();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:  // 예약한 항공편목록
                    fm.checkReservation();
                    break;
                case 4:  // 티켓을 5파일로 저장
                    fm.ticketSave();
                break;
                case 5:  // 항공편 업로드 -> 항공편 불러오기
                    fc.upload();
                break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scan.close();
                break Outter;
                    // Outter(지정한 위치)로 빠져나감
            
                default:
                    break;
            }
        }
    }
}
