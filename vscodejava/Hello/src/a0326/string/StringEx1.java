package a0326.string;

public class StringEx1 {
    public static void main(String[] args) {
        String str = new String("Java");
        System.out.println("원본문자열 : "+str);
        String str1 = "Java";
        System.out.println("원본문자열 : "+str1);

        for(int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i)+" ");  // charAt() : 한 문자만 출력
        }

        for(int i = 0; i < str.length(); i++){
            System.out.print(str1.charAt(i)+" ");  // charAt() : 한 문자만 출력
        }
    }
}
