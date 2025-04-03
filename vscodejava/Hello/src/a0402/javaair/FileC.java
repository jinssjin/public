package a0402.javaair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


// 디렉토리(폴더가 없는 경우 폴더 생성) - 숙제


public class FileC {

    private FlightManager fm = new FlightManager();

    public void ticketSaveFile(Map<String,Flight> reservationMap, String name) {
        try {
            String folderPath = "d:\\ticket";
            File folder = new File(folderPath);
            if(!folder.exists()){  // 폴더없으면
                if(folder.mkdirs()){  // mkdirs() 폴더생성메서드
                    System.out.println("폴더 생성됨"+folderPath);
            }else{
                System.out.println("폴더 생성 실패");
                return;
            }}
            File file = new File("d:\\ticket\\ticket.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));  //Writer ()안에 ,true 넣어주면 데이터 누적
            // BufferedWriter를 사용하여 file에 데이터를 쓸 준비
            // FileWriter는 기본적으로 기존파일을 덮어씁니다.
            if(file.isFile() && file.canWrite()){
                // canWrite() : 쓰기권한이 있는지 확인 - true
                bufferedWriter.write(fm.ticketPrint(reservationMap,name));  //티켓정보를 파일에 씁니다.
                bufferedWriter.flush();
                System.out.println("파일저장을 완료");
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println("파일저장실패");
        }
    }

    public void upload() {
        try {
            File file = new File("d:\\ticket\\schedule1.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));  인코딩 UTF-8으로 읽을때
            String line;
            System.out.println("===================================================================");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] flight = line.split("/");
                // split 메서드
                FlightManager.getFlights().add(new Flight(flight[0], flight[1], Integer.parseInt(flight[2]), Boolean.parseBoolean(flight[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("schedule.txt 파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 읽기 실패");
        }
        // catch은 여러개가 가능하다
    }

}
