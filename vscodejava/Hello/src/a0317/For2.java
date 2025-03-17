package a0317;

public class For2 {
    public static void main(String[] args) {
        int sum = 0;
        int endNum = 10;
        for(int i=1; i<=endNum; i++){
            sum = sum + i;
            System.out.println("i ="+i+ " sum ="+ sum);
        }
    }
}


// for(;;){  // ;; for문 무한 반복
//     코드
// }