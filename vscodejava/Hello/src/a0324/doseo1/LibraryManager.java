package a0324.doseo1;

import java.util.ArrayList;

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
}
