package a0407;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParkingManager {
    Scanner sc = new Scanner(System.in);
    private static Map<String,Integer> parkedCar = new HashMap<String,Integer>();

    public void parkCar(String insertCarNumber, int inTime) {

        if(parkedCar.size() >= 5){
            System.out.println("만차입니다 돌아가세요");
            System.out.println();
            System.out.println("--------------------------------");
            return;
        }

        parkedCar.put(insertCarNumber,inTime);
        System.out.println(insertCarNumber+" 입차 완료.");
        System.out.println();
        System.out.println("--------------------------------");
    }

    public void exitCar(String searchCarNumber, int outTime) {
        int price = 100;
        if(parkedCar.containsKey(searchCarNumber)){
            int inTime = parkedCar.get(searchCarNumber);
            int parkingFee = (outTime - inTime) * price;
            parkedCar.remove(searchCarNumber);
            System.out.println();
            System.out.println("요금: "+parkingFee+"원");
            System.out.println();
            System.out.println("--------------------------------");
        }else{
            System.out.println("없는 차량입니다. 차량번호를 확인해주세요");
            System.out.println();
            System.out.println("--------------------------------");
        }
    }

    public void showCars() {
        System.out.println("현재 주차 차량:");
        if(parkedCar.isEmpty()){
            System.out.println("현재 주차된 차량이 없습니다.");
        }else{
            for(Map.Entry<String,Integer>entry:parkedCar.entrySet()){
                System.out.println("차량번호: "+entry.getKey()+", 입차시간: "+entry.getValue());
            }
        }
        System.out.println();
        System.out.println("--------------------------------");

    }
    
    

}
