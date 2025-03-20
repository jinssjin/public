package a0320;

public class Class5_1 {
    public static void main(String[] args) {

        // person1이라는 객체는 만들고 생성자에 "홍길동" 31 넣어 출력하시오

        Person1 p1 = new Person1("홍길동",31);
        Person1 p2 = new Person1();

        p2.name = "이순신";
        p2.age = 25;

            System.out.println("이름은 "+p1.name+"이고 나이는 "+p1.age+"입니다");
            System.out.println("이름은 "+p2.name+"이고 나이는 "+p2.age+"입니다");

                
                    }
                }
                
                class Person1{
                    String name;  // 초기값이 name
                    int age;
                    public Person1(String name, int age) {
                        this.name = name; // 홍길동 매개변수도 name 이기 떄문에 둘을 구분하기 위해서 this.를 넣어준다
                        this.age = age;  // 31
                    }
                    public Person1() {

                    }

            // 자바 프로그램이 알아서 기본생성자를 만들어 준다.
            // public Person1(){

            // }

            // 하지만 person1생성자가 있는 상태에서 person2생성자를 만들고 싶다면 자동으로 기본생성자 안만들어줌
            // 그래서 같이 쓰고 싶으면 기본생성자를 만들어라
}
