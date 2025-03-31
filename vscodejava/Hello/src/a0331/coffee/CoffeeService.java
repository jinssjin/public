package a0331.coffee;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeService {

    private boolean reOrder = false;  // 고객의 추가주문 여부
    private int orderNum = 1;  // 고객 주문번호 1번
    Map<String,Integer> orderList;  // 주문한 커피목록(커피 이름, 수량)

    public CoffeeService() {
        // 커피 주문 및 결재시스템
        // 1. 커피 메뉴 출력
        // 2. 고객의 주문 입력처리
        // 3. 추가 주문 여부 확인
        // 4. 총 결제 금액 계산 및 결제 진행
        // 5. 음료 준비 완료 메시지 출력
        orderList = new LinkedHashMap<>();
    }
    // orderList : 고객 주문 저장
    // LinkedHashMap<>(); : 입력 순서 또는 접근순서 보장, 속도-약간느림, 용도-순서가 중요한 경우


    // 커피 객체 준비
    Coffee coffee = Coffee.getInstance();  // getInstance(); 커피메뉴 관리하는 싱글톤객체, new를 안씀
    Customer customer;  // 손님
    Thread t = new Thread();  // Thread 사용자가 처리할(프로그램 지정)  // 지연클래스
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("\n 어서오세요 더조은커피숍입니다.");
        customer = new Customer(orderNum);  // 주문번호, 잔액(카드)
        coffee.getMenu();
        // 주문 메서드
        order();
        totalOrder(customer);
        try{
            System.out.println("기다려 주시면 주문 하신 음료가 나옵니다.");
            t.sleep(2000); // 2초 후에 다음 문장이 실행됩니다.
            end();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void end() {
        int s = 1;
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                    .append("+----------------------------------------------------+\n ")
                    .append("|                                                    | \n ")
                    .append("|           " + customer.getOrderName() + " 고객님 주문하신 음료 나왔습니다         | " + "\n");
            System.out.print(message);
            for (Map.Entry<String, Integer> order : customer.getCoffeeOrder().entrySet()) {
                System.out.printf(" | [%d] %-20s : %2d잔  %7s |\n", s, order.getKey(), order.getValue(), "");
                s++;
            }
            System.out.println(" |                                                    |");
            System.out.println(" +----------------------------------------------------+");
            
    }

    private void totalOrder(Customer customer) {
        int s = 1;
        int totalMoney = 0;
        int coffeePrice = 0;
        DecimalFormat f = new DecimalFormat("###,000원");
        String name = customer.getOrderName()+"번 ";
        StringBuffer message = new StringBuffer();
            message.append("\n\n ")
            .append("+----------------------------------------------------+\n ")
            .append("|                                                    | \n ")
            .append("|             " + name + "고객님 의 주문 내역 입니다         | " + "\n");

            for(Map.Entry<String,Integer> order:customer.getCoffeeOrder().entrySet()){
                // coffeePrice = coffee.menu.get(order.getKey()) *  // 커피의 이름을 키로 해당커피의 가격
                //                 customer.getCoffeeOrder().get(order.getKey());  // 커피의 이름을 키로 해당커피의 수량
                String coffeeName = order.getKey(); // 커피이름
                int orderCount = order.getValue();  // 커피 수량
                int coffeeUintPrice = coffee.menu.get(coffeeName);  // 해당 커피 가격
                coffeePrice = coffeeUintPrice * orderCount;
                totalMoney = totalMoney + coffeePrice;
                String pay = f.format(coffeePrice); // 가격 포맷팅
                message.append(String.format(" | [%d] %-20s : %2d잔  %7s |\n", s, coffeeName, orderCount, pay));
                
                s++; // 리스트 인덱스 증가
            }
            message.append(" |                                                    |\n ")
            .append("+----------------------------------------------------+ \n")
            .append(" ============ 총 결제 금액은 " + f.format(totalMoney) + "입니다 ========== \n");
            System.out.println(message);
            payment(totalMoney);
    }

    private void payment(int totalMoney) {
        System.out.println("\n 결재를 도와드리겠습니다. 카드를 넣어주세요");
        int payResult = customer.getMoney() - totalMoney;
        // 고객 잔액 - 주문금액
        try {
            t.sleep(2500);  // 2.5초 후 실행
            System.out.println("결재중입니다......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(payResult < 0){
            System.out.println("잔액이 부족합니다. 확인 후 다시 주문해주세요");
            
        }else{
            customer.setMoney((payResult));
            System.out.println("결재가 완료되었습니다.");
            System.out.println("이용해주셔서 감사합니다.");
            orderNum++;
        }
        // payment(int totalMoney)는 고객의 잔액에서 총 주문 금액을 차감하고 결제 완료하는 기능 담당
    }

    private void order() {
        System.out.println("\n 취소를 원하시면 0번을 눌러주세요");
        end:while (true) {
            try{
            System.out.print("\n원하시는 음료의 번호를 선택해주세요");
            String choice = sc.next();
            int choiceNum = Integer.parseInt(choice.substring(0, 1));
            // 한글자만 추출해서 숫자로 변경
            if(choiceNum == 0){
                System.out.println("주문을 취소합니다.");
                System.exit(0);  // 빠져나감
            }
            sc.nextLine();  // 불필요한 내용 삭제
            String coffeeName = coffee.coffeeList.get(choiceNum-1);  // 주문번호에서 -1해야 인덱스 번호가 나옴
            System.out.println("선택하신 음료는 : "+coffeeName+"입니다. 몇 잔 주문하시겠습니까?");
            int orderCount = sc.nextInt();
            sc.nextLine();
            // 재주문 if
            if(reOrder){
                for(String coff : orderList.keySet()){
                    if(coff.equals(coffeeName)){
                        int addCount = orderList.get(coff).intValue()+orderCount;
                        // 주문리스트의 수량을 불러서 현재 수량과 더한다.
                        orderList.replace(coffeeName,addCount);  // 변경한다
                    }else{
                        orderList.put(coffeeName,orderCount);  // 커피이름, 주문한수량
                        break;
                    }
                }
            }else{
                orderList.put(coffeeName,orderCount);  // 커피이름, 주문한수량
                
            }
        

            // 추가 주문 메소드
            addOrder();
            customer.setCoffeeOrder(orderList);
            break end;

            }catch(Exception e){
                System.out.println("잘못된 선택입니다.");
                continue;
            }
           }     
        }
        
    
    
    private void addOrder() {
        reOrder = false;
        System.out.println("\n주문을 계속하시겠습니까?");
        System.out.println("예(Y) / 아니오(N)");
        String yesOrNo = sc.next();
        if(yesOrNo.equals("예") || yesOrNo.equalsIgnoreCase("y")){
            coffee.getMenu();
            reOrder = true;
            order();
        }else if(yesOrNo.equals("아니오") || yesOrNo.equalsIgnoreCase("n")){
            return;
        }

    }

}