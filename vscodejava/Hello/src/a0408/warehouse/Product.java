package a0408.warehouse;

import java.time.LocalDate;

public class Product {
    private String goodsCode;         // 상품 코드
    private String name;              // 상품 이름
    private int price;                // 가격
    private String position;          // 위치
    private String inTime;            // 입고시각
    private String outTime;           // 출고시각
    private String amount;            // 수량
    private LocalDate espirationDate; // 유통기한
    private boolean taxFree;          // 면세 여부

}

