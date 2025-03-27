package a0326.coffee1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeOrder {
    public static void main(String[] args) {
        Map<String, Integer> menu = new HashMap<>();

        menu.put("Americano",3000);
        menu.put("Latte",4000);
        menu.put("Mocha",4500);
        menu.put("Espresso",2500);

        Map<String, Integer> order = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n메뉴");
            for(Map.Entry<String,Integer> entry:menu.entrySet()){
               System.out.println(entry.getKey() + "-" + entry.getValue()+"원");
            }
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
            if(coffee.equalsIgnoreCase("exit")){
                break;
            }
            if(!menu.containsKey(coffee)){  // 입력한 커피이름이 menu맵의 키에 포함되지않으면
                System.out.println("해당 커피는 메뉴에 없습니다. 다시 입력 바랍니다.");
                continue;
            }

            System.out.printf("수량: ");
            int quantity;
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
            }




            scanner.close();

            System.out.println("\n 주문 내역");
            int total = 0;
            for(Map.Entry<String,Integer> entry:order.entrySet()){
                int price = menu.get(entry.getKey())*entry.getValue();
                System.out.println(entry.getKey() + "x" + entry.getValue()+"="+price+"원");
                total += price;
             }






            // order("Americano",3)
            // menu.get("Americano") = 3000
            // entry.getValue() = 3
            //price = 9000

             System.out.println("총 금액:"+total+"원");
        }
    }

