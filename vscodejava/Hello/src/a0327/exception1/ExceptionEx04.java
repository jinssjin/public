package a0327.exception1;

public class ExceptionEx04 {
    public static void main(String[] args) {
        try {
            checkNumber(-5);
                    } catch (customException e) {  // 사용자정의 예외 : 내가 직접 만든 예외
                        System.out.println("예외발생: "+e.getMessage());
                    }
                }
            // 매개변수로 받은 num이 음수라면 customException을 발생시킵니다.
            // throw new customException을 선언하여 이 메서드가 예외를 던질 수 있음을 표시
                private static void checkNumber(int num) throws customException{
                    if(num < 0){
                        throw new customException("음수는 허용 안됩니다.");
                    }
                    System.out.println("입력값: "+num);
                }
}


// checkNumber(-5); 호출하여 음수 전달
// 예외 발생
// catch (customException e)에서 예외를 잡고 예외메세지를 출력합니다
//