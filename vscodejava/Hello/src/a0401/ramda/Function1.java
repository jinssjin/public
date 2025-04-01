package a0401.ramda;


interface Caculator {
    int sum(int a, int b);

    
}

class MyCaculator implements Caculator {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

}

public class Function1 {
    public static void main(String[] args) {
        MyCaculator mc = new MyCaculator();
        int result = mc.sum(3,4);

        System.out.println(result);
    }
}
