package a0402.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Optional6 {

    // 새로운 객체할당 불가능 하게 할때 final
    private static final Map<Integer,String> userDatabase = new HashMap<>();

    // static블럭 : 클래스가 최초로 로드될때 한 번만 실행됨
    // 정적변수(static변수) 초기화 사용, 객체 생성하지 않아도 실행됨
    static{
        userDatabase.put(1,"Alice");
        userDatabase.put(2,"Bob");
        userDatabase.put(3,"Charlie");

    }
    public static void main(String[] args) {
        // userDatabase = new HashMap<>(); : 사용 불가능, final

        // 존재하는 id조회
        Optional<String> user1 = findById(2);
        System.out.println("User width Id 2 : "+user1.orElse("User not found"));

        Optional<String> user2 = findById(5);
        System.out.println("User width Id 5 : "+user2.orElse("User not found"));

        System.out.println("User width Id 3(orElse) : "+findById(3).orElse(getDefaultUser()));
        System.out.println("User width Id 3(orElseGet) : "+findById(3).orElseGet(() -> getDefaultUser()));
        // orElse(getDefaultUser()) : 항상 getDefaultUser() 호출
        // orElseGet(() -> getDefaultUser())) 는 비어있을때(null)만 호출 / 비어있을땐 값만 호출

    }
    private static String getDefaultUser() {
        System.out.println("getDefaultUser() 호출됨");
        return "Default User";
    }

    private static Optional<String> findById(int id) {
        return Optional.ofNullable(userDatabase.get(id));
    }
}
