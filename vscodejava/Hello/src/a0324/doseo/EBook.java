package a0324.doseo;

public class EBook extends Book {
    private double fileSize;  // 파일크기 (mb단위)
    private String format;  // 파일포멧(ex : pdf , epub)

    public EBook(String tiltle, String author, String iSBN, double fileSize, String format) {  // 생성자 생성
        super(tiltle, author, iSBN);
        this.fileSize = fileSize;
        this.format = format;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("FileSize: "+ fileSize + "MB");
        System.out.println("Format: "+ format);
    }

}
