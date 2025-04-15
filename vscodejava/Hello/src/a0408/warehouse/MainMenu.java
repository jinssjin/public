package a0408.warehouse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class MainMenu extends AbstrctMenuGoods {

    private static MainMenu instance = new MainMenu(null);
    public static MainMenu getInstance() {
        return instance;
    }
    
    private static final String MAIN_MENU_TEXT =   // MAIN_MENU_TEXT는 static 변수인데, instance도 static으로 선언되어서 둘 다 동시에 static 초기화 시점에 로드된다. 그래서 final을 써줘서 순서를 준다.
    // instance 생성 시 값이 들어가게 해줌 final
    "1. 상품 입고하기\n" + "2. 상품 출고하기\n" + "3. 입고상품 조회하기\n" + "4. 관리자 메뉴로 이동\n" + "0: 종료\n\n" + "메뉴를 선택하세요: ";

    private MainMenu(Menu homeMenu){
        super(MAIN_MENU_TEXT,homeMenu);  // AbstrctMenuGoods의 생성자를 호출
    }

    @Override
    public Menu next(){
        switch (scan.nextLine()) {
            case "1":
                incomingGoods(); // 입고하기
                return instance; // instance는 this로 대체가능 // 싱글톤 유일한 객체기 때문에 
                
            case "2":
                releaseGoods();  //출고하기
                return instance; // instance는 this로 대체가능 // 싱글톤 유일한 객체기 때문에 
                
            case "3":
                checkInOutList(); // 입출고내역조회하기
                return instance; // instance는 this로 대체가능 // 싱글톤 유일한 객체기 때문에 
                
            case "4":
                if(!checkingpassword()) {
                    System.out.println("! 비밀번호를 확인하여주세요 !");
                    return this;
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

    

    private void incomingGoods() {
        try {
            ArrayList<Product> products = Product.listup();
            for(Product p:products){
                System.out.printf("%s\n",p.toString());
            }
            System.out.println("입고 상품코드을 선택해주세요");
            String goodsCode = scan.nextLine();
            System.out.println("수량을 선택해주세요");
            int amount = Integer.parseInt(scan.nextLine().trim());
            ArrayList<InOut> inOutlList = InOut.findByCode(goodsCode);
            // Position area = new Position(inOutlList);  // 상품위치 추가할 시
            LocalDateTime makeCode = LocalDateTime.now();
            DateTimeFormatter makeCodeformatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
            String formattedDate = makeCode.format(makeCodeformatter);
            Product thatP = Product.findByGoosCode(goodsCode);
            InOut goods = new InOut("입고", formattedDate, thatP.getGoodsCode(), thatP.getName(), thatP.getPrice(), amount);
            goods.save();
            System.out.println("입고처리가 완료되었습니다.");
        } catch (IOException e) {
            System.out.printf("파일을 불러올 수 없습니다. : %s\n",e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.printf("입고 실패 : %s\n",e.getMessage());
        }
    }
    private void releaseGoods() {
        System.out.print("입고코드를 입력하세요");
                try{
                    InOut outGoods = InOut.outProducts(scan.nextLine()); // 입고코드로 객체 검색
                    if(outGoods != null){
                        System.out.printf("상품출고완료 %s\n",outGoods.toString());
                    }else{
                        System.out.println("입고내역 없음");
                    }
                }catch(IOException e){
                    System.out.println("파일 읽기에 실패했습니다");
                }
           }

    

           private void checkInOutList() {
            try {
                ArrayList<Product> products = Product.listup();
                for (Product p : products) {
                    System.out.printf("(%s) %s [%d]  // %s\n",p.getGoodsCode(),p.getName(),p.getPrice(),p.getTaxFree());
                }
                System.out.print("조회할 상품 코드를 입력하세요: ");
                String goodsCode = scan.nextLine();
                ArrayList<InOut> list = InOut.findByCode(goodsCode);
                if (list.isEmpty()) {
                    System.out.println("해당 상품의 입출고 내역이 없습니다.");
                } else {
                    for (InOut inout : list) {
                        System.out.println(inout.toString());  // InOut 클래스에 toString() 추가 필요
                    }
                }
            } catch (IOException e) {
                System.out.println("입출고 내역을 불러올 수 없습니다.");
            }
        }
        

    // 비밀번호 확인 메서드
    private boolean checkingpassword() {
        System.out.print("관리자 비밀번호 입력 >>");  // 요구 메세지 호출
        return "1234".equals(scan.nextLine());  // 입력 받은 값이 1234인지 true, false값 반환
    }


}
