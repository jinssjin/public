package a0408.warehouse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InOut {
    private String sort;           // 입출고구분
    private String inOutCode;         // 입출고 코드
    private int amount;            // 수량
    private String goodsCode;         // 상품 코드
    private String name;              // 상품 이름
    private LocalDate expirationDate; // 유통기한
    private String position;          // 위치
    private int price;                // 가격
    
    // 생성자 추가
    public InOut(String sort, String inOutCode, String goodsCode, String name, int price, int amount) {
    this.inOutCode = inOutCode;
    this.sort = sort;
    this.goodsCode = goodsCode;
    this.name = name;
    this.price = price;
    this.amount = amount;
    }

    public InOut(String sort, String inOutCode, String goodsCode, String name, int amount) {
        this.inOutCode = inOutCode;
        this.sort = sort;
        this.goodsCode = goodsCode;
        this.name = name;
        this.amount = amount;
        }


    private static File inOutFile = new File("D:\\jinss\\0408\\inoutlist.txt");
    public static ArrayList<InOut> findByCode(String inOutgoodsCode) throws IOException {
        ArrayList<InOut> inOutlist = new ArrayList<InOut>();
        BufferedReader br = new BufferedReader( new FileReader(inOutFile));
        String line = null;  // null값을 먼저 초기화해서 br.readLine();이 없을경우 출력값을 대비
        while ((line = br.readLine()) != null) {  // 라인 하나씩 읽어오기
            String[] temp = line.split(",");  // "/"로 정보를 구분해서 txt파일을 배열에 넣기
            if(inOutgoodsCode.equals(temp[2])){
                // DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMddHHmmss");
                // LocalDateTime inOutCode = LocalDateTime.now();
                // String formattedDate = inOutCode.format(format1);
                String sort = temp[0];
                String date = temp[1];
                String goodsCode = temp[2];  // txt파일에 있는 정보는 애초에 String타입
                String name = temp[3];  // txt파일에 있는 정보는 애초에 String타입
                int goodsPrice = Integer.parseInt(temp[4]); // txt파일 정보를 인티제로 변경
                int amount = Integer.parseInt(temp[5]); // txt파일 정보를 인티제로 변경
                InOut l = new InOut(sort,date,goodsCode,name,goodsPrice,amount);
                inOutlist.add(l);
            }
        }
        br.close();
        return inOutlist; // 입출고 객체를 담은 배열 리스트 반환
    }

    public void save() {
        try{
            FileWriter fw = new FileWriter(inOutFile,true);
            fw.write(this.toFileString()+"\n");
            fw.close();
        } catch (IOException e){
            System.out.println("파일 읽기 실패");
        }   
    }

    private String toFileString() {
        return String.format("%s,%s,%s,%s,%d,%d",sort, inOutCode, goodsCode,name,price,amount);
    }

    public static InOut outProducts(String inOutCode) throws IOException {
        InOut outGoods  = null;
        BufferedReader br = new BufferedReader(new FileReader(inOutFile));
        String text = "";
        String line = null;
        while ((line = br.readLine())!=null) {
            String [] temp = line.split(",");
            if(inOutCode.equals(temp[2])){
                    DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyMMddHHmmss");
                    LocalDateTime currentTime = LocalDateTime.now();
                    String formattedDate = currentTime.format(format2);
                    String sort = temp[0];
                    String goodsCode = temp[2];  // txt파일에 있는 정보는 애초에 String타입
                    String name = temp[3];  // txt파일에 있는 정보는 애초에 String타입
                    int goodsPrice = Integer.parseInt(temp[4]); // txt파일 정보를 인티제로 변경
                    int amount = Integer.parseInt(temp[5]); // txt파일 정보를 인티제로 변경
                    outGoods = new InOut(sort,formattedDate,goodsCode,name,goodsPrice,amount);
                    continue; 
            }
            text += line + "\n";
        }
        br.close();
        FileWriter fw = new FileWriter(inOutFile); // FileWriter 객체 생성(덮어쓰기 모드)
        fw.write(text+"\n");
        fw.close();
        return outGoods;

    }
    
    public String toString() {
        return String.format("%s %s, %s(%s): %d개\n",sort,inOutCode,name,goodsCode,amount);
    }
    
}
