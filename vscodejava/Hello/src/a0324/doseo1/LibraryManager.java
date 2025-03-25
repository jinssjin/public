package a0324.doseo1;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    private ArrayList<Library> librarys;  // Library를 객체를 리스트 (묶음으로 저장할 수 있는 배열종류)
    private ArrayList<Library> booklocation;  // Library를 객체 중 대여한 객체를 저장하는 리스트

    public LibraryManager(){
        librarys = new ArrayList<>();  // 전체 책 목록을 담을 리스트
        booklocation = new ArrayList<>();  // 대출한 목록 리스트
        librarys.add(new Library("This is JAVA","Shin","SectionA","979-11-691-229-8"));
        librarys.add(new Library("First Encounter with React", "Lee Inje", "SectionB", "979-11-6921-169-7"));
        librarys.add(new Library("The Principles of Web Standards", "Ko Kyunghee", "SectionC", "979-11-6303-622-7"));

        // 더미데이터
    }

    public void allLibrary() {
        System.out.println("대출 가능한 도서보기");
        // for(Library library :librarys){
        //     if(library.isAvailable()){
        //         System.out.println(library);
        //     }
        // }
        for(int i=0; i < librarys.size();i++){
            Library library = librarys.get(i);
            if(library.isAvailable()){
                 System.out.println(library);
        }
    }
}

    public boolean booklocations(String name){
        for(Library library :librarys){
            if(library.getTitle().equalsIgnoreCase(name) // 모든 문자를 소문자로 바꿔서 비교해라
                && library.isAvailable()){ 
                    library.book();  // 대출이 실행되므로 available에 = false로 넣어주는 메서드
                    booklocation.add(library);
                return true;
            }
        }
        return false;  // boolean false : 도서가 대출 가능하지않거나 존재하지 않아요
    }

    public void booklocation() {
        System.out.println("대출한 도서 :");
        for(Library location : booklocation){
            System.out.println(location);  // location은 Library의 변수라서 .toString() 이 생략되있음, 전체가 다 출력됨
        }
    }

    public void addLibrary(String newTitle, String newAuthor, String newLocation, String newIsbn) {
        Library abc = new Library(newTitle,newAuthor,newLocation,newIsbn);
        librarys.add(abc);
        // librarys.add(new Library(newTitle,newAuthor,newLocation,newIsbn));
    }

    public void delLibrary(String dname) {
        boolean result = false;
        for(Library library:librarys){
            if(library.getTitle().equalsIgnoreCase(dname)){
                if(library.isAvailable()){ // 대여중이 아닐때(대여가능할때)
                    librarys.remove(library);
                    result = true;
                    break;
                }else{
                    result = false;
                    break;
                }
            }
        }
        if(result){
            System.out.println("삭제됨");
        }else{
            System.out.println("삭제 안됨");
        }
    }

    public void updateLibrary(String uname) {
        int i = 0;
        int index = -1;
        int menu = -1;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        Library newA = new Library();  // 빈 라이브러리 객체를 하나 만든다.
        System.out.println(uname);
        for(Library a:librarys){  // librarys 리스트를 순회하며 같은 이름 있는지 찾자
            i++;
            if(a.getTitle().equals(uname)){
                index = i-1;  // index = 0,1,2;  // 실제 찾은 인덱스 번호
                newA = a; // 이름이 같으면서 생성된 개체 newA에 넣는다.
            }
            System.out.println(a.getTitle().equals(uname)+" "+a.getTitle()+" "+uname);
        }
        if(index != -1){  // index가 -1이 아니면 : 수정하려는 도서 이름을 찾은 것
            System.out.print("뭘 수정할건데?\n 1.도서 이름 \t 2.도서 저자 \t 3.도서 위치 \t 4.도서ISBN \n >>");
            menu = scan.nextInt();
            scan.nextLine();  // \n같이 불필요한 내용을 지운다
            while (flag) {
                switch (menu) {
                    case 1:
                    System.out.println("수정할 이름");
                    newA.setTitle(scan.nextLine());  // 키보드로 입력한 도서이름으로 newA객체 변경
                    librarys.set(index, newA); // 해당인덱스 번호에 수정한 객체를 넣어버림
                    flag = false;
                        break;
                        case 2:
                    System.out.println("수정할 저자");
                    newA.setAuthor(scan.nextLine());  // 키보드로 입력한 도서이름으로 newA객체 변경
                    librarys.set(index, newA); // 해당인덱스 번호에 수정한 객체를 넣어버림
                    flag = false;
                        break;
                        case 3:
                    System.out.println("수정할 위치");
                    newA.setLocation(scan.nextLine());  // 키보드로 입력한 도서이름으로 newA객체 변경
                    librarys.set(index, newA); // 해당인덱스 번호에 수정한 객체를 넣어버림
                    flag = false;
                        break;
                        case 4:
                    System.out.println("수정할 ISBN");
                    newA.setIsbn(scan.nextLine());  // 키보드로 입력한 도서이름으로 newA객체 변경
                    librarys.set(index, newA); // 해당인덱스 번호에 수정한 객체를 넣어버림
                    flag = false;
                        break;
                
                    default:
                    System.out.println("1~4번 중에 입력하세요");
                        break;
                }
                

            }
        }else{
            System.out.println("찾는 도서가 없어서 업데이트할 수 없습니다.");
        }
    }

    public void showLibrary(String sname) {
        for(Library a:librarys){
            if(a.getTitle().equalsIgnoreCase(sname)){
                System.out.println(a);
            }
        }
    }
}
