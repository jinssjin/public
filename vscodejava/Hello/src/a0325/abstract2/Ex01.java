package a0325.abstract2;


abstract class Vehicle {
    String name;

    public Vehicle(String name) {
        this.name = name;
    }

    abstract void move();
    
    void displayInfo(){
        System.out.println("이 차량은 ["+name+"] 입니다.");
    }

    
}

class Car extends Vehicle{

    public Car(String name) {
        super(name);
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("자동차 ["+name+"]이(가) 도로를 달립니다.");
    }

    @Override
    void move() {
        // TODO Auto-generated method stub
        
    }
    
}

class Bicycle extends Vehicle{

    public Bicycle(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    @Override
    void displayInfo() {
        // TODO Auto-generated method stub
        super.displayInfo();
        System.out.println("자전거 ["+name+"]이(가) 페달을 밟으며 이동합니다.");
    }

    @Override
    void move() {
        // TODO Auto-generated method stub
        
    }

}


public class Ex01 {
    public static void main(String[] args) {
        Vehicle car = new Car("벤츠");
        car.move();
        car.displayInfo();

        Vehicle bicycle = new Bicycle("삼천리");
        bicycle.move();
        bicycle.displayInfo();
    }
}
