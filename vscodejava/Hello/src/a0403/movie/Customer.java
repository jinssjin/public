package a0403.movie;

public class Customer {
    private String name;
    private int birthDate;
    private boolean membership;
    private String pw;
    private String seat;

// 좌석 확인을 위한 패스워트 포함한 생성자
    public Customer(String name, int birthDate, boolean membership, String pw) {
        this.name = name;
        this.birthDate = birthDate;
        this.membership = membership;
        this.pw = pw;
    }

// 예매를 위한 고객 정보만을 담은 생성자
    public Customer(String name, int birthDate, boolean membership) {
        this.name = name;
        this.birthDate = birthDate;
        this.membership = membership;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
    public boolean isMembership() {
        return membership;
    }
    public void setMembership(boolean membership) {
        this.membership = membership;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }

}
