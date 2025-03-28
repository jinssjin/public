package a0328.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class File3_1 {
    public static void main(String[] args) throws IOException {
        // 폴더 경로
        String folderPath = "d:\\abc";
        File folder = new File(folderPath);
        // 폴더가 존재하지 않으면 생성

        if(!folder.exists()){  // exists() 존재한다면, 있다면  // 맨 앞에 !를 넣어서 존재하지않는다면
            if(folder.mkdirs()){  // mkdirs() 폴더생성, 폴더를 맹글어라
                System.out.println("폴더 생성됨"+folderPath);
        }else{
            System.out.println("폴더 생성 실패");
            return;
        }
    }
        PrintWriter pw = new PrintWriter(folderPath+"\\out.txt");
        for(int i =1; i <11; i++){
            String data = i + " 번째 줄입니다.";
            pw.println(data);
        }

        pw.close();

        //println 메서드 사용할 수 있다. \r\n 대체한다
    }
}
