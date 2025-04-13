package a0408.warehouse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Product {
    private String goodsCode;         // 상품 코드
    private String name;              // 상품 이름
    private int price;                // 가격
    private int amount;            // 수량
    private boolean taxFree;          // 면세 여부
    
    public Product(String goodsCode, String name, int price, boolean taxFree) {
        this.goodsCode = goodsCode;
        this.name = name;
        this.price = price;
        this.taxFree = taxFree;
    }
    public String getGoodsCode() {
        return goodsCode;
    }
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public boolean isTaxFree() {
        return taxFree;
    }
    public void setTaxFree(boolean taxFree) {
        this.taxFree = taxFree;
    }

// 파일 저장 경로 위치
    private static File productFile = new File("d:\\jinss\\0408\\productList.txt");

// 새로운 상품 리스트 등록 메서드 (추가 쓰기)
    public void saveList() throws IOException {
        FileWriter fw = new FileWriter(productFile,true);  // 이어쓰기 on, 추기해야되니까
        fw.write(this.toFileString()+"\n\n"); // toFileString()메서드 네가지 정보 쓰고 한줄 띄고 열기
        fw.close(); // 파일라이터 닫기
    }

// 파일 저장 형식 
    private String toFileString() {
        return String.format("%s,%s,%d,%b"+"\n", goodsCode,name,price,taxFree);
    }
    
// 시스템 상에 출력되는 양식
    @Override
    public String toString() {
        return String.format("(%s) %s [%d]  // %b \n",goodsCode,name,price,taxFree);
    }

// 상품 리스트 조회 메서드 (읽어오기)
    public static ArrayList<Product> listup() throws IOException{  // 파일경로 오류 예외 던지기
        ArrayList<Product> productList = new ArrayList<Product>(); // 상품 정보를 담을 productList객체 생성
        BufferedReader br = new BufferedReader(new FileReader(productFile));
        String line = null;
        while ((line = br.readLine()) != null) {  // 라인 하나씩 읽어오기
            String[] temp = line.split(",");  // "/"로 정보를 구분해서 txt파일을 배열에 넣기
            Product p = new Product(
                temp[0],  // 0번 인덱스는 상품코드
                temp[1],  // 1번 인덱스 상품명 
                Integer.parseInt(temp[2]),  // 2번 인덱스는 가격
                Boolean.parseBoolean(temp[3])  //  3번 인덱스는 과세여부 (과세true, 면세false)
            );
            productList.add(p);  // txt파일 정보를 상품 리스트에 저장
        }
        br.close();  // 버퍼드리더 종료
        return productList;  // 상품리스트 반환
    }

// 상품리스트 찾아내서 객체 반환 메서드 (읽어와서 찾기)
    public static Product findByGoosCode(String goodsCode) throws IOException{
        Product p1 = null;
        BufferedReader br1 = new BufferedReader(new FileReader(productFile));
        String line = null;
        while ((line = br1.readLine()) != null) {  // 라인 하나씩 읽어오기
            String[] temp = line.split(",");  // "/"로 정보를 구분해서 txt파일을 배열에 넣기
            if(goodsCode.equals(temp[0])){
                p1 = new Product(
                    temp[0],  // 0번 인덱스는 상품코드
                    temp[1],  // 1번 인덱스 상품명 
                    Integer.parseInt(temp[2]),  // 2번 인덱스는 가격
                    Boolean.parseBoolean(temp[3])  //  3번 인덱스는 과세여부 (과세true, 면세false)
                );
                break;
            }
        }
        br1.close();
        return p1;
    }

// 상품리스트 삭제하기 (읽어와서 찾아낸 후 찾은 목록 하나 건너뛰고 전체 누적해서 목록리스트만 덮어 쓰기)
    public static void deleteGoodsList(String goodsCode) throws IOException {
        BufferedReader br2 = new BufferedReader(new FileReader(productFile));
        FileWriter fw1 = new FileWriter(productFile);
        String text = "";
        String line = null;
        while ((line = br2.readLine()) != null) {  // 라인 하나씩 읽어오기
            String[] temp = line.split(",");  // "/"로 정보를 구분해서 txt파일을 배열에 넣기
            if(goodsCode.equals(temp[0])){ // 인덱스0번방 입력받은 상품코드와 일치하면
                continue;  // BufferedReader하지않고 건너뜀
            }
            text += line+"\n";  // text에 객체들을 넣기
        }
        br2.close();  // 버퍼드리더 종료
        fw1.write(text);  // 위에서 삭제된거 빼고 누적된 객체를 모은 text를 txt파일에 덮어쓰기(true없어서 누적 안됨)
        fw1.close();  // 버퍼드라이터 종료
    }
}
