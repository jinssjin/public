package a0408.warehouse;

public class MainProgram {
    public static void main(String[] args) {
        System.out.println("물류관리프로그램에 오신걸 환영합니다.");
        Menu menu = MainMenu.getInstance();  // .getInstance();메서드 : MainMenu 클래스에서 객체를 싱글톤 방식으로 가져오는 역할
        // 메인 메뉴 객체하나를 생성해서 menu에 초기화
        while(menu != null){  // 메뉴가 비어있지 않을때 계속 반복
            menu.printTittle();  // 현재 메뉴을 출력하는 메소드
            menu = menu.next();  // 메뉴 시스템에서 입력받아 다음메뉴를 넣어줌 위 구문 반복
        }

    }
}

interface Menu {  // public을 왜 뺄까 interface를 더 공부해보기
    void printTittle();
    Menu next();
    
}