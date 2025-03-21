package a0321.Liberary;

import java.util.Scanner;

public class LiberaryApplication {
    private static Liberary [] bookArray = new Liberary[100];
        
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        bookArray[0] = new Liberary("The Great Gatsby", "F. Scott Fitzgerald", "Available");
        bookArray[1] = new Liberary("1984", "George Orwell", "Available");
        bookArray[2] = new Liberary("To Kill a Mockingbird", "Harper Lee", "Available");
        bookArray[3] = new Liberary("Moby Dick", "Herman Melville", "Available");
        bookArray[4] = new Liberary("Pride and Prejudice", "Jane Austen", "Available");
        bookArray[5] = new Liberary("The Catcher in the Rye", "J.D. Salinger", "Available");
        bookArray[6] = new Liberary("The Hobbit", "J.R.R. Tolkien", "Available");
        bookArray[7] = new Liberary("Fahrenheit 451", "Ray Bradbury", "Available");
        bookArray[8] = new Liberary("Brave New World", "Aldous Huxley", "Available");
        bookArray[9] = new Liberary("The Odyssey", "Homer", "Available");

        boolean run = true;


        while (run) {
            System.out.println("------------------------------------------------");
            System.out.println("1. 책 추가 | 2. 책 목록 조회 | 3. 책 대출 | 4. 책 반납 | 5. 종료");
            System.out.println("------------------------------------------------");
            System.out.print("선택>");
            int selectNo = Integer.parseInt(scan.nextLine());
            if(selectNo == 1){
                addBook();
            }else if(selectNo == 2){
                listBooks(); 
            }else if(selectNo == 3){
                borrowBook(); 
            }else if(selectNo == 4){
                returnBook(); 
            }else if(selectNo == 5){
                run =false;
            }
        }
        System.out.println("프로그램 종료");
    }

    private static void addBook() {
        System.out.println("--------");
        System.out.println("책 추가");
        System.out.println("--------");
        System.out.print("책 제목: ");
        String newtitle = scan.nextLine();
        System.out.print("저자: ");
        String newauthor = scan.nextLine();
        String newstatus = ("Available");

        findBook(newtitle);
            if(newtitle != null){
                System.out.println("이미 책을 보유하고 있어서 추가할 수 없습니다.");
            }

        Liberary newBook = new Liberary(newtitle, newauthor, newstatus);
         for(int i = 0; i < bookArray.length; i++){
            
        // Liberary newBook = findBook(borrowtitle);
        //     if(borrowbook == null){
        //         System.out.println("결과 : 해당 책을 보유하고 있지않습니다.");
        //         return;
        //     }else if(borrowbook.getStatus().equals("Borrowed")){
        //         System.out.println("이 책은 이미 대출 중 입니다");
        //     }else{
        // borrowbook.setStatus("Borrowed");
        // System.out.println("책을 대출했습니다!");
        // }



            if(bookArray[i] == null){
                bookArray[i] = newBook;
                System.out.println("결과 : 책 추가 완료");
                break;
            }
         }
    }

    private static void listBooks() {
        System.out.println("-----------");
        System.out.println("책 목록 조회");
        System.out.println("-----------");
        for (int i = 0; i < bookArray.length; i++) {
            Liberary book = bookArray[i];
            if(book != null){
                System.out.print(book.getTitle());
                System.out.print("     ");
                System.out.print(book.getAuthor());
                System.out.print("     ");
                System.out.print(book.getStatus());
                System.out.print("     ");
                System.out.println();
            }
        }
    }

    
    private static Liberary findBook(String title){
        Liberary book = null;
        for(int i=0; i < bookArray.length; i++){
            if(bookArray[i] !=null && bookArray[i].getTitle().equals(title)){
                book = bookArray[i];
                break;
            }
        }
        return book;
    }

    // private static Liberary findBook2(String author){
    //     Liberary book = null;
    //     for(int i=0; i < bookArray.length; i++){
    //         if(bookArray[i] !=null && bookArray[i].getTitle().equals(author)){
    //             book = bookArray[i];
    //             break;
    //         }
    //     }
    //     return book;
    // }

    private static void borrowBook(){
        System.out.println("--------");
        System.out.println("책 대출");
        System.out.println("--------");
        System.out.print("대출할 책 제목: ");
        String borrowtitle = scan.nextLine();
        Liberary borrowbook = findBook(borrowtitle);
            if(borrowbook == null){
                System.out.println("결과 : 해당 책을 보유하고 있지않습니다.");
                return;
            }else if(borrowbook.getStatus().equals("Borrowed")){
                System.out.println("이 책은 이미 대출 중 입니다");
            }else{
        borrowbook.setStatus("Borrowed");
        System.out.println("책을 대출했습니다!");
        }
    }
    
    private static void returnBook() {
        System.out.println("--------");
        System.out.println("책 반납");
        System.out.println("--------");
        System.out.print("반납할 책 제목: ");
        String returntitle = scan.nextLine();
        Liberary returnbook = findBook(returntitle);
            if(returnbook == null){
                System.out.println("결과 : 여기 책이 아닙니다. 다른 곳에 반납하세요");
                return;
            }else if(returnbook.getStatus().equals("Available")){
                System.out.println("삐뽀삐뽀 책 도둑놈 감.옥.가.쟈!");
            }else{
                returnbook.setStatus("Available");
                System.out.println("책을 반납했습니다!");
            };


    }
}
