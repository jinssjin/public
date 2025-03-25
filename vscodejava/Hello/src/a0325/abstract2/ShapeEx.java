package a0325.abstract2;

abstract class Shape{
    String type;

    public Shape(String type) {
        this.type = type;
    }
 
    abstract double area();
    abstract double length();
}

class Circle extends Shape{

    int r;

    public Circle(int r) {
            super("원");
            this.r = r;
        }
    
    @Override
    double area() {
        return r *r * Math.PI;
    }

    @Override
    double length() {
        return 2 * Math.PI * r;
    }

    @Override
    public String toString() {
        return "Shape [type=" + type + ", r=" + r + "]";
    }

}

class Rectangle extends Shape {

    public Rectangle(int width, int height) {
        super("사각형");
        this.width = width;
        this.height = height;
    }

    int width, height;

    @Override
    double area() {
        return width * height;
    }

    @Override
    double length() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle [type=" + type + ", width=" + width + ", height=" + height + "]";
    } 

    
}

public class ShapeEx {
 public static void main(String[] args) {
    // Shape[] shapes = new Shape[2];
    // shapes[0] = new Circle(10);
    // shapes[1] = new Rectangle(5, 5);
    // for(Shape s: shapes){
    //     System.out.println(s);
    //     System.out.println("넓이:"+s.area()+" 둘레:"+s.length());
    // }

    Shape c = new Circle(10);
    System.out.println(c);
    System.out.println("넓이:"+c.area()+" 둘레:"+c.length());
    Shape r = new Rectangle(5,5);
    System.out.println(r);
    System.out.println("넓이:"+r.area()+" 둘레:"+r.length());

    // 다형성 - Shape는 추상클래스이기 때문에 Shape[] Circle과
    // Rectangle 객체 모두 담을 수 있다.
    // 각 객체는 area()와 length()메서드를 각기 다르게 구현하므로
    // 해당 메서드가 호출될 때 다르게 동작합니다.

    // 추상클래스와 상속 : Shape는 추상클래스이고, Circle과 Rectangle은
    // 이를 상속받아 자신만의 방법으로 넓이와 둘레를 계산합니다.
 }   
}
