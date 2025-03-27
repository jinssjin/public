package a0327.접근제어자;


class DefaultClass{
    void display(){  // 앞에 아무것도 안붙이면 접근제어자 default
        System.out.println("패키지(폴더) 내부에서만 접근 가능");
    }
}

public class DefualtExample {
    public static void main(String[] args) {
     
        DefaultClass obj = new DefaultClass();
        obj.display();  // 정상 실행 (같은 패키지 안에 있기 때문에)
    }
}
