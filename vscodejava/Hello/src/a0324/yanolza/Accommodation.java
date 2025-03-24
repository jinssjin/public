package a0324.yanolza;

public class Accommodation {
    private String name;
    private String location;
    private double price;
    private boolean available;

    public Accommodation(){
        
    }
    
    public Accommodation(String name, String location, double price) {
        this.name = name;
        this.location = location;
        this.price = price;
        available = true;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "숙소 이름 : " + name + ", 숙소 위치 : " + location + ", 숙소 가격 : " + price + ", 숙박여부"
                + (available ? "숙박가능" : "숙박불가능") + "]";
    }
}
