package mvc.model;

import java.sql.Date;

public class CouponDTO {
    private int couponNum;
    private String userId;
    private String coupontype;
    private String couponContent;
    private int couponValue;
    private Date startDate;
    private Date endDate;
    private String couponState;
    private String couponDeleted;

    // Getter/Setter
    
    public String getCoupontype() {
		return coupontype;
	}

	public void setCoupontype(String coupontype) {
		this.coupontype = coupontype;
	}
    
    public int getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(int couponNum) {
        this.couponNum = couponNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCouponContent() {
        return couponContent;
    }

    public void setCouponContent(String couponContent) {
        this.couponContent = couponContent;
    }

    public int getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(int couponValue) {
        this.couponValue = couponValue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCouponState() {
        return couponState;
    }

    public void setCouponState(String couponState) {
        this.couponState = couponState;
    }

    public String getCouponDeleted() {
        return couponDeleted;
    }

    public void setCouponDeleted(String couponDeleted) {
        this.couponDeleted = couponDeleted;
    }
}
