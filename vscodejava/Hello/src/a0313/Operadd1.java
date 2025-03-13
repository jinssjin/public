package a0313;

public class Operadd1 {
    public static void main(String[] args) {
        int a = 0;
        a = a + 1;
        System.out.println("a= "+ a);
        a = a + 1;
        System.out.println("a= "+ a);

        // 증감 연산자
        ++a; // a = a + 1
        System.out.println("a = "+ a); // 3 출력
        ++a; // a = a + 1
        System.out.println("a = "+ a); // 4 출력
    }
}
