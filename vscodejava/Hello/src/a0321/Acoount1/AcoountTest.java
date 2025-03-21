package a0321.Acoount1;

public class AcoountTest {
    public static void main(String[] args) {
        

        Acoount acc = new Acoount();
        // acc.balance = 1000;
        // System.out.printf("잔액: %d",acc.balance);
        acc.setBalance(1000);
        System.out.printf("잔액: %d",acc.getBalance());
        }
        
        class Acoount{
            // private : 자신 외 모든 클래스의 접근을 거부한다. 게터메소드와 세터메소드를 생성하거나 생성자를 작성해서 객체를 만듬
            private int balance;

            // public int getBalance() {
            //     return balance;
            // }

            // public void setBalance(int balance) {
            //     this.balance = balance;
            // }

            // 게터 메소드 : 갖고와야하는 메소드
            public int getBalance(){ 
                return balance;
            };

            // 같은 class안에서만 사용 가능하기 떄문에
            // 아래와 같이 세터 메서드 (아래에 있는 public 들어간 메서드)를 생성하여 호출
            // 세터 메소드 : 보내주는 메소드
            public void setBalance(int b) {
                balance = b;
            
            }
}

}