package a0408.warehouse;

import java.io.IOException;
import java.util.ArrayList;

public class AdminMenu extends AbstrctMenuGoods{  // 관리자 메뉴로 기존 메뉴를 호출하기 위해 추상클래스에게 상속받음
    
    private static AdminMenu instance = new AdminMenu(null);
    private static final String ADMIN_MENU_TEXT = "1: 상품 등록하기\n"+"2: 상품 삭제하기\n" +"3: 상품 목록 보기\n" +"0: 메인 메뉴로 이동\n\n" +"메뉴를 선택하세요: ";

    public AdminMenu(Menu homeMenu) {
        super(ADMIN_MENU_TEXT, homeMenu); // super : 부모 생성자를 호출 (AbstrctMenuGoods 클래스에서 초기화한 객체?)
    }

    public static AdminMenu getInstance(){
        return instance;  // 싱글톤 객체의 게터 생성, 어드민 텍스트를 메인메뉴에서 불러낼떄 필요하겠지?
    }

    @Override
    public Menu next() { // 메뉴 출력 메소드를 출력
        if(Integer.parseInt(scan.nextLine()) == 1){  // 추상클래스에서 스캐너 객체를 선언해서 쓸 수 있음
            creatGoods();
            return next(); 
        }else if(Integer.parseInt(scan.nextLine()) == 2){
            deleteGoods();
            return next();
        }else if(Integer.parseInt(scan.nextLine()) == 3){
            printGoodsList();
            return next();
        }else if(Integer.parseInt(scan.nextLine()) == 0){
            return homeMenu;
        }else {
            System.out.println("잘못된 입력입니다. 1~3 중 다시 입력해주세요. 홈으로 다시 돌아가기를 원하시면 0번을 눌러주세요");
            return next();
        }
    
    }

    private void creatGoods() {
        System.out.println("===== <상품 등록> =====");
        System.out.println("설명 : 상품코드는 거래처이름+순서로 부여");
        System.out.println("상품코드 : ");
        String goodsCode = scan.nextLine();
        System.out.println("상품명 : ");
        String name = scan.nextLine();
        System.out.println("단가 : ");
        int price = scan.nextInt();
        System.out.println("과세(1) 혹은 면세(2)");
        String tax = scan.nextLine();
        if(tax.equals("과세") || tax.equals("1")){
            boolean taxFree = true;
        }else if(tax.equals("면세") || tax.equals("2")){
            boolean taxFree = false;
        }else{
            System.out.println("잘못된 입력입니다.");
            return;
        }
        Product productList = new Product(goodsCode, name, price, true);  // boolean taxFree = true; 과세, 세금계산서 발급 시 필요
        try {
            productList.saveList();
        } catch (IOException e) {
            System.out.println("파일 저장에 실패하였습니다.");
        }
        
    }

    private void deleteGoods() {
        printGoodsList();
        System.out.println("삭제할 상품코드를 선택하세요");
        try {
            Product.deleteGoodsList(scan.nextLine());
        } catch (IOException e) {
            System.out.println("삭제 실패");
        }
    }

    private void printGoodsList() {
        try {
            ArrayList<Product> productList = Product.listup();
            System.out.println("---------------------------");
            for(Product i:productList){
                System.out.printf("%s\n",i);
            }
        } catch (IOException e) {
            System.out.println("불러오기에 실패하였습니다.");
        }
    }

    
}
