package a0401.ramda;

import java.util.ArrayList;
import java.util.List;

class Student{
   
    private int id;
    private String name;
    private int age;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}

public class List2 {
    public static void main(String[] args) {
         //ArrayList 생성
        List<Student> studentList = new ArrayList<>();

        //객체추가
        studentList.add(new Student(101, "Alice", 20));
        studentList.add(new Student(102, "Bob", 22));
        studentList.add(new Student(103, "Charlie", 21));

        // ArrayList 내용 출력
        System.out.println("studentList 출력");
        printList(studentList);
        System.out.println();
        Student student = studentList.get(1);
        System.out.println(student);
        String studentName = studentList.get(1).getName();
        System.out.println(studentName);
        System.out.println();

        // 모든 Student의 이름만 출력
        System.out.println("\n모든 학생의 이름 출력");
        for(Student s:studentList){
            System.out.println(s.getName());
        }

        // 데이터 추가
        // 104, "David", 23

        // studentList.add(new Student(104, "David", 23));
        Student ss = new Student(104, "David", 23);
        studentList.add(ss);
        // printList(studentList);
        System.out.println(student);
        
        // 데이터 변경
        // 102, "Robert", 25
        // updateStudent 메서드 만들어서 변경
        System.out.println("\n특정 학생 변경");
        updateStudent(studentList, 102,"Robert",25);
        printList(studentList);

        //데이터 삭제
        System.out.println("\n특정 학생 삭제");
        deleteStudent(studentList, 103);
        printList(studentList);
        
        //특정 학생 검색
        System.out.println("\n 특정 학생 검색");
        Student searchedStudent = findStudentById(studentList, 104);
        System.out.println(searchedStudent != null ? searchedStudent:"학생을 찾을 수 없습니다." );

    }

    private static Student findStudentById(List<Student> studentList, int id) {

        for(Student student : studentList){
            if(student.getId() == id){  // studentList 중 매개변수로 입력된 102같으면
                return student;  // student 반환
            }
        }
        return null;
        // for(int i=0; i < studentList.size(); i++){
        //     if(studentList.get(i).getId() == id){
        //         return studentList.get(i);
        //     }
        // }
        // return null;
    }

    private static void deleteStudent(List<Student> studentList, int id) {
        for(int i=0; i < studentList.size(); i++){
        if(studentList.get(i).getId() == id){
            studentList.remove(i);  // remove 메서드에 인덱스 번호를 넣어주면 삭제됨 studentList.remove(studentList.get(i));
            System.out.println("학생 ID "+id+" 정보가 삭제되었습니다.");
            return;
        }
        
        }
        System.out.println("학생 ID "+id+" 정보를 찾을 수 없습니다.");
    }

    // 학생정보 업데이트
    private static void updateStudent(List<Student> studentList, int id, String newName, int newAge) {
        // 리스트를 돌면서 id가 같은 것을 찾아서 이름과 나이를 변경해 보세요
        // for(Student student : studentList){
        //     if(student.getId() == id){  // studentList 중 매개변수 입력된 102와 같으면
        //         student.setName(newName);  // Robert
        //         student.setAge(newAge);  // 25
        //         System.out.println("학생 ID "+id+" 정보가 수정되었습니다.");
        //         return;
        //     }
        // }
        // System.out.println("학생 Id"+id+"을 찾을 수 없습니다");

        for(int i=0; i<studentList.size();i++){
            if(studentList.get(i).getId() == id){
                Student updateStudent = new Student(id, newName, newAge);
                studentList.set(i, updateStudent);
                System.out.println("학생 ID "+id+" 정보가 수정되었습니다.");
                return;
            }
        }
        System.out.println("학생 Id"+id+"을 찾을 수 없습니다");
    }

    // arrayList 출력메서드
    private static void printList(List<Student>studentList) {
        for(Student s:studentList){
            System.out.println(s);
        }
    }
}
