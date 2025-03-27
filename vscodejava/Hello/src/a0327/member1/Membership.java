package a0327.member1;

import java.nio.channels.FileChannel.MapMode;
import java.util.Scanner;

public class Membership {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberMager MemberMager = new MemberMager();
        while (true) {
            System.out.println("\n===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 검색");
            System.out.println("3. 회원 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 전체 회원 목록 보기");
            System.out.println("6. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    //이름, 나이, 이메일을 입력받아 회원을 추가하는 addMember() 메서드 만들기
                    System.out.println("이름");
                    String addName = scanner.nextLine();
                    System.out.println("나이");
                    int addAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("이름");
                    String addEmail = scanner.nextLine();
                    MemberMager.addMember(addName,addAge,addEmail);
                    System.out.println("회원이 추가되었습니다.");
                    break;

                case 2:                     
                    System.out.print("검색할 회원의 이름을 입력하시오 : ");
                    String searchName = scanner.nextLine();
                    Member foundMember = MemberMager.findMember(searchName);
                    if(foundMember != null){
                        System.out.println("회원정보 : "+foundMember);
                    }else{
                        System.out.println("해당이름의 회원없음");
                    }

                case 3:
                    System.out.print("이름을 입력하시오");
                    String newName = scanner.nextLine();
                    System.out.print("나이를 입력하시오");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("이메일을 입력하시오");
                    String newEmail = scanner.nextLine();
                    MemberMager.upDateMember(newName,newAge,newEmail);
                    System.out.println("회원정보가 수정되었습니다.");
                    break;
                case 4:
                    System.out.print("삭제할 회원의 이름을 입력하시오");
                    String delName = scanner.nextLine();
                    MemberMager.deleteMember(delName);
                    System.out.println("회원정보가 삭제되었습니다.");
                    break;
                case 5:
                //회원 목록을 출력하는 displayAllMembers() 메서드 만들기
                MemberMager.displayAllMembers();
                               
                break;

                case 6:
                    System.out.println("프로그램 종료");
                    scanner.close();
                    System.exit(0);
                break;
            
                default:
                System.out.println("잘못된 선택입니다.");
                    break;
            }
        }
    }
}
