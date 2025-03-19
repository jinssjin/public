package a0319;

public class Array3 {
    public static void main(String[] args) {
        int[][] score = {
            {100,95,46},
            {20,20,20},
            {30,30,30},
            {40,40,40}
        };

        System.out.print("번호 국어 영어 수학 합계 평균");
        System.out.println();
        System.out.print("=============================");
        System.out.println();
        
        double aver = 0;

        for(int i=0; i < score.length; i++){
            int sumStudent = 0;
            for(int j=0; j < score[i].length; j++){

                sumStudent += score[i][j];
                
                aver = (double)sumStudent/(score[i].length);


            }
            int num = i+1;
            System.out.printf("%3d %5d %4d %4d %3d %4.2f \n",num,score[i][0],score[i][1],score[i][2],sumStudent,aver);        
            
        }
        System.out.println("=============================");
        System.out.print("총점 :");

        for(int j=0; j < score[j].length; j++){
            int sumSubject = 0;
            for(int i=0; i < score.length; i++){

                sumSubject += score[i][j];
            }
            
            System.out.printf("%4d",sumSubject);
}
}
}
