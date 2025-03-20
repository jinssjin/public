package a0320;

public class Class3 {
    public static void main(String[] args) {
        // Card.width, Card.height 클래스 변수여서 객체 생성없이 사용 가능.
        System.out.println("Card.width = "+Card.width);
        System.out.println("Card.height = "+Card.height);

        // 객체 생성 후 참조변수 c1을 사용
        Card c1 = new Card();  // c1 주소할당
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();  // c1 주소할당
        c2.kind = "Spade";
        c2.number = 5;

        System.out.println("c1은 "+c1.kind+","+c1.number+"이며, 크기는"+c1.width+","+c1.height);
        System.out.println("c1은 "+c2.kind+","+c2.number+"이며, 크기는"+c2.width+","+c2.height);

        System.out.println("c1의 width와 height 50, 80으로 변경합니다.");
        // c1.width = 50;  // 공용변수기 때문에 c2도 바뀜, 바뀌어서 출력되긴 하지만
        // c1.height = 80;  // 공용변수기 때문에 c2도 바뀜, 바뀌어서 출력되긴 하지만

        Card.width = 50;        // 할당된 주소에서 바꾸는 것보다 직접 바꿔주는게 더 권장
        Card.height = 50;        

        System.out.println("c1은 "+c1.kind+","+c1.number+"이며, 크기는"+c1.width+","+c1.height);
        System.out.println("c1은 "+c2.kind+","+c2.number+"이며, 크기는"+c2.width+","+c2.height);
    }
}

class Card{
    String kind;
    int number;
    static int width = 100;  // class 변수
    static int height = 80;
}
