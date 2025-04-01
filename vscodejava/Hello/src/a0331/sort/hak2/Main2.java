package a0331.sort.hak2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // 학생 수 입력
        System.out.print("학생 수를 입력하세요: ");
        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 소비

        // 학생 배열 생성
        // Student[] students = new Student[n];

        // 학생 정보 입력
        for (int i = 0; i < n; i++) {
            System.out.print("학생 이름: ");
            String name = sc.nextLine();
            System.out.print("학생 나이: ");
            int age = sc.nextInt();
            System.out.print("학생 학번: ");
            int studentId = sc.nextInt();
            sc.nextLine(); // 개행 문자 소비

            // students[i] = new Student(name, age, studentId);
            students.add(new Student(name, age, studentId));
        }

        // 삽입 정렬 실행
        insertionSort(students);

        // 정렬된 결과 출력
        System.out.println("정렬된 학생 목록:");
        for (Student student : students) {
            System.out.println(student);
        }

        sc.close(); // Scanner 닫기
    }

    // 삽입 정렬 (이름 기준 오름차순 정렬)
    private static void insertionSort(ArrayList<Student> students) {
        int n = students.size();
        for (int i = 1; i < n; i++) {
            Student currentStudent = students.get(i);
            int j = i - 1;

            // 현재 학생의 이름을 이전 학생들과 비교하여 정렬
            while (j >= 0 && students.get(j).getName().compareTo(currentStudent.getName()) > 0) {
                // students[j + 1] = students[j]; // 한 칸씩 뒤로 이동
                students.set(j+1, students.get(j));   // j+1에 students.get(j) 한것으로 변경하겠다.
                j--;
            }
            // students[j + 1] = currentStudent; // 적절한 위치에 삽입
            students.set(j+1, currentStudent);
        }
    }
}

// 학생 클래스 정의
class Student {
    private String name;
    private int age;
    private int studentId;

    // 생성자
    public Student(String name, int age, int studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + "]";
    }
}