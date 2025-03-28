package a0328.file2;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
    private ArrayList<StudentDTO> sList;
    Scanner sc = new Scanner(System.in);
    FileClass file = new FileClass("student","student_Grade");

    private void insert(StudentDTO s) {
        sList.add(s);
    }

    private void delete(int index) {
        sList.remove(index);
    }

    private StudentDTO select(int index) {
        return sList.get(index);  // sList에서 index에 해당되는 StudentDTO객체 반환
    }

    private void Update(int index,StudentDTO s) {
        sList.set(index,s);
    }

    public StudentDAO(){
        sList = new ArrayList<StudentDTO>();
        // 기본데이터 - 4명의 더미데이터 생성
        StudentDTO s1 = new StudentDTO(0,"테스트1",11,100,90,80);
        StudentDTO s2 = new StudentDTO(1,"테스트2",22,90,89,91);
        StudentDTO s3 = new StudentDTO(2,"테스트3",33,85,77,55);
        StudentDTO s4 = new StudentDTO(3,"테스트4",44,77,68,85);
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);
    }

    public void userInsert() {
        StudentDTO s = new StudentDTO();
        s.setId(sList.size());  // 새로운 아이디 : sList.size() = 4개, 4가 반환,  s.setId(4); = id에 4를 저장
        System.out.println("<학생 추가하기>");
        System.out.print("이름 : ");
        s.setName(sc.next());  // 문자로 입력받은것은 setter로 객체 s에 이름에 추가
        System.out.print("나이 : ");
        s.setAge(sc.nextInt());
        System.out.print("국어 점수 : ");
        s.setKor(sc.nextInt());
        System.out.print("영어 점수 : ");
        s.setEng(sc.nextInt());
        System.out.print("수학 점수 : ");
        s.setMath(sc.nextInt());

        // sList.add(s);  // 입력받은 정보를 추가
        insert(s);  // 입력받은 정보를 추가하는 함수 만들기
        System.out.println("학생이 추가 되었습니다.");

    }

    public void userDelete() {  // 서치 메서드에서 찾은 인덱스번호에 해당하는 리스트 찾아서 삭제 메서드 실행
        System.out.println("<학생정보삭제>");
        int index = searchIndex();
        if(index == -1){
            System.out.println("찾는 학생이 없습니다.");
        }else{
            String name = sList.get(index).getName();  // 인덱스번호에 해당하는 이름을 꺼내옴
            delete(index);
            // sList.remove(index)
            System.out.println(name + "학생정보를 삭제했습니다");
        }
    }

    private int searchIndex() {  // 서치 메서드 반환값은 인덱스 번호다
        int index = -1;
        System.out.println("학생이름을 입력해 주세요");
        System.out.print(">>");
        String name = sc.next();
        for(int i=0;i <sList.size(); i++){
            if(sList.get(i).getName().equals(name)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void userSelect() {  // 서치 메서드에서 찾은 인덱스 번호로 리스트 반환
        System.out.println("<학생정보보기>");
        int index = searchIndex();
        if(index == -1){
            System.out.println("찾는 학생이 없습니다.");
        }else{
            System.out.println("   이름\t 나이\t 국어\t 영어\t 수학 \n"+
                                "-------------------------------------");
            StudentDTO s = select(index);
            System.out.println(s);
    }
    }

    public void userUpdate() {
        System.out.println("<학생정보수정>");
        int index = searchIndex();
        if(index == -1){
            System.out.println("찾는 학생이 없습니다.");
        }else{
            StudentDTO s = new StudentDTO();  // 빈 객체를 하나 만들다.
            // id와 name과 age는 수정하지않고 kor과 eng와 math만 수정할 때
            // 변경할 객체에다가 sList에 있는 검색한 index의 Id를 가져와서 갖다 붙임
            s.setId(sList.get(index).getId());
            s.setName(sList.get(index).getName());
            s.setAge(sList.get(index).getAge());
            System.out.println(sList.get(index).getName()+"학생 점수 정보 수정");
            System.out.print("국어 점수 : ");
            s.setKor(sc.nextInt());
            System.out.print("영어 점수 : ");
            s.setEng(sc.nextInt());
            System.out.print("수학 점수 : ");
            s.setMath(sc.nextInt());

            // sList.set(index,s);
            Update(index,s);
        }
    }

    public void printAll() {
        System.out.println("   이름\t\t 나이\t 국어\t 영어 \t수학 \n" +  
        "-------------------------------------------------");
        for(int i=0; i < sList.size(); i++){
            System.out.println(sList.get(i).toString());
        }
    }

    public void dataSave() throws Exception {
        file.create();
        String str = "이름\t 나이\t 국어\t 영어\t 수학\n" + 
        "-------------------------------------------------\n";
        for(int i=0; i < sList.size(); i++){
            str += sList.get(i).toString()+"\n";
        }
        file.write(str);
    }

    public void dataLoad() {
        try {
            file.read();
        } catch (Exception e) {
            System.out.println("읽을파일이 없습니다.");
        }
    }

}
