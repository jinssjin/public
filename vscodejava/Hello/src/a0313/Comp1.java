package a0313;

public class Comp1 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println( a == b); // false , a와 b는 같지 않음.
        System.out.println( a != b); // true , a와 b는 다르다.
        System.out.println( a > b); // false , a는 b보다 크지 않다.
        System.out.println( a < b); // true , a는 b보다 작다.
        System.out.println( a >= b); // false , a는 b보다 크지 거나 같지 않다.
        System.out.println( a <= b); // true , a는 b보다 작거나 같다.

        // 결과를 boolean변수에 담음
        boolean result = a == b;
        System.out.println(result);
    }
}
