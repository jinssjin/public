package a0328.file;

import java.io.IOException;
import java.io.InputStream;

public class Input2 {
    public static void main(String[] args) throws IOException { // 입출력 예외처리를 해야한다
        InputStream in = System.in;

        int a;
        int b;
        int c;

        a = in.read();
        b = in.read();
        c = in.read();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
