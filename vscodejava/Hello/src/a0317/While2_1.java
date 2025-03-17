package a0317;

public class While2_1 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        int endNum = 10;
        // sum = sum + 1;
        // System.out.println("i="+i + " sum="+sum);
        // i++;

        // sum = sum + 2;
        // System.out.println("i="+i + " sum="+sum);
        // i++;

        // sum = sum + 3;
        // System.out.println("i="+i + " sum="+sum);
        

    //     while (i < 10 && sum < 10) {
    //         i++; sum = sum++;
    //         System.out.println("i="+i + " sum="+sum);
    //     }
    // }
        while (i <= endNum){
            sum = sum + i;
            System.out.println("i=" + i + "sum=" + sum);
            i++;
        }
    }
}



