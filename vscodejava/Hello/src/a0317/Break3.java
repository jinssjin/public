package a0317;
// 합계가 10보다 큰 처음값
public class Break3 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1;;i++){
            sum += i;
            if(sum>10){
                System.out.println("합이 10보다 크면 종료 : i="+i+" sum="+sum);
                break;
            }
            i++;
        }
    }
}
