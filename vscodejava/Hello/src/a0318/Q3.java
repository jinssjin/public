package a0318;

public class Q3 {
    public static void main(String[] args) {
        
        // System.out.println(factorial(5));
        //         System.out.println(factorial(3));
                
        //     }
        
        //     private static int factorial(int n) {
        //         int n = for(n=1;n<i;n++){
        //             n *= n
        //         }
        //     }
        System.out.println(factorial(5));
        System.out.println(factorial(3));
        
        }
        
            private static int factorial(int n) {
                if(n==0 || n==1){
                    return 1;
                }
                return n * factorial(n-1);
            }

            private static int factorial(int n) {
                for(int i=0;i<=n;i++){
                    return result = i * n; 
                }
    }

    // factorial(5) = 5 * factorial(4) ← return 5 * factorial(5-1);
    // factorial(4) = 4 * factorial(3) ← return 4 * factorial(4-1); 재귀함수
    // factorial(3) = 3 * factorial(2) ← return 3 * factorial(3-1); 재귀함수
    // factorial(2) = 2 * factorial(1) ← return 2 * factorial(2-1); 재귀함수
    // factorial(1) = 종료조건

    // 역순으로 계산
    // factorial(1) = 1
    // factorial(2) = 2 x 1
    // factorial(3) = 3 x 2 x 1
    // factorial(4) = 4 x 3 x 2 x 1
    // factorial(5) = 5 x 4 x 3 x 2 x 1
    
