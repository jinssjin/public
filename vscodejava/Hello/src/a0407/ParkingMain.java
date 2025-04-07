package a0407;

import java.util.Scanner;

public class ParkingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingManager lot = new ParkingManager();

        End : while (true) {
            System.out.println("\n1. 입차  2. 출차  3. 전체목록  0. 종료");
            System.out.print(">");
            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.print("차량번호 입력: ");
                String number = sc.next();
                System.out.print("입차 시간 입력(숫자): ");
                int inTime = sc.nextInt();
                lot.parkCar(number, inTime);

            } else if (menu == 2) {
                System.out.print("차량번호 입력: ");
                String number = sc.next();
                System.out.print("출차 시간 입력(숫자): ");
                int outTime = sc.nextInt();
                lot.exitCar(number, outTime);

            } else if (menu == 3) {
                lot.showCars();

            } else if (menu == 0) {
                System.out.println("프로그램 종료");
                break End;

            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        sc.close();
    }
}
