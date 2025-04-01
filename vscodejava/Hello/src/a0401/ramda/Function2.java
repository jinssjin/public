package a0401.ramda;


interface Caculator1 {
    int sum(int a, int b);

    
}

public class Function2 {
    public static void main(String[] args) {
        
        Caculator1 mc = (int a, int b) -> a+b;  // 람다를 적용한 함수  // "->" : 계산 후 리턴

        // 이렇게 람다 함수를 사용하면 MyCaculator와 같은 실제 클래스
        // 없이도 Caculator1 객체를 생성할 수 있고
        // 일반 적인 코드보다 간결함
        int result = mc.sum(3,4);

        System.out.println(result);
    }
}
