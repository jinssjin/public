package a0403.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stream4 {
    public static void main(String[] args) {
         String[] arr = new String[]{"넷", "둘", "셋", "하나"};
        //배열에서서 스트림생성
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(e -> System.out.println(e+" "));
        System.out.println();

        Stream<String> stream2 = Arrays.stream(arr,1,3);  // 1번 인덱스부터 3번 인덱스 전까지 출력 (시작인덱스와 끝인덱스)
        stream2.forEach(e -> System.out.println(e+" "));
    }
}
