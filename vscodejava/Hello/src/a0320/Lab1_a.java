package a0320;


class Square {
    int length;
    int area(){  //위로 리턴하려면 void가 아니라 int 받아야한다
        return length * length;
    }
    }

    
public class Lab1_a {


    public static void main(String[] args) {
        Square s = new Square();
        s.length = 4;
        
        System.out.printf("한 변의 길이가 %d인 정사각형의 넓이: %d",s.length,s.area());
    }
}


// 객체지향프로그램(Object-Oriented Programming) : OOP
// 객체 지향 프로그램 장점
// 1. 프로그램 유지보수가 좋습니다.
// 2. 코드 재사용이 수월합니다.

// 클래스 : 객체의 설계도
// 클래스를 토대로 만들어진 프로그램의 구성요소를 객체
// 클래스 설계 : 필드와 메소드로 이루어짐
// Dog d1 = new Dog(); : Dog 객체 만들어서 d1 연결