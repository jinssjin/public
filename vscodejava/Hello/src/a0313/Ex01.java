package a0313;

public class Ex01 {
    public static void main(String[] args) {
        // 세자리 정수의 각 자릿수 총합을 출력하려 한다.
        // num = 374
        // 정수 374의 각 자릿수의 총합 : 14

        // 힌트1 3+7+4 =14
        // 힌트2 %:나머지, /:나누기를 적절히 이용
        // 힌트3 100으로 나누고 10으로 나누고 나머지 이용

        int a = 374;
        int a100 = a / 100;
        int a10 = a % 100 / 10;
        int a1 = a % 10;
        System.out.println(a100+a10+a1);

        int sum = a100+a10+a1;
        // 출력
        System.out.printf("정수 %d의 각 자릿수의 총합: %d",a,sum);
    }   
}
