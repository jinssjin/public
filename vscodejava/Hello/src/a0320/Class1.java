package a0320;

public class Class1 {
    public static void main(String[] args) {
        
        // Cat.claw();   static이 없어서 오류
        // Cat.name = "네로";   static이 없어서 오류

        // static 없이 쓰려면

        // 객체
        Cat c = new Cat();  // Cat이라는 객체를 생성, Cat이라는 정보를 담을 수 있도록 공간을 만들어줌
        // 객체를 만드는 순간 초기값이 할당됨. 객체 c
        c.name = "네로";
        c.breeds = "페르시안";
        c.weight = 4.37;

        // 객체상태(필드) 출력
        System.out.printf("이름: %s\n",c.name); // '.' 닷연산자 : 객체를 접근하기 위한 연산자
        System.out.printf("품종: %s\n",c.breeds);
        System.out.printf("체중: %.2fkg\n",c.weight);
    }
}

class Cat {
    String name;   // 이름 : 필드, 인스턴스 변수
    String breeds; // 품종
    double weight; // 체중

    void claw(){   // 함수
        System.out.println("할퀴기");
    }
    void meow(){   // 함수
        System.out.println("야옹");
    }
}