package a0325.product1;

public class Product {
    private int id;
    private String name;
    private double price;
    
    // 값을 초기화(값을 한꺼번에 넣을때)
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // setter 값을 지정할 때
    // getter 값을 불러올 때

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // 객체를 인쇄할 때
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price= $" + price + "]";
    }
}
