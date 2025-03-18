package a0318;

public class Method2 {
    public static void main(String[] args) {
        int sum1 = add(5,10);
        System.out.println("결과1 출력: " + sum1);
        int sum2 = add(15,20);
        System.out.println("결과2 출력: " + sum2);

        int result1 = subtract(10,5);
        System.out.println("결과1 출력: " + result1);
        int result2 = subtract(20,15);
        System.out.println("결과2 출력: " + result2);

            }
        
    public static int add(int a, int b) {
        System.out.println(a + "+" + b + "연산수행");
        int sum = a + b;
        return sum;
    }

    public static int subtract(int a, int b) {
        System.out.println(a + "-" + b + "연산수행");
        int result = a - b;
        return result;        
    }

    public static int muliply(int a, int b) {
        System.out.println(a + "*" + b + "연산수행");
        int result = a * b;
        return result;        
    }

    public static int divide(int a, int b) {
        System.out.println(a + "/" + b + "연산수행");
        int result = a / b;
        if(a == 0 || b == 0){
            System.out.println("0으로 나눌 수 없음");
        }
        return result;        
    }
}


    
    



// add, subtract, muliply, divide

