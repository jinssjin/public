package a0325;

public class Overloading {
    public static void main(String[] args) {
        String restaurant = "구내식당";
        String chineseFood = "중국집";
        int blue = 1000;
        int yellow = 5000;
        int green = 10000;
        Bill money = new Bill();
        money.charge(restaurant,blue,yellow);
        money.charge(yellow);
    }
}

class Bill {
    void charge(String restaurant, int blue, int yellow){
        System.out.printf("%s의 점심값은 %d원 2장과 %d원 1장을 받았습니다.\n",restaurant,blue,yellow);
    }

    void charge(int yellow){
        System.out.printf("내가 가진 건 %d원 짜리 한장 뿐입니다.",yellow);
    }

}
