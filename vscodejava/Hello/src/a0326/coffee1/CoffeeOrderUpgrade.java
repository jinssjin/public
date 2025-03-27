package a0326.coffee1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeOrderUpgrade {
    public static void main(String[] args) {
        Map<String, Integer> menu = new HashMap<>();

        menu.put("Americano",3000);
        menu.put("Latte",4000);
        menu.put("Mocha",4500);
        menu.put("Espresso",2500);

        Map<String, Integer> order = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("몇 명의 주문을 받으시겠습니까?");
        int numOfPeople = scanner.nextInt();
        scanner.nextLine();
// for문 시작-1
        for(int i =1; i <= numOfPeople;i++){

            System.out.println();
            System.out.println(i+"번째 고객님 주문을 시작합니다.");
        
// while문 시작-1
        while (true) {
            System.out.println("\n메뉴");
// for문 시작-2
                for(Map.Entry<String,Integer> entry:menu.entrySet()){
                System.out.println(entry.getKey() + "-" + entry.getValue()+"원");
                }
// for문 끝-2
                // menu.entrySet() : 커피 이름과 가격을 저장하고 있는 저장 집합
                // entry.getKey : 커피이름(Americano) 저장한 String 값 키 이름
                // entry.getValue : 커피값 (3000) 저장한 키 값

                // for(String coffee:menu.keySet()){
                //     System.out.println(coffee +" - "+menu.get(coffee));
                // }
                // menu.keySet() : menu의 모든키(커피이름)
                // menu.get(coffee)를 사용하여 해당 키(커피이름)에 대한 값을 가져옵니다.
            System.out.print("주문할 커피 이름(종료:exit)");
            String coffee = scanner.nextLine();
// if문 시작-1
                if(coffee.equalsIgnoreCase("exit")){
                    break;
                }
// if문 끝-1
// if문 시작-2
                if(!menu.containsKey(coffee)){  // 입력한 커피이름이 menu맵의 키에 포함되지않으면
                    System.out.println("해당 커피는 메뉴에 없습니다. 다시 입력 바랍니다.");
                    continue;
                }
// if문 끝-2
            System.out.printf("수량: ");
            int quantity;
// while문 시작-2
                while (true) {
                
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());    
                        if(quantity<=0){
                            System.out.println("1 이상의 숫자를 입력하세요");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력해주세요");
                        continue;
                    }
                    break;
                }
// while문 끝-2
            

            // order.put(coffee, quantity);

            order.put(coffee,order.getOrDefault(coffee, 0)+quantity);

            // getOrDefault()는 Map에서 키가 존재하지 않을 경우 기본값을 반환하는 메서드
            // null 값을 방지하고, 기본값을 처리
            // 아래와 같은 역할
                // if(menu.containsKey(coffee)){
                //     order.put(coffee, quantity);  키가 존재할 경우 등록
                // }
            // containsKey를 사용할 필요없이 코드가 간결. 
            System.out.println(coffee+" "+quantity+" 개 추가 되었습니다.");
// while문 끝-1
            break;
            }
            
            
// for문 끝-1
        }

            System.out.println("\n 주문 내역");
            int total = 0;
            for(Map.Entry<String,Integer> entry:order.entrySet()){
                int price = menu.get(entry.getKey())*entry.getValue();
                System.out.println(entry.getKey() + "x" + entry.getValue()+"="+price+"원");
                total += price;
             }

             double finalCharge = 0;
             double discountCharge = 0;
            if(total >= 20000){
                finalCharge = total*0.9;
                discountCharge = total*0.1;
                System.out.printf("총 금액: %d원",total);
                System.out.println();
                System.out.printf("할인 적용: 10%% 할인 - %.0f원",discountCharge);
                System.out.println();
                System.out.printf("총 금액: %.0f원",finalCharge);   
            }else{
                System.out.printf("총 금액: %d원",total);
            }
            // order("Americano",3)

            // menu.get("Americano") = 3000
            // entry.getValue() = 3
            //price = 9000
        
    }

}
