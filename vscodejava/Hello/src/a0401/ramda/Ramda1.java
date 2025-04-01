package a0401.ramda;

import java.util.Arrays;
import java.util.List;

public class Ramda1 {
    public static void main(String[] args) {
        // List<String> name = new ArrayList<String>();
        // name.add("apple");
        // name.add("banana");
        // name.add("orange");

        // for(int i =0; i < name.size(); i++){
        //     System.out.println(name.get(i));
        // }

        List<String> names = Arrays.asList("apple","banana","orange");
        System.out.println();
        for(String name : names){
            System.out.println(name);
        }

        // 람다 foreach

        names.forEach(name -> System.out.println(name));
        System.out.println();

        // 스트림
        // 길이가 6이상(스펠링의 갯수) 요소만 필터링
        names.stream()  // 스트림을 생성(변경)
            .filter(name -> name.length() >= 6)  // 이름의 길이가 6 이상인 이름만 필터링
            .forEach(System.out::println);  // 필터링된 이름을 하나씩 출력
                
            }
    }

