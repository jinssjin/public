package a0317;

public class Ex04 {
    public static void main(String[] args) {
        int a = (int)(Math.random() * 6) + 1;
        int b = (int)(Math.random() * 6) + 1;

        while (true) {
            System.out.println(a+","+b);
            if((a+b)==5){
            break;}
        }
    }
}
