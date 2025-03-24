package a0324.doseo1;

public class Library {
    private String title;  // 책 제목
    private String author;  // 책 저자
    private String location;  // 책 위치
    private String isbn;
    private boolean available;

    public Library(){ // 기본 생성자

    }
    
    public Library(String title, String author, String location, String isbn) {
        this.title = title;
        this.author = author;
        this.location = location;
        this.isbn = isbn;
        this.available = true;  // 자동으로 true값을 가짐
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public boolean isAvailable() {  // boolean 타입
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "책 제목 :" + title + ", 저자 : " + author + ", 책 위치 : " + location + ", ISBN :" + isbn
                + ", 대출여부 :" + (available ? " 대출가능" : " 대출불가능");
    }
    
    // 도서대출 후 대출불가능 메서드
    public void book(){
        this.available = false;
    }
}
