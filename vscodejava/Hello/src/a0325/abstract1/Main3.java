package a0325.abstract1;

//추상클래스
//abstract 키워드가 붙은 클래스
//객체를 직접 생성할 수 없음
//공통적인 기능을 정의 하고, 하위 클래스에서 구현하도록 강제하는 역할
//"일반메서드 + 추상 메서드(선언만 있고 구현은 없는 메서드) 를 가질수있음"
abstract class Animal {//추상클래스
    
    String name;

    public Animal(String name) {
        this.name = name;
    }
    
    abstract void makeSound(); //추상메서드(구현이 없다)
    
    void eat(){ //일반메서드
        System.out.println(name + " is eating");
    }

}

class Dog extends Animal{ //Animal를 상속

    public Dog(String name) {
        super(name);
    }


    @Override
    void makeSound() {
        System.out.println(name + " 멍멍!!");
    } 
    
}
class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }



    @Override
    void makeSound() {
        System.out.println(name + " 야옹!!");
    }

}

public class Main3 {
    public static void main(String[] args) {
       Animal dog = new Dog("Buddy");
       dog.makeSound();
       dog.eat();
        // Animal 클래스가 추상클랙스 이므로 직접 인스턴스를 만들 수 없고,
        // Dog와 같은 하위 클래스에서 인스턴스를 만들어야 합니다.

        Animal cat = new Cat("나비");
        cat.makeSound();
        cat.eat();
    }
    // 공통으로 들어갈 메서드 강제하고 (없으면 경고뜨고)
    // 부모의 메서드 이용가능
 }