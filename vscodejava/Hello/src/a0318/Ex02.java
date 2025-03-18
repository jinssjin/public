package a0318;

public class Ex02 {
    public static void main(String[] args) {
        // double n;
        // int s = 3;
        // int cal = kcal(s);
        // System.out.print(cal + "Kcal");
        //     }
        
        // public static void kcal(int s){
        //     System.out.println("삼겹살 " + s + "인분의 칼로리: ");
        //     double n = 5.179 / 1000 * 180;
        //     double result = n * s;
        // }

        int n = 3;
        double x = calculate5(n);
                System.out.printf("삼겹살 %d 인분의 칼로리: %.2f Kcal");
                
        }
        
            public static double calculate5(int amount) {
                int totalGram = amount * 180;
                double totalKcal = totalGram * 5.179;
                return totalKcal;
            }

        }
