package a0312;

public class VarEx6 {
    public static void main(String[] args) {
        // 틀린값
        // double f = 77.0;
        // double s_1 = (f-32.0);
        // double s = s_1/1.8;
        
        // System.out.printf("화씨 %.1d도는 섭씨로 %.1d도입니다.",f, s);

        double f = 77.0;
        double c = (f - 32.0) / 1.8;
        
        System.out.printf("화씨 %.1f도는 섭씨로 %.1f도입니다.",f,c);
    }
}
