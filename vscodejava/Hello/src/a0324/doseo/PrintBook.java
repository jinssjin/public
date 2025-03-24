package a0324.doseo;

public class PrintBook extends Book{
    private int pageCount;  // 페이지의 수
    private double weight;  // 책의 무게
    
    public PrintBook(String tiltle, String author, String iSBN, int pageCount, double weight) {
        super(tiltle, author, iSBN);
        this.pageCount = pageCount;
        this.weight = weight;
    }
    
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("PageCount:"+pageCount);
        System.out.println("Weight: "+weight+"kg");
    }
}
