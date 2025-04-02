package a0402.optional;

import java.util.Optional;

// 값이 존재하면 처리하고, 없으면 기본값 제공하기

public class OPtional2 {
    public static void main(String[] args) {
        // null을 허용하고 name = alice
        Optional<String> name = Optional.ofNullable("alice");

        // 값이 있으면 값을 출력하고, 없으면 기본값을 출력
        String result = name.orElse("Guest");
        System.out.println("Hello "+result);

        // 값이 'null'로 설정하여 기본값을 확인
        Optional<String> name1 = Optional.ofNullable(null);
        String result1 = name1.orElse("Guest");
        System.out.println("Hello "+result1);
    }
}
