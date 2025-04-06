package a0403.movie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Map;
import java.util.Scanner;

public class FileD {
    Scanner scan = new Scanner(System.in);
    private MovieManager mm = new MovieManager();

    public void ticketSaveFile(Map<String,Screen> myMap, String name) {
        try {
            String folderMaking = "d:\\ticket";
            File folder = new File(folderMaking);
            if(!folder.exists()){
                folder.mkdirs();
                System.out.println(folderMaking+" 생성 완료");
            }
            // else{
            //     System.out.println("폴더 생성 실패");
            //     return;
            // }
            File file = new File("d:\\ticket\\ticket.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            if(file.isFile() && file.canWrite()){
                System.out.println("포토티켓으로 출력하시겠습니까?");
                System.out.print("예(Y)    아니오(N) : ");
                String photocardAnswer = scan.nextLine();
                if(photocardAnswer.equalsIgnoreCase("y")||photocardAnswer.equals("예")){
                    bufferedWriter.write(mm.photocardPrint(myMap,name));}
                bufferedWriter.write(mm.ticketPrint(myMap,name));
                bufferedWriter.flush();
                System.out.println("티켓 파일 저장 완료 ");
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println("파일저장실패");
        }
    }

    public void upload() {
        try {
            File file = new File("d:\\ticket\\addMonvieList.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            System.out.println("===================================================================");
            while (line != null) {
                System.out.println(line);
                String[] screen = line.split("/");
                MovieManager.getScreens().add(new Screen(screen[0],screen[1],screen[3],screen[4],Integer.parseInt(screen[5])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("addMonvieList.txt 파일을 찾을 수 없습니다. 경로를 다시 확인해주세요");
        } catch (IOException e) {
            System.out.println("파일 읽기 실패");
        }
    }

}
