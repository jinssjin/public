package a0313;

public class Ari2 {
    public static void main(String[] args) {
        double tail = 176.6;
        double weight = 74.34;

        System.out.printf("신장 : %.1fcm\n",tail);
        System.out.printf("체중 : %.1fkg\n",weight);
        
        System.out.printf("신장 : %dcm\n",(int)tail);
        System.out.printf("체중 : %dkg\n",(int)weight);
        // 다운캐스팅
}    
}
