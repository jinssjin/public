public class PaymentDTO {
    private int paymentId;
    private String userId;
    private String name;
    private String phone;
    private int price;
    private String state;
    private String reservationDate;
    private String endDate;
    private String deleted;

    // 생성자
    public PaymentDTO() {}

    public PaymentDTO(String userId, String name, String phone, int price, String state, String reservationDate, String endDate) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.price = price;
        this.state = state;
        this.reservationDate = reservationDate;
        this.endDate = endDate;
        this.deleted = "N";
    }

    // Getter & Setter
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
