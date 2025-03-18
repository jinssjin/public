package a0318;

public class Ex01 {
    public static void main(String[] args) {
        int n = 3;
        int v = volume(n);
        System.out.println(v);
            }
        
        public static int volume(int n){
            System.out.println("한 변의 길이가 " + n + "인 정육면체의 부피");
            int x = n * n * n;
            return x;
        }
}
