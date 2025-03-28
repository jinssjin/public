package a0328.file;

import java.io.IOException;
import java.io.InputStream;

public class Input1 {
    public static void main(String[] args) throws IOException { // 입출력 예외처리를 해야한다
        InputStream in = System.in;
        // InputStream read에서는 1byte 크기의 사용자 입력
        // System.in; : 키보드로 입력받겠다.
        int a;
        a = in.read();
        System.out.println(a);

        // 입력받은 문자값을 아스키코드로 출력해준다.
        // 아스키코드는 7bit를 활용한 문자 표현코드
        // 알파벳 대소문자, 숫자0~9, 특수기호
        // 숫자 0은 아스키코드값은 48, 문자 a는 97
    }
}
