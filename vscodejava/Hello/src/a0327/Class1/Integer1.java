package a0327.Class1;

public class Integer1 {
    public static void main(String[] args) {
        int a = 10;  // 기본형
        // Wrapper 클래스
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(20);
        Integer num3 = new Integer(10);

        System.out.println(num1 < num2);
        System.out.println(num1 == num3);  // false (주소를 비교하기 때문)
        System.out.println(num1.equals(num3));  // true (값을 비교하기 때문)
    }
}
