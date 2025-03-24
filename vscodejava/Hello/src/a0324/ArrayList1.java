package a0324;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import a0317.While;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        //컬렉션 //<제네릭>

        // add 메소드를 이용한 요소의 저장
        arrList.add(40);
        arrList.add(20);
        arrList.add(30);
        arrList.add(10);

        // for문, get() 메소드를 이용한 요소의 출력
        // size 쓴다
        for(int i = 0; i < arrList.size(); i++){
            System.out.print(arrList.get(i)+" ");
        }

        System.out.println();
        // Enhance for 향상된 for 문
        for(int e : arrList){
            System.out.print(e+" ");
        }

        System.out.println();

        // Collections.sort() 메소드를 이용한 요소의 정렬
        Collections.sort(arrList);
        for(int e : arrList){
            System.out.print(e+" ");
        }

        System.out.println();

        // iterator(); 메소드와 get() 메소드를 이용한 요소의 출력
        Iterator<Integer> iter = arrList.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next()+" ");
        }

        System.out.println();

        // set() 메소드를 이용한 요소의 변경  // 10에서 20으로 변경
        arrList.set(0,20);
        for(int e : arrList){
            System.out.print(e+" ");
        }
        
        arrList.remove(1);

        System.out.println();
        for(int e : arrList){
            System.out.print(e+" ");
        }

        // 특정 인덱스 위체에 요소 삽입
        arrList.add(0, 10);

        System.out.println();
        for(int e : arrList){
            System.out.print(e+" ");
        }

        System.out.println();
    
        // size() 메소드를 이용한 요소의 총 개수
        System.out.println("리스트의 크기 : " + arrList.size());
    }
}
