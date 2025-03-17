package a0317;

public class Do_While1_1 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        int endNum = 10;
        
        do {
            sum = sum +i;
            System.out.println("i= "+i+" sum= "+sum);
            i++;
        } while (i <= endNum);
    }
}
