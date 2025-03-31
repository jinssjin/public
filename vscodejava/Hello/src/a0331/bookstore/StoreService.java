package a0331.bookstore;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StoreService {
    private boolean reOrder = false;
    private int orderNum = 1;
    Map<String,Integer> orderList;
    Scanner scan = new Scanner(System.in);
    public StoreService() {
        orderList = new LinkedHashMap<>();
    }

    Book book = Book.getInstance();
    Customer customer;
    Thread t = new Thread();

    public void start(){
        System.out.println("어서오세요.");
        customer = new Customer(orderNum);
        book.getMenu();
        order();
        totalOrder();
        try {
            System.out.println("구매하신 도서가 나옵니다");
            t.sleep(2000);
            end();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void end() {

    }

    private void order() {
        System.out.println("\n취소를 원하시면 0번을 눌러주세요");
        end:while (true) {
            try {
                System.out.println("\n원하시는 음료의 번호를 선택해주세요");
                String choice = scan.next();
                int choiceNum = Integer.parseInt(choice.substring(0,1));
                if(choiceNum==0){
                    System.out.println("주문을 취소합니다.");
                    System.exit(0);
                }
                scan.nextLine();
                String bookName = book.bookList.get(choiceNum-1);
                System.out.println("선택하신 도서는 : "+bookName+"입니다. 몇 권 구매하시겠습니까?");
                int orderCount = scan.nextInt();
                scan.nextLine();

                if(reOrder){
                    for(String sellbook:orderList.keySet()){
                        if(sellbook.equals(bookName)){
                            int addCount = orderList.get(bookName).intValue()+orderCount;
                            orderList.replace(bookName, addCount);
                        }else{
                            orderList.put(bookName, orderCount);
                            break;
                        }
                    }
                }else{
                    orderList.put(bookName, orderCount);
                }

                addOrder();
                customer.setBookOrder(orderList);
                break end;

            } catch (Exception e) {
                System.out.println("잘못된 선택입니다.");
                continue;
            }
            
        }
    }

    private void addOrder() {
        reOrder = false;
        System.out.println("\n주문을 계속하시겠습니까?");
        System.out.println("예(Y) / 아니오(N)");
        String yesOrNo = scan.next();
        if(yesOrNo.equals("예") || yesOrNo.equalsIgnoreCase("y")){
            book.getMenu();
            reOrder = true;
            order();
        }else if(yesOrNo.equals("아니오") || yesOrNo.equalsIgnoreCase("N")){
            return;
        }
    }
    
    private void totalOrder(Customer customer) {
        int s = 1;
        int totalMoney = 0;
        int bookPrice = 0;
        DecimalFormat f = new DecimalFormat("###,000원");
        String name = customer.getOrderName()+"번";
        StringBuffer message = new StringBuffer();
        message.append("\n\n")
        .append("+----------------------------------------------------+\n ")
        .append("|                                                    | \n ")
        .append("|             " + name + "고객님의 주문 내역 입니다         | " + "\n");

        for(Map.Entry<String,Integer>order:customer.getBookOrder().entrySet()){
            String bookName = order.getKey();
            int orderCount = order.getValue();
            int bookUnitPrice = book.menu.get(bookName);
            bookPrice = bookUnitPrice * orderCount;
            totalMoney = totalMoney + bookPrice;

        }
    }
}
