package a0328.book;

public class BookDTO {
    private String name;
    private String author;
    private String isbn;
    private double price;

    
    public BookDTO(String name, String author, String isbn, double price) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[제목: " + name + ", 저자: " + author + ", ISBN: " + isbn + ", 가격: " + price + "]";
    }

}


        