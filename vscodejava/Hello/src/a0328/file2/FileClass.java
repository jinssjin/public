package a0328.file2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileClass {
    private File file;  // 자바에서 제공하는 파일 객체를 저장
    private String dir;  // 디렉토리(폴더)
    private String fileName;  // 파일명을 저장

    public FileClass(){
        file = new File("d:\\");
    };

    public FileClass(String dir, String fileName) {
        file = new File("d:\\"+dir+"\\"+fileName+".txt");
        this.dir = "d:\\"+dir;
        this.fileName = fileName+".txt";
    }

    public void create() throws Exception {
        boolean exist = check(file);
        if(exist){
            file.delete();  // 파일있으면 지운다. (delete는 File클래스에서 제공하는 삭제메서드)
            file.createNewFile();  // 새로운 파일 생성
        }else{
            file = new File(dir);  // d:\\dir
            file.mkdir();  // 디렉토리(폴더) 생성
            file = new File(dir+"\\"+fileName);  // d:\\student\\student_Grade.txt
            file.createNewFile();  // 새로운 파일 생성
        }
    }

    private boolean check(File file) {
        if(file.exists()){
            return true;
        }
        return false;
    }

    public void write(String str) throws Exception {
        FileWriter fw = new FileWriter(file);  // 파일쓰기를 위한 FileWriter 생성
        PrintWriter pw = new PrintWriter(fw);  // 파일에 데이터를 출력하기 위해 편리한 PrintWriter메서드 (println, printf)
        pw.println(str);
        fw.close();
    }

    public void read() throws Exception{
        boolean exist = check(file);
        if(exist){
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            br.close();
        }else{
            System.out.println("읽을 파일이 없습니다.");
        }
    }
}
