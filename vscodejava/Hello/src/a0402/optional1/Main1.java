package a0402.optional1;

import java.util.Optional;

public class Main1 {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // 존재하는 ID로 검색
        Optional<User> userOptional1 = userRepository.findById(2L);
        userOptional1.ifPresentOrElse(
            user -> System.out.println("찾는 사용자 : "+user),
            () -> System.out.println("찾는 사용자가 없습니다."));
            // 출력 : User{id=2, name='Bob'}

        Optional<User> userOptional2 = userRepository.findById(99L);
        userOptional2.ifPresentOrElse(
            user -> System.out.println("찾는 사용자 : "+user),
            () -> System.out.println("찾는 사용자가 없습니다."));
            // 출력 : 찾는 사용자가 없습니다.

        Optional<User> userOptional3 = userRepository.findById(50L);
        userOptional3.ifPresentOrElse(
            user -> System.out.println("찾는 사용자 : "+user),
            () -> System.out.println("찾는 사용자가 없습니다."));
            // 출력 : 찾는 사용자가 없습니다.

        // 기본값 제공
        User defaultUser = userOptional3.orElse(new User(0L,"기본 유저"));
        System.out.println("기본 사용자 : "+defaultUser);
    }

    // findById 메서드
    // 아이디로 사용자 리스트를 검색하고, 결과를 optional<User>로 반환
    // Optional.empty()는 사용자가 없을때 반환
    // Optional 처리방식
    // ifPresentOrElse : 값이 있으면 처리, 없으면 대체 동작 수행
    // orElse : 값이 없으면 기본값을 반환
    // orElseThrow : 값이 없으면 예외를 던질 수도 있음
}
