package a0401.order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import a0327.exception1.customException;

class Customer {
    private final String name;
    private final String city;

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Order {
    private final int id;
    private final Customer customer;
    private final String product;
    private final int quantity;

    public Order(int id, Customer customer, String product, int quantity) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Kim", "Seoul");
        Customer customer2 = new Customer("Lee", "Busan");
        Customer customer3 = new Customer("Park", "Seoul");
        Customer customer4 = new Customer("Choi", "Seoul");

        List<Order> orders = Arrays.asList(
                new Order(1, customer1, "Laptop", 1),
                new Order(2, customer2, "Smartphone", 2),
                new Order(3, customer3, "Keyboard", 1),
                new Order(4, customer1, "Mouse", 3),
                new Order(5, customer4, "Monitor", 1),
                new Order(6, customer3, "USB Cable", 2)
        );

        // 여기에 답을 작성하세요.

        // 문제 1: 서울에 사는 고객의 주문만 출력하시오
            System.out.println("서울에 사는 고객의 주문리스트");
            orderToSeoul_q1(orders);
            System.out.println();
            System.out.println();

        // 문제 2: 모든 주문의 총 수량을 구하시오.(mapToInt사용)
            System.out.println("모든 주문의 총 수량");
            orderProductCount_q2(orders);
            System.out.println();
            System.out.println();

        // 문제 3: 각 고객의 이름과 그 고객이 주문한 제품명을 출력하시오.
            System.out.println("각 고객의 이름-제품명 출력");
            nameProduct_q3(orders);
            System.out.println();
            System.out.println();
    
        // 문제 4: 특정 고객("Kim")의 주문만 필터링하여 출력하시오.
            System.out.println("kim의 주문찾기");
            kimsOrder_q4(orders);
            System.out.println();
            System.out.println();

        // 문제 5: 주문 수량이 2개 이상인 주문만 출력하시오.    
            System.out.println("주문수량 2개이상 주문");
            findTwoOrder_q5(orders);
            System.out.println();
            System.out.println();

        // 문제 6: 고객이 주문한 제품의 종류를 중복 없이 출력하시오.
            System.out.println("제품종류 출력");
            noticeProduct_q6(orders);
            System.out.println();
            System.out.println();

        // 문제 7. 모든 주문을 quantity 기준 내림차순으로 정렬하시오.
            System.out.println("수량 내림차순으로 주문 정렬");
            orderRange(orders);
            System.out.println();
            System.out.println();

        // 문제 8.각 도시별로 고객 수를 출력하시오. (count이용)
            System.out.println("도시별 고객수");
            cityToCustomer(orders);

        }

        
        private static void cityToCustomer(List<Order> orders) {
            long busanCount = orders.stream()
            .filter(bu -> "Busan".equals(orders))
            .count();

            long seoulCount = orders.stream()
            .filter(se -> "Seoul".equals(orders))
            .count();

            

        }


        private static void orderRange(List<Order> orders) {
            List<Order> result = orders.stream()
            .sorted(Comparator.comparing(Order::getQuantity))
            .collect(Collectors.toList());
            System.out.println(result);
        }


        private static void noticeProduct_q6(List<Order> orders) {
            List<String> result = orders.stream()
            .map((pd) -> pd.getProduct())
            .distinct()
            .collect(Collectors.toList());
            System.out.println(result);
        }


        private static void findTwoOrder_q5(List<Order> orders) {
            List<Order> result = orders.stream()
            .filter(order -> order.getQuantity() >= 2)
            .collect(Collectors.toList());
            System.out.println(result);            
        }


        private static void kimsOrder_q4(List<Order> orders) {
            List<Order> result = orders.stream()
                .filter(kim -> "Kim".equals(kim.getCustomer().getName()))
                .collect(Collectors.toList());
                System.out.println(result);
        }

        private static void nameProduct_q3(List<Order> orders) {
            List<String> result = orders.stream()
            .map(Order::getCustomer)
            .map(Customer::getName)
            .collect(Collectors.toList());
            System.out.println(result);
            
            

        }

    private static void orderProductCount_q2(List<Order> orders) {
        int result = orders.stream()
        .mapToInt((q) -> q.getQuantity())
        .sum();
        System.out.println(result);
    }


    private static void orderToSeoul_q1(List<Order> orders) {
        List<Order> result = orders.stream()
        .filter(cu -> "Seoul".equals(cu.getCustomer().getCity()))
        .collect(Collectors.toList());
        System.out.println(result);
        
    }

}