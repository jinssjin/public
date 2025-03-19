package a0319;

public class Sum1 {
    public static void main(String[] args) {
        int sum =0;
        float average =0f;  // float 사용시 초기화된 값 뒤에 f를 넣어준다
        int[] score = {100,88,100,100,90};
        // sum과 average를 구하시오
        
        for(int i = 0; i < score.length; i++){
            sum = sum + score[i];
        }

        average = sum /(float)score.length;  // average가 float형이고 sum은 int형이다. float type이 하나 있으면 값은 float로 형변환 해줘야 한다.

        System.out.println("총합 : "+sum);
        System.out.println("평균 : "+average);
    }
}
