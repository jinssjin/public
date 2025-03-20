package a0320;

public class Class4 {
    public static void main(String[] args) {

        Student s = new Student("이순신",3,"소프트웨어공학과");  // 객체가 만들어짐과 동시에 생성자에서 불러야됨
        Student s1 = new Student("홍길동",2,"산업공학과");

        System.out.printf("이름:%s, 학년:%d, 학과:%s%n",s.name,s.grade,s.department);
        System.out.printf("이름:%s, 학년:%d, 학과:%s",s1.name,s1.grade,s1.department);
                
            }
        }
        
        class Student{
            public Student(String n, int g, String d) {  // 생성메서드, 생성자
                name = n;
                grade = g;
                department = d;     
            }

    String name;
    int grade;
    String department;

}
