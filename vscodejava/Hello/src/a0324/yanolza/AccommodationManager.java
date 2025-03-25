package a0324.yanolza;

import java.util.ArrayList;

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

}
