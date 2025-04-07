package a0407;

public class Car {
    private String carNumber;
    private int inTime;

    public Car(String carNumber, int inTime) {
        this.carNumber = carNumber;
        this.inTime = inTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getInTime() {
        return inTime;
    }
}