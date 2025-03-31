package a0331;

import java.util.TreeMap;

public class TreeMap1 {
    public static void main(String[] args) {
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
        // put() 메소드를 이용한 요소의 저장
        tm.put(30,"삼십");
        tm.put(10,"십");
        tm.put(40,"사십");
        tm.put(20,"이십");

        System.out.println("맵에 저장된 키들의 집합 : " + tm.keySet());
        // 값이 정렬되어 출력됨

        for(Integer key:tm.keySet()){
            System.out.printf("키 : %s, 값 : %s\n",key,tm.get(key));
        }

        TreeMap<String, Integer> tm1 = new TreeMap<String, Integer>();

        tm1.put("ㄷㄷㄷ", 30);
        tm1.put("ㅅㅅㅅ", 10);
        tm1.put("ㄱㄱㄱ", 40);
        tm1.put("ㅎㅎㅎ", 20);

        System.out.println("맵에 저장된 키들의 집합 : " + tm1.keySet());

        for(String key:tm1.keySet()){
            System.out.printf("키 : %s, 값 : %s\n",key,tm1.get(key));
        }
    }
}
