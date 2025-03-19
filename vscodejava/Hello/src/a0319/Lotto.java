package a0319;

import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        // ball이라는 변수에 45개 방을 지정해보시오
        int[] ball = new int[45];
        for(int i=0; i < ball.length; i++){
            ball[i] = i + 1;
        }
        // System.out.print(Arrays.toString(ball));

        var n =0;
        var tmp =0;

        for(int i=0; i <= 1000; i++){
            n = (int)(Math.random()*45); // 0~9까지 랜덤하게 나옴
            tmp = ball[0];
            ball[0] = ball[n];
            ball[n] = tmp;
        }
    
            // System.out.println(Arrays.toString(ball));

            // System.out.printf("ball[0] = %d <n> ball[1] = %d",ball[0],ball[2]);
            for(int i=0; i < 6; i++){
            System.out.printf("ball[%d]=%d%n",i,ball[i]);

            for(int i=0; i < 6; i++){
                n = (int)(Math.random()*45);
                tmp = ball[i];
                ball[i] = ball[n];
                ball[n] = tmp;
        }

        System.out.println(Arrays.toString(ball));
    }
    
    
}
}
