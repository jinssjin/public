package a0319;

public class MaxSecond {
    public static void main(String[] args) {
        // int max = 0;
        // int max2 =0;
        // int [] arr = {65,74,23,75,68,96,88,98,54};

        // for(int i =0; i < arr.length; i++){
        // if(max < arr[i]){
        // max = arr[i];
        // }

        // }
        // for(int j =0; j < arr.length; j++){
        // if( arr[j] == max){
        // continue;
        // }else if(max2 < arr[j]){
        // max2 = arr[j];
        // }

        // }
        // System.out.println(max2);

        int[] numbers = { 65, 74, 23, 75, 68, 96, 88, 98, 54 };
        int secondTopIdx = getSecondTopIdx(numbers);

        System.out.println("배열: [65, 74, 23, 75, 68, 96, 88, 98, 54]");
        System.out.printf("두 번째로 큰 수: %d", numbers[secondTopIdx]);

    }

    private static int getSecondTopIdx(int[] arr) {
        int secondIdx = 0;
        int topIdx = getTopIndex(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i == topIdx) {
                continue; // 최대값이 들어있는 인덱스 번호 일 때 for문으로 복귀
            }
            if (arr[i] > arr[secondIdx]) {
                secondIdx = i;
            }
        }

        return secondIdx;
    }

    private static int getTopIndex(int[] arr) {
        int topIdx = 0; // 최대값 인덱스 번호 초기화
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[topIdx]) {
                topIdx = i;
            }
        }
        return topIdx; // 최대값 인덱스 번호 반환
    }
}
