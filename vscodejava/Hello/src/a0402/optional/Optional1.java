package a0402.optional;

import java.util.Optional;

// Optional : null값으로 인한 문제 방지, 안전하게 값을 처리
// Optional은 null이 될 수 있는 객체를 감싸는 레퍼클래스

public class Optional1 {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("John");
        System.out.println("Name : "+name.get());
        
        // Optional.empty(); : 빈 Optional 생성
        Optional<String> emptyName = Optional.empty();
        System.out.println("Is empty : "+emptyName.isPresent());

        // Optional.ofNullable() = null을 허용하는 Optional 생성
        Optional<String> nullableName = Optional.ofNullable(null);
        System.out.println("Is empty : "+nullableName.isPresent());
    }
}
