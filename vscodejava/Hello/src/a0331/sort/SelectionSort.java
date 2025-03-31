package a0331.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] array = {63,34,25,17,22,11,90};
        selectionSort1(array);
        System.out.println("Sort Array: " + Arrays.toString(array));

    }

    private static void selectionSort1(int[] array){
        int n = array.length;
        for(int i = 0; i < n-1; i++){
            int minIndex = i;
            for(int j = i+1; j < n; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        // for(1)을 한바퀴 돌면 : i=0, minIndex=0,
                            // for(2)을 한바퀴 돌면 : j=1,
                                                // if문을 돌면 : array[1] < array[0], if(true), minIndex=1
                            // for(2) 밖으로 나오면 temp = array[1] = 34, array[1]= array[0]= 63, array[0] = 34
        // for(1)을 한바퀴 돌면 : i=1, minIndex=1,
                            // for(2)을 한바퀴 돌면 : j=2,
                                                // if문을 돌면 : array[2] < array[1], if(true), minIndex=2
                            // for(2) 밖으로 나오면 temp = array[2] = 25, array[2]= array[1]= 63, array[1] = 25;
    }        
}