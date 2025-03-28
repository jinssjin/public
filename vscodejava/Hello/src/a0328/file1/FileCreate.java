package a0328.file1;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {
        File file = new File("d:\\textFolder\\extample.txt");
        
        try {
            // 폴더가 없으면 생성
            File dir = file.getParentFile();  // 파일의 부모디렉토리 가져오기
            if(!dir.exists()){  // 폴더가 없으면
                dir.mkdirs();   // 폴더를 생성하고
                System.out.println("폴더 생성된:"+dir.getAbsolutePath());
            }

            // 파일 생성
            if(file.createNewFile()){  // 파일을 새로 생성함
                System.out.println("파일 생성됨: "+file.getAbsolutePath());
            }else{
                System.out.println("파일이 존재함");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
