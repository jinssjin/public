package a0328.book;

import java.util.Scanner;

public class MainClass_Book {
    public static void main(String[] args) {
        BookDAO books = new BookDAO();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("===== 📚 도서 관리 시스템 =====");
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 삭제");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 수정");
            System.out.println("5. 도서 목록 보기");
            System.out.println("6. 파일로 저장");
            System.out.println("7. 파일에서 불러오기");
            System.out.println("0. 종료");
            System.out.print(">>");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    books.addBook();
                    break;
                case 2:
                    books.deleteBook();
                    break;
                case 3:
                    books.searchBook();
                    break;
                case 4:
                    books.updateBook();
                    break;
                case 5:
                    books.listBook();
                    break;
                case 6:
                    try {
                        books.saveBook();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                    break;
                case 7:
                    books.loadBook();
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    break;
            
                default:
                    break;
            }
        }
    }
}
