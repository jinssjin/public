package a0321;

public class MyMath1 {
        public static void main(String[] args) {
         
            // 2. MyMath 객체 생성
            MyMath mm = new MyMath();

            // 3. MyMath 객체 사용
            int m1 = mm.add(5,6);
            int m2 = mm.subtract(9,5);
            int m3 = mm.multiplay(4,5);
            double m4 = mm.divide(8,2);
            int m5 = mm.max(15,6);
            System.out.println("m1 += " + m1);
            System.out.println("m2 -= " + m2);
            System.out.println("m3 *= " + m3);
            System.out.println("m4 /= " + m4);
            System.out.println("m5 >= " + m5);
        }
    
}

// 사칙연산을 수행하는 매서드를 가진 MyMath Class
// 매서드 클래스 영역에 정의 가능
// 1. MyMath 클래스 작성

class MyMath{
    int add(int a, int b){
        int result = a + b;
        return result;
    }

    int subtract(int a, int b){
        int result = a - b;
        return result;
    }

    int multiplay(int a, int b){
        int result = a * b;
        return result;
    }

    double divide(double a, double b){
        return a / b;
    }

    // 큰 수 구하기
    int max(int a, int b){
        int result;
        if(a>b){
            result = a;
        }else{
            result = b;
        }
        return result;
    }

}