package model;

public class LoginDTO {
	private int userNo;
	private String userId;
	private String password;
	private String userName;
	private String userClasses;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	
	public LoginDTO() {
		super();
	}
	
	public LoginDTO(int userNo, String userId, String password, String userName, String userClasses, String userEmail,
			String userPhone, String userAddress) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userClasses = userClasses;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserClasses() {
		return userClasses;
	}

	public void setUserClasses(String userClasses) {
		this.userClasses = userClasses;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
	
}
