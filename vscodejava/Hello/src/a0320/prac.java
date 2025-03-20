package a0320;

class Car {
    String model;
    int year;
    double price;

    // 생성자: 값을 초기화할 때 사용
    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // 정보 출력 메서드
    public void printInfo() {
        System.out.println("모델: " + model);
        System.out.println("연식: " + year);
        System.out.println("가격: " + price);
    }
}

public class prac {
    public static void main(String[] args) {
        // Car 객체 생성
        Car car1 = new Car("Sonata", 2021, 25000.50);
        
        // 객체 정보 출력
        car1.printInfo();
    }
}
