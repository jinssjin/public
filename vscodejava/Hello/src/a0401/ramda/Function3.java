package a0401.ramda;


interface Caculator2 {
    int sum1(int a, int b);

    
}

public class Function3 {
    public static void main(String[] args) {
        
        Caculator2 mc = Integer::sum;  // 각 요소를 합산해라  // "::" : 순회해라
        int result = mc.sum1(3,4);

        System.out.println(result);
    }
}
