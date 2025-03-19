package a0319;

import java.util.Arrays;

public class Shuffle {
    public static void main(String[] args) {
        int[] numArr = {0,1,2,3,4,5,6,7,8,9};

        // for(int i=0; i < numArr.length; i++){
            // System.out.println(numArr[i]);
            // System.out.print(numArr[i] + " ");
        // }

        // for(int num : numArr){  // numArr배열
        //     System.out.println(num);
        // }

        // System.out.println(Arrays.toString(numArr)); // 데이터를 시각화된 것(문자) : 연산불가
        for(int i=0; i < 100; i++){
        int n = (int)(Math.random()*10); // 0~9까지 랜덤하게 나옴
        int tmp = numArr[0];
        numArr[0] = numArr[n];
        numArr[n] = tmp;
    }

        System.out.println(Arrays.toString(numArr));

        
    }
}
