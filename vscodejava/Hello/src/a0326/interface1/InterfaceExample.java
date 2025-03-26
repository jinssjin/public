package a0326.interface1;


interface Animal {
    void makeSound();  // abstract을 쓰지않아도 추상메서드로 생성, abstract 생략 가능
    // 일반 메서드 사용 금지

    // void eat(){
    //     System.out.println("맛나게 먹어요");
    // } 
    // 일반 메서드 생성시 오류남
}

// 인터페이스를 구현하는 클래스

class Dog implements Animal{
    @Override
    public void makeSound(){
        System.out.println("멍멍");
    }
}

class Cat implements Animal{
    @Override
    public void makeSound(){
        System.out.println("야옹");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        // Animal ani = new Animal();
        // 인터페이스는 추상클래스와 마찬가지로 자신을 객체로 만들지 못함.
        Animal dog = new Dog();
        Animal cat = new Cat();
        // main() 메서드에서 다형성을 활용하여 Animal 타입으로 Dog와 Cat 객체를 사용할 수 있음
        dog.makeSound();
        cat.makeSound();
    }
}
