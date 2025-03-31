package a0331.sort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        // 앞에서 부터 해당원소가 위치할 곳을 탐색하고 해당 위치에 삽입
        int [] array = {63,34,25,17,22,11,90};
        insertionSort1(array);
        System.out.println("Sort Array: " + Arrays.toString(array));

    }

    private static void insertionSort1(int[] array){
        int n = array.length;
        for(int i = 1; i < n; i++){
            int key = array[i];  // key = 1;
            int j = i-1;  // j = 0;
            while (j>=0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;

            // for 한바퀴 돌면 i=1, key = 34, j = 0, while(true), array[0+1] = array[0], j--:j=-1, while반복, array[1] = 63; (두번쨰방에 63)
                                                                                                // while 두바퀴 돌면 j=-1, while(false), array[0] = key = 34 (첫번째방에 34)
            // for 두바퀴 돌면
        }
    }
}
