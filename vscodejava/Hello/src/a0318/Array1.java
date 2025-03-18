package a0318;

public class Array1 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        System.out.println(sumArray(numbers));
            }
        
            private static int sumArray(int[] numbers) {
                int sum = 0;
                // for(int i=0;i<numbers.length;i++){
                //     sum = sum + numbers[i];
                // }
                for(int num:numbers){  // 향상된 for문
                    sum += num;
                }
                return sum;
            }
}
