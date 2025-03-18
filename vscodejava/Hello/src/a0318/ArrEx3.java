package a0318;

import java.util.Arrays;

public class ArrEx3 {
    public static void main(String[] args) {
        int[] arrInt = new int[5];
        arrInt[0] = 1;
        arrInt[1] = 2;
        arrInt[2] = 3;
        arrInt[3] = 4;
        arrInt[4] = 5;
    
        for(int num:arrInt){
            System.out.println(num);
        }

        System.out.println(Arrays.toString(arrInt));  // 일렬로 출력
    }
}
