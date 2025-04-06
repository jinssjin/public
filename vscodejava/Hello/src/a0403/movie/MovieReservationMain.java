package a0403.movie;

import java.util.Scanner;

public class MovieReservationMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FileD fd = new FileD();
        MovieManager mm = new MovieManager();
        // FileD fd = new FileD();
        System.out.println(mm.openning);  //MovieManager 클래스에 있는 openning 출력하기

        Outter:while (true) {
            System.out.println();
            System.out.println("1. 영화 목록\n2. 영화 예매\n3. 예약 조회\n4. 티켓 저장\n5. 영화목록 업로드 \n0. 종료\n");
            System.out.print("메뉴선택>");
            String menuStr = scan.next();
            scan.nextLine();

            int menuChoice = -1;
            try {
                menuChoice = Integer.parseInt(menuStr);
            } catch (NumberFormatException e) {
                menuChoice = 9;
            }
            switch (menuChoice) {
                case 1:  // 영화목록 조회
                    mm.displayMovieList("상영중인 영화");  // 영화매니저에서 목록조회 메서드를 호출 (메서드 생성)
                    break;
                case 2:
                    try {
                        mm.bookMovie(); // 영화매니저에서 영화예매 메서드를 호출 (메서드 생성)
                    } catch (InterruptedException e) { // Thread를 줄거라서 InterruptedException 예외를 줘야한다.
                        // TODO: handle exception
                    }
                    break;
                case 3:
                    mm.checkReservation();
                    break;    
                case 4:
                    mm.ticketSave();
                    break;
                case 5:
                    fd.upload();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scan.close();
                    break Outter;
                
            
                default:
                    break;
            }

        }
    }
}
