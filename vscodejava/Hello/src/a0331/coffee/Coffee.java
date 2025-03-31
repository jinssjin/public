package a0331.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Coffee {
    private static Coffee instance;  // 싱글톤 : 객체를 하나만 생성
    private Coffee(){};
    public static Coffee getInstance(){
        if(instance==null){
            instance = new Coffee();
        }
        return instance;
    }

    ArrayList<String> coffeeList;  // 커피의 종류 예) [아메리카노, 카푸치노]
    ArrayList<Integer> coffeePrice;  // 커피의 가격 [2000,4500]
    Map<String,Integer> menu;  // [커피종류,커피가격] {아메키라노, 2000}

    public void getMenu(){
        menu = new LinkedHashMap<String,Integer>();
        coffeeList = new ArrayList<>();
        coffeePrice = new ArrayList<>();

        coffeeList.add("아메리카노");
        coffeeList.add("카푸치노");
        coffeeList.add("아이스 아메리카노");
        coffeeList.add("카라멜 마끼아또");
        coffeeList.add("카페라떼");
        coffeeList.add("카페모카");

        coffeePrice.add(2000);
        coffeePrice.add(4500);
        coffeePrice.add(2500);
        coffeePrice.add(4000);
        coffeePrice.add(3000);
        coffeePrice.add(3500);

        for(int i=0; i < coffeeList.size(); i++){
            menu.put(coffeeList.get(i), coffeePrice.get(i));
        }
        // 아래 포맷에 맞추어 출력
        DecimalFormat f = new DecimalFormat("0,000원");
        StringBuffer st = new StringBuffer();  // 문자를 누적해서 쓸 때 사용한다

        st.append("\n\n")
        .append("+---------------------------------------------------+\n")
        .append("+------------------------메뉴판----------------------+\n")
        .append("|            Menu                   price           |\n");
        System.out.println(st.toString());

        int s = 1;
        for(Entry<String,Integer> get : menu.entrySet()){
            System.out.printf("| [%d] %-20s\t %s          | \n",s,get.getKey(), f.format(get.getValue()));
            s++;
            // f.format() : DecimalFormat  0000 -> 0,000원
            System.out.println("+---------------------------------------------------+");
        }
    }
}
