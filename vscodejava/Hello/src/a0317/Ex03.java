package a0317;

public class Ex03 {
    public static void main(String[] args) {
        // int row;
        // int i;
        // for(row=1;row<=5;row++){
        //     for(i=1;i<=row;i++)
        //     System.out.println("*");
        //     i++;
        // }

        int row = 5;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        
    }
}
