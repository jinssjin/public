package a0324.yanolza;

import java.util.ArrayList;
import java.util.Scanner;

public class AccommodationManager {

    private ArrayList<Accommodation> accommodationlist;
    private ArrayList<Accommodation> bookingcomplitelist;

    public AccommodationManager(){
        accommodationlist = new ArrayList<>();
        bookingcomplitelist = new ArrayList<>();
        accommodationlist.add(new Accommodation("Hotel A", "Seoul", 100.0));
        accommodationlist.add(new Accommodation("Hotel B", "Busan", 80.0));
        accommodationlist.add(new Accommodation("Hotel C", "Jeju", 120.0));
    }

    public void allAccommodation() {
        for(Accommodation avilAcc:accommodationlist){
            if(avilAcc.isAvailable()){
                System.out.println(avilAcc);
            }
        }
    }

    public boolean BookingList(String accName) {
        for(Accommodation name:accommodationlist){
            if(name.getName().equalsIgnoreCase(accName) && name.isAvailable()){
                name.booking();
                bookingcomplitelist.add(name);
                return true;
            }
        }
        return false;
    }

    public void bookingcomplitelists(){
        System.out.println("예약한 숙소");
        for(Accommodation bookedAcc : bookingcomplitelist){
            System.out.println(bookedAcc);
        }
    }

    public void addAccommodationlist(String newAccName, String newAccLocation, double newAccPrice){
        Accommodation additionalAcc = new Accommodation(newAccName,newAccLocation,newAccPrice);
        accommodationlist.add(additionalAcc);
    }

    public void deleteAcc(String delAcc) {
        boolean result = false;
        for(Accommodation hotel:accommodationlist){
            if(hotel.getName().equalsIgnoreCase(delAcc)){
                if(hotel.isAvailable()){
                    accommodationlist.remove(hotel);
                    result = true;
                    break;
                }else{
                    result = false;
                    break;
                }
            }
        }
        if(result){
            System.out.println("삭제됨");
        }else{
            System.out.println("삭제 안됨");
        }
    }

    public void UpdatingAcc(String updateAcc) {
            int i = 0;
            int index = -1;
            int menu = -1;
            boolean flag = true;
            Scanner scan = new Scanner(System.in);
            Accommodation newA = new Accommodation();
            // System.out.println(updateAcc);
        for(Accommodation accommodationupdate : accommodationlist){
            i++;
            if(accommodationupdate.getName().equalsIgnoreCase(updateAcc)){
                index = i-1;
                newA = accommodationupdate;
            }
            // System.out.println(accommodationupdate.getName().equalsIgnoreCase(updateAcc)+" "+accommodationupdate.getName()+" "+updateAcc);
        }
        if(index != -1){
            System.out.print("뭘 수정할건데?\n 1.숙소 이름 \t 2.숙소 위치 \t 3.숙소 가격 \n >>");
            menu = scan.nextInt();
            scan.nextLine();
            while (flag) {
                switch (menu) {
                    case 1:
                        System.out.println("수정할 숙소 이름");
                        newA.setName(scan.nextLine());
                        accommodationlist.set(index, newA);
                        flag = false;
                        break;
                    case 2:
                    System.out.println("수정할 숙소 위치");
                    newA.setLocation(scan.nextLine());
                    accommodationlist.set(index, newA);
                    flag = false;
                    break;
                    case 3:
                    System.out.println("수정할 숙소 가격");
                    newA.setPrice(scan.nextDouble());
                    accommodationlist.set(index, newA);
                    flag = false;
                    break;
                    default:
                    System.out.println("1~3번 중에 입력하세요");
                        break;
                }
            }
        }else{
            System.out.println("찾는 숙소가 없어서 업데이트할 수 없습니다.");
        }
    }

    public void infomateAcc(String infoAcc) {
        for(Accommodation searchAcc:accommodationlist){
            if(searchAcc.getName().equalsIgnoreCase(infoAcc)){
                System.out.println(searchAcc);
            }
        }
    }

}
