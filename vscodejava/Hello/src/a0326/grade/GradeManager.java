package a0326.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {
    // 공용의 공간에 만들어줌 (여러 파일에서 쓸 수 있게)
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);
    private static int idCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== 성적 관리 프로그램 ===");
            System.out.println("1. 성적 추가");
            System.out.println("2. 성적 조회");
            System.out.println("3. 성적 수정");
            System.out.println("4. 성적 삭제");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("프로그램 종료.");
                    System.exit(0);
                    // return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");

                }
            }
        }
                    
                    
                    
        private static void deleteStudent() {
            System.out.print("삭제할 학생 ID 입력: ");
            int id = scan.nextInt();
            scan.nextLine();
            
            for(Student delstudent : students){
                if(delstudent.getId() == id){
                    students.remove(delstudent);
                    System.out.println("성적이 삭제되었습니다.");
                    return;
                }
            }
            System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
        }

                    
                    
        private static void updateStudent() {
            System.out.print("수정할 학생 ID 입력: ");
            int id = scan.nextInt();
            scan.nextLine();

            for(Student student : students){  // students 리스트를 순회하며 
                if(student.getId() == id){
                    System.out.print("새로운 점수 입력:");
                    int newScore = scan.nextInt();
                    scan.nextLine();
                    student.setScore(newScore);
                    System.out.println("성적이 수정되었습니다.");
                    return;  // return;을 써주지않으면 학생을 찾아 수정 후에도 끝까지 루프를 실행. 전체 학생을 돌 필요가 없기 떄문에 불필요한 시간을 절약해준다.
                    }
                }
                System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
            }

                    
                    
    private static void viewStudent() {
        if(students.isEmpty()){  // 학생이 없으면 : ArrayList가 비어있다면
            System.out.println("등록된 ");
        }else{
            System.out.println("\n-----성적목록-----");
            for(Student s : students){
                s.display();  // 직접 만든 출력 메서드를 사용
                // System.out.println(s);  // toString을 이용 , toString은 자바자체 메서드
            }
        }
    }

    // 성적 추가
    private static void addStudent() {
        System.out.print("학생 이름: ");
        String name = scan.nextLine();
        System.out.print("점수 입력: ");
        int score = scan.nextInt();
        scan.nextLine();
        // 생성자가 빈 생성자만 있을 떄 쓸 수 있는 방법
        // public Student(){} : Student.java에 있는 빈 생성자
        // Student student = new Student();
        // student.setId(idCount++);
        // student.setName(name);
        // student.setScore(score);

        Student student = new Student(idCounter++,name,score);
        students.add(student);  // students라는 ArrayList에 정보를 넣는다
        System.out.println("성적이 추가되었습니다.");

    }
}
