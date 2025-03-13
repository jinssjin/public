package a0313;

public class Ari3 {
    public static void main(String[] args) {
        
        String strSeven = "7";
        String strPi = "3.14";

        int a = Integer.parseInt(strSeven); // 문자를 정수로 변환
        double b = Double.parseDouble(strPi); // 문자를 실수로 변환
        
        double c = a + b;
        System.out.printf("%d + %.2f = %.2f",a,b,c);


        int x = 5;
        int y = 2;
        double z = x / y;
        System.out.println(z);

        int d = 10; // 10
        d += 5; // 15
        d %= 3; // 0
        System.out.println(d); //0
    }
}
