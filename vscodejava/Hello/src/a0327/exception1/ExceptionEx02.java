package a0327.exception1;


// throw 키워드
// 예외를 직접 처리하지 않고 호출한 메서드에 전달할 수 있다.
public class ExceptionEx02 {
    public static void main(String[] args) throws Exception {
        divide(10,0);
            }
        
            private static void divide(int i, int j) throws ArithmeticException {
                if(j == 0){
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }else{
                    System.out.println("결과: "+(i/j));
                }
            }
}
