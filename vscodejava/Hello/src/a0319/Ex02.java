package a0319;

public class Ex02 {
    public static void main(String[] args) {
        // int max = 0;
        // String[] name = {"Elena","Suzie","John","Emily","Nada","Kate","Alex","Daniel","Sam"};
        // int[] score= {65,74,23,75,68,96,88,98,54};
        

        // System.out.printf("1등 : %s(%d점)",name[max],score[max]);

        // for(int i=0; i < score.length; i++){
        //     if(max < score[i]){
        //         max = score[i];
        //     }
        // }

        String[] name = {"Elena","Suzie","John","Emily","Nada","Kate","Alex","Daniel","Sam"};
        int[] score= {65,74,23,75,68,96,88,98,54};

        // 정수 배열 중 가장 큰 요소의 인덱스를 계산
        int i = topIndex(score);

        System.out.printf("1등 : %s(%d점)",name[i],score[i]);
                
            }
        
            private static int topIndex(int[] arr) {
                int topIdx = 0;  // 가장 큰 값의 인덱스 초기화
                for(int i =0; i < arr.length; i++){
                    if(arr[topIdx] < arr[i]){
                        topIdx = i; // topIdx를 i로 변경
                    }
                }
                return topIdx;
            }
}
