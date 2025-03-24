package a0325;

public class Overriding {
    public static void main(String[] args) {
        Football s = new Football();
        System.out.print("축구는 ");
        s.ball();
        System.out.print("축구는 ");
        s.tools();
    }
}

class Sports{
    void ball(){
        System.out.println("공을 사용합니다.");
    }
    void tools(){
        System.out.println("도구를 사용합니다.");
    }
}

class Football extends Sports{
@Override
void tools(){
    System.out.println("도구를 사용하지 않습니다.");
}
    
}