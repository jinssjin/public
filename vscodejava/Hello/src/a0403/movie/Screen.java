package a0403.movie;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Screen {
    private String title;  // 영화제목
    private String theater;  // 상영관
    private String time;  // 영화시간
    private String rating; // 영화등급(청불)
    private int price; // 가격
    private DecimalFormat priceFormat = new DecimalFormat("#,###원");
    private ArrayList<String> seats;
    
    public Screen(String title, String theater, String time, String rating, int price) {
        this.title = title;
        this.theater = theater;
        this.time = time;
        this.rating = rating;
        this.price = price;
        seats = new ArrayList<>();
        for(int i=0; i<=52; i++){
            seats.add(i+"");
        }
        
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTheater() {
        return theater;
    }
    public void setTheater(String theater) {
        this.theater = theater;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    


    @Override
    public String toString() {
        String priceComma = priceFormat.format(price);
        return ". " + title + "("+ rating+ ")" + ", 상영관 : " + theater + ", 영화시작 : " + time + ", 가격 : " + priceComma;
    }

    public void seatToString(){
        for(int i=1; i <seats.size()-3; i+=12){
            System.out.printf("|  [%2s][%2s][%2s]\t\t[%2s][%2s][%2s][%2s][%2s][%2s]\t[%2s][%2s][%2s]   |\n",seats.get(i),seats.get(i+1),seats.get(i+2),seats.get(i+3),seats.get(i+4),seats.get(i+5),seats.get(i+6),seats.get(i+7),seats.get(i+8),seats.get(i+9),seats.get(i+10),seats.get(i+11),seats.get(i+12));
        }
    }

}
