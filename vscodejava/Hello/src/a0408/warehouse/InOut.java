package a0408.warehouse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import a1206.movie.Reservation;

public class InOut {
    private LocalDateTime inOutCode;         // 입출고 코드
    private String sort;           // 입출고구분
    private int amount;            // 수량
    private String goodsCode;         // 상품 코드
    private String name;              // 상품 이름
    private LocalDate espirationDate; // 유통기한
    private String inTime;            // 입고시각
    private String outTime;           // 출고시각
    private String position;          // 위치
    private int price;                // 가격
    
    // 생성자 추가
    public InOut(LocalDateTime inOutCode, String sort, String goodsCode, String name, int price, int amount) {
    this.inOutCode = inOutCode;
    this.sort = sort;
    this.goodsCode = goodsCode;
    this.name = name;
    this.price = price;
    this.amount = amount;
    }


    private static File inOutFile = new File("D:\\jinss\\inoutlist.txt");
    public static ArrayList<InOut> findById(String inOutgoodsCode) throws IOException {
        ArrayList<InOut> inOutlist = new ArrayList<InOut>();
        BufferedReader br = new BufferedReader( new FileReader(inOutFile));
        String line = null;  // null값을 먼저 초기화해서 br.readLine();이 없을경우 출력값을 대비
        while ((line = br.readLine()) != null) {  // 라인 하나씩 읽어오기
            String[] temp = line.split("/");  // "/"로 정보를 구분해서 txt파일을 배열에 넣기
            if(inOutgoodsCode.equals(temp[2])){
                DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMddHHmmss");
                LocalDateTime inOutCode = LocalDateTime.parse(temp[0], format1); // 로컬데이트타임타입으로 변경
                String sort = temp[1];
                String goodsCode = temp[2];  // txt파일에 있는 정보는 애초에 String타입
                String name = temp[3];  // txt파일에 있는 정보는 애초에 String타입
                int goodsPrice = Integer.parseInt(temp[4]); // txt파일 정보를 인티제로 변경
                int amount = Integer.parseInt(temp[5]); // txt파일 정보를 인티제로 변경
                InOut l = new InOut(inOutCode,sort,goodsCode,name,goodsPrice,amount);
                inOutlist.add(l);
            }
            br.close();
            return inOutlist;
        }
    }
    
    
}
