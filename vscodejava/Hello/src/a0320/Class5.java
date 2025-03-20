package a0320;

public class Class5 {
    public static void main(String[] args) {

        // person1이라는 객체는 만들고 생성자에 "홍길동" 31 넣어 출력하시오

        Person person1 = new Person("홍길동",31);

        System.out.println("이름은 "+person1.name+"이고 나이는 "+person1.age+"입니다");
        
            }
        }
        
        class Person{
            public Person(String n, int a) {
                name = n;
                age =a;
            }
    String name;
    int age;

}
