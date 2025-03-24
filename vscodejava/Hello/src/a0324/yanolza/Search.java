package a0324.yanolza;

import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccommodationManager manager = new AccommodationManager();
        boolean flag = true;

        while (flag) {
            System.out.println("\n숙소 예약 시스템에 오신 것을 환영합니다.");
            System.out.println("1. 예약 가능한 숙소 보기");
            System.out.println("2. 숙소 예약하기");
            System.out.println("3. 예약한 숙소 보기");
            System.out.println("4. 숙소 추가하기");
            System.out.println("5. 숙소 삭제하기");
            System.out.println("6. 숙소 정보 수정하기");
            System.out.println("7. 숙소 정보 조회하기");
            System.out.println("8. 종료");
            System.out.print("원하는 작업을 선택하세요 > ");   
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                System.out.println("예약 가능한 숙소 보기");
                manager.allAccommodation();
                    break;
                case 2:
                System.out.println("2. 숙소 예약하기");
                System.out.println("숙박하려는 숙소 이름을 입력하시오");
                String AccName = scanner.nextLine();
                if(manager.BookingList(AccName)){
                    System.out.println("선택하신 숙소가 정상적으로 예약되었습니다.");
                }else{System.out.println("선택하신 숙소를 찾을 수 없습니다.");}
                    break;
                case 3:
                System.out.println("3. 예약한 숙소 보기");
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}
