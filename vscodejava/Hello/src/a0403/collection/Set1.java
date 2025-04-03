package a0403.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// collection
// 1. 데이터를 효율적으로 저장하기 위해
// 2. 배열보다 유연하게 크기 변경이 가능
// 3. 자료구조 : List, Map, Set
// 4. ArrayList<String> : 제네릭 지원으로 타입 안정성 제공 (제네릭이 없다면 지속적으로 형변환, 타입변환 필요)
// 5. 다양한 구현체 제공 : 성능과 특징에 맞게 선택가능

// List : 순서대로 저장, 중복허용
// ArrayList : 배열기반, 검색이 빠르다. 삽입, 삭제 느림
// LinkedList : 연결리스트 기반, 검색이 느리다. 삽입, 삭제는 빠르다
// Vector : ArrayList와 유사 스레드 안전
// Stack : LIFO(Last-In-First-Out) 구조 push()-삽입, pop()-삭제

// Set : 순서가 보장이 안됨, 중복 허용 안함

// HashSet : 해시기반, 요소 순서 보장하지 않음, 중복 불가
// LinkedHashSet : 입력 순서 유지되고 중복 불가
// TreeSet : 정렬된 상태유지(오름차순)

// Queue : FIFO(First-In-First-Out)
// Map : (Key-Value, 키는 중복될 수 없다.)
// HashMap : 키 순서 보장하지않는다. 빠른 검색속도
// LinkedHashMap : 입력순서 유지
// TreeMap : 정렬된 상태 유지 (키 기준)

public class Set1 {
 public static void main(String[] args) {
    // 객체 선언
    Set<String> set = new HashSet<String>();
    
    // 데이터 삽입
    set.add("apple");
    set.add("banana");
    set.add("pyopyo");
    set.add("kiwi");
    System.out.println();
    for(String e: set){
        System.out.println(e);
    }

    //데이터 삭제
    set.remove("apple");
    set.add("orange");
    set.add("orange"); // 중복된 요소의 저장이 안됨

    Iterator<String> iterSet= set.iterator();  // Iterator는 while문이랑 쓴다
    while (iterSet.hasNext()) {
        System.out.println(iterSet.next()+" ");
    }
    System.out.println();
    System.out.println(set);

    System.out.println(set.contains("orange"));

    // 전체 데이터 삭제
    set.clear();
    System.out.println(set);
    System.out.println(set.isEmpty());  // set이 비어있는지 물어봄
 }   
}
