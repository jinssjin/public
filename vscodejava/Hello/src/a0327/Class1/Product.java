package a0327.Class1;

public class Product {
    private String name;
    private ProductStatus status;


    public Product(String name, ProductStatus status) {
        this.name = name;
        this.status = status;
    }

    public void PrintStatus(){
        System.out.println(name + " 상태 " + status);

    }
    public static void main(String[] args) {
        Product product1 = new Product("노트북", ProductStatus.AVAILABLE);
        Product product2 = new Product("스마트폰", ProductStatus.OUT_OF_STOCK);
        Product product3 = new Product("Mp3 플레이어", ProductStatus.DISCOUNTINUED);

        product1.PrintStatus();
        product2.PrintStatus();
        product3.PrintStatus();
    }
}

// 상품 상태를 명확하게 관리
