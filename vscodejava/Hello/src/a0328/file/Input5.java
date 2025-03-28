package a0328.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Input5 {
    public static void main(String[] args) throws IOException { // 입출력 예외처리를 해야한다
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        String a = br.readLine();  // 문장 입력이 가능

        System.out.println(a);

    }
}