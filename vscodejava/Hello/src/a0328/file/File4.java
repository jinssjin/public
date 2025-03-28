package a0328.file;

import java.io.FileWriter;
import java.io.IOException;

public class File4 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("d:/out.txt");
        for(int i =1; i <11; i++){
            String data = i + " 번째 줄입니다.\r\n";
            fw.write(data);
        }

        fw.close();

        FileWriter fw2 = new FileWriter("d:/out.txt",true);   // true를 써주면 이어쓰기 , false를 써주면 덮어쓰기
        for(int i =11; i <21; i++){
            String data = i + " 번째 줄입니다.\r\n";
            fw2.write(data);
        }

        fw2.close();

    }
}