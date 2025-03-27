package a0326.interface1;

interface Greeting{
    void sayHello();
    
    // java8 이상부터 사용가능한 default 메서드 : 일반메서드 생성은 안되지만 default써주면 생성가능
    default void sayGoodbye(){
        System.out.println("안녕히 가세요");
    }
}

class Person implements Greeting{

    @Override
    public void sayHello() {
        System.out.println("안녕하세요!");
    }

    // Person 클래스에만 존재하는 추가 메서드
    public void introduce(){
        System.out.println("저는 person 클래스입니다.");
    }

}

public class DefaultMethodEx {
    public static void main(String[] args) {
        Person person = new Person();
        person.sayHello();  // 인터페이스에서 오버라이드한 메소드
        person.sayGoodbye(); // 인터페이스의 default 메소드
        person.introduce();

        Greeting person1 = new Person();
        person1.sayHello();
        person1.sayGoodbye();
        // person1.introduce();  // 컴파일 에러, Greeting타입에는 introduce()가 없음

        // 다운캐스팅 : 부모 -> 자식타입으로 변환
        if(person1 instanceof Person){  // 부모-자식관계 인지를 물어보고
            ((Person)person1).introduce();
            // person1이 실제로는 Person의 객체이므로, Person으로 캐스팅하면 introduce(); 호출가능
        }

        
    }
}
