package a0321;

public class StudentTest {
    public static void main(String[] args) {

        Student park = new Student(2019122104,"park");
        Student kim = new Student(2019112043,"kim");
        Student lee = new Student(2019152371,"lee");
        System.out.printf("Student 객체의 수: %d",Student.count);
    }
}

class Student{

    static int count; // 클래스 변수 : 공용으로 가지는 변수 (학생수, 독립된 id를 가진 학생의 수)
    
    int id;  // 인스턴스 변수
    String name;  // 인스턴스 변수
    
    Student(int i, String n){  // 생성자
        Student.count++;  // 클래스 변수에 객체가 생성될 때마다 1씩 증가
        id = i;
        name = n;
    }
}
