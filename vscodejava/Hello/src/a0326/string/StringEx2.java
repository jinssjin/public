package a0326.string;

public class StringEx2 {
    public static void main(String[] args) {
        String str = new String("abcd");
        System.out.println("원본문자열: "+str);

        System.out.println(str.compareTo("bcdf"));  // compareTo 같은건지 물어볼때, 출력값 : -1 (다름)
        System.out.println(str.compareTo("abcd"));  // compareTo 같은건지 물어볼때, 출력값 : 0 (같음)

        System.out.println(str.compareTo("Abcd"));  // compareTo 같은건지 물어볼때, 출력값 : 32 (대문자)
        // "a"의 유니코드 값은 97이고,
        // "A"의 유니코드 값은 65입니다.
        // 97-65 = 32
        System.out.println(str.compareToIgnoreCase("Abcd"));  // compareTo 같은건지 물어볼때, 출력값 : 0 

        System.out.println("compareTo() 메소드 호출 후 원본 문자열 : "+str);
        
    }
}
