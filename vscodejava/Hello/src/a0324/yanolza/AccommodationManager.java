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
        for(Accommodation name:bookingcomplitelist){
            if(name.getName().equalsIgnoreCase(accName) && name.isAvailable()){
                name.booking();
                bookingcomplitelist.add(name);
                return true;
            }
        }
        return false;
    }


}
