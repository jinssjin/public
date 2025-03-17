package a0317;

public class Break1 {
    public static void main(String[] args) {

        // 1부터 시작해서 숫자를 계속 누적해서 더하다가 합계가 10보다 처음으로 큰 값
        int sum = 0;
        int i = 1;
        
        while (true) { //조건문을 true로 해놓았기 때문에 지속 출력
            sum += i;
            if(sum>10){
                System.out.println("합이 10보다 크면 종료: i=" +i+" sum"+sum);
                break;
            }
            i++;
        }
        // 조건식이 true, 조건이 항상 참이기 때문에 이렇게 두면 while은 무한 반복된다.
        // → break문이 있어서 중간에 빠져나올 수 있다.
        // 만약 sum > 10 조건에 만족하면 결과출력 후 break를 사용해서
        // while문을 빠져나간다
        // break는 while문 전체를 종료한다.
    }
}
