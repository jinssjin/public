package a0328.file;

import java.io.IOException;
import java.io.InputStream;

public class Input3 {
    public static void main(String[] args) throws IOException { // 입출력 예외처리를 해야한다
        InputStream in = System.in;

        byte[] a = new byte[3];

        in.read(a);

        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);

    }
}
