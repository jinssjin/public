package a0331.sort.hak1;

public class Compare1 {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        String str3 = "apple";
        System.out.println(str1.compareTo(str2));
            // 'a' 아스키코드(97) < b(98)  -> 음수(-1)
        System.out.println(str1.compareTo(str3));
            // 두 문자가 같으면 0
        System.out.println(str2.compareTo(str1));
            // 'b' 아스키코드(98) > a(97)  -> 양수(1)


            // 아스키코드가 크면 양수, 아스키코드가 작으면 음수 반환 (같으면 0)
    }
}
