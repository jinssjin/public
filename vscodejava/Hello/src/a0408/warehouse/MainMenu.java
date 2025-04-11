package a0408.warehouse;

import a1206.movie.AdminMenu;

class MainMenu extends AbstrctMenuGoods {

    private static MainMenu instance = new MainMenu(null);
    public static MainMenu getInstnce() {
        return instance;
    }
    
    private static String MAIN_MENU_TEXT = 
    "1. 상품 입고하기 \n" + "2. 상품 출고하기\n" + "3. 상품 조회하기\n" + "4. 관리자 메뉴로 이동\n" + "0: 종료\n\n" + "메뉴를 선택하세요: ";

    private MainMenu(Menu homeMenu){
        super(MAIN_MENU_TEXT,homeMenu);  // AbstrctMenuGoods의 생성자를 호출
    }

    @Override
    public Menu next(){
        switch (scan.nextLine()) {
            case "1":
                incomingGoods();
                return instance; // instance는 this로 대체가능 // 싱글톤 유일한 객체기 때문에 
                
            case "2":
                releaseGoods();
                return instance; // instance는 this로 대체가능 // 싱글톤 유일한 객체기 때문에 
                
            case "3":
                checkGoodsList();
                return instance; // instance는 this로 대체가능 // 싱글톤 유일한 객체기 때문에 
                
            case "4":
                if(!checkingpassword()) {
                    System.out.println("! 비밀번호를 확인하여주세요 !");
                    return next();
                }
                AdminMenu adminMenu = AdminMenu.getInstance();
                adminMenu.setHomeMenu(instance); // instance는 this로 대체가능 // 싱글톤 유일한 객체기 때문에 
                return adminMenu;
            
            case "0":
                return null;  // 싱글톤 객체로 안넘기고 종료
                
            default:
                System.out.println("잘못된 입력입니다.");
                return next();
        }
    }








    

private void checkGoodsList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkGoodsList'");
    }

    // 비밀번호 확인 메서드
    private boolean checkingpassword() {
        System.out.print("관리자 비밀번호 입력 >>");  // 요구 메세지 호출
        return "1234".equals(scan.nextLine());  // 입력 받은 값이 1234인지 true, false값 반환
    }


}
