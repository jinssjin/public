package a0328.file;

import java.io.FileOutputStream;
import java.io.IOException;

public class File1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream output = new FileOutputStream("d:/out.txt"); // 출력하면 경로 폴더에 텍스트파일 생성됨
        output.close();
    }
}
