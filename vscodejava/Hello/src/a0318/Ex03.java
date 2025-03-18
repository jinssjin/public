package a0318;

public class Ex03 {
    public static void main(String[] args) {
        int x = 5;
        System.out.println("x =" + x);  // 5 위에서 선언한 int x 값 출력 첫번째 x
        print(x);                       // 함수호출
        System.out.println("x =" + x);  // 5 위에서 선언한 int x 값 출력 네번째 x (함수의 영향 안받음)
    }
    public static void print(int x){
        System.out.println("x =" + x);  // 5 위에서 선언한 int x 값 출력 두번째 x
        x = x + 10;                     // 지역변수 변경
        System.out.println("x =" + x);  // 15 위에서 연산한 값 출력 세번째 x
    }
}
