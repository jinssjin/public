package a0408.warehouse;

import java.util.Scanner;

<<<<<<< Updated upstream
abstract class AbstrctMenuGoods implements Menu {
=======
public class AbstrctMenuGoods implements Menu {
>>>>>>> Stashed changes
    
    protected String menuTitle;
    protected Menu homeMenu;
    // protected 접근제어자 패키지 내 접근가능, 자식클래스가 접근 가능


    public void setHomeMenu(Menu homeMenu) {
        this.homeMenu = homeMenu;  // 세터, 홈메뉴 적용하기
    }

    public AbstrctMenuGoods(String menuTitle, Menu homeMenu) {
        this.menuTitle = menuTitle;
        this.homeMenu = homeMenu;
    }


    protected static final Scanner scan = new Scanner(System.in);

    public void printTittle(){  // return 값이 없어서 void 써줌
        System.out.println("\n"+menuTitle);  // 메뉴 목록 출력하기
    }
    
    // printTittle 메소드    
}
