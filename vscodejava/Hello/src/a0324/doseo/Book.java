package a0324.doseo;

public class Book {
    private String tiltle;
    private String author;
    private String ISBN;
    
    public Book(String tiltle, String author, String iSBN) {
        this.tiltle = tiltle;
        this.author = author;
        ISBN = iSBN;
    }

    public String getTiltle() {
        return tiltle;
    }
    public void setTiltle(String tiltle) {
        this.tiltle = tiltle;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }


    // 도서정보 출력 메서드
    public void displayInfo(){
        System.out.println("Title: "+ tiltle);
        System.out.println("Author: "+ author);
        System.out.println("ISBN: "+ ISBN);
    }
}
