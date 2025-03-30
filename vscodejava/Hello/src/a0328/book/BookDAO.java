package a0328.book;

import java.util.ArrayList;
import java.util.Scanner;

import a0328.file2.FileClass;

public class BookDAO {
    private ArrayList<BookDTO> books;
    Scanner scan = new Scanner(System.in);
    FileClass file = new FileClass("book","booklist");

    public BookDAO(){
        books = new ArrayList<BookDTO>();

        books.add(new BookDTO("자바의 정석", "남궁성", "12345", 32000));
        books.add(new BookDTO("Effective Java", "Joshua Bloch", "54321", 45000));
        books.add(new BookDTO("Clean Code", "Robert C. Martin", "67890", 38000));
        books.add(new BookDTO("스프링 부트와 AWS", "이동욱", "98765", 28000));
        books.add(new BookDTO("코틀린 인 액션", "Dmitry Jemerov", "13579", 40000));
        
    }

    public void addBook() {
        BookDTO b = new BookDTO(null, null, null, 0);
        System.out.print("책 제목: ");
        String addName = scan.nextLine();
        b.setName(addName);
        System.out.print("저자: ");
        String addAuthor = scan.nextLine();
        b.setAuthor(addAuthor);
        System.out.print("책 제목: ");
        String addISBN = scan.nextLine();
        b.setIsbn(addISBN);
        System.out.print("가격: ");
        double addPrice = scan.nextDouble();
        b.setPrice(addPrice);

        addtoBook(b);
        System.out.println("📖 도서 추가 완료!");

    }

    private void addtoBook(BookDTO b) {
        books.add(b);
    }

    public int findISBN(){
        int index = 0;
        System.out.println("찾으실 도서의 ISBN을 입력하시오");
        System.out.print(">>");
        String findbookN = scan.nextLine();
        for(int i=0; i < books.size(); i++){
            if(books.get(i).getIsbn().equals(findbookN)){
                index = i;
                break;
            }
            
            if(index<0){
                System.out.println("찾으시는 도서가 없습니다.");
            }
        }
        return index;
    }

    public void deleteBook() {
        int index = findISBN();
        if(index < 0){
            System.out.println("책을 찾을 수 없습니다. 다시 입력해주세요");
        }else{
            String delname = books.get(index).getName();
            deleteToBook(index);
            System.out.println(delname+"을(를) 삭제하였습니다.");
        }
        
        
    }

    private void deleteToBook(int index) {
        books.remove(index);
    }

    public void searchBook() {
        int index = findISBN();
        BookDTO b = selectToBook(index);
        if(index < 0){
            System.out.println("책을 찾을 수 없습니다. 다시 입력해주세요");
        }else{
            System.out.println(b);
        }
    }

    private BookDTO selectToBook(int index) {
        return books.get(index);
    }

    public void updateBook() {
        int index = findISBN();
        System.out.println("새로운 가격 입력");
        System.out.print(">>");
        double newPrice = scan.nextDouble();
        books.get(index).setPrice(newPrice);
    }

    public void listBook() {
        for(int i=0; i < books.size(); i++){
            System.out.println(books.get(i).toString());
        }
    }

    public void saveBook() throws Exception{
        file.create();
        String str = "";
        
        for(int i = 0; i < books.size(); i++){
            str += books.get(i)+"\n";
        }
        file.write(str);
    }

    public void loadBook() {
        try {
            file.read();
        } catch (Exception e) {
            System.out.println("파일 이름을 확인하여주세요");
        }
    }
}
