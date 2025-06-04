package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.BoardConnect;

public class LoginDAO {
	    private static LoginDAO instance = new LoginDAO();
	    private LoginDAO() {}

	    public static LoginDAO getInstance() {
	        return instance;
	    }

	    // 로그인 체크 메서드
	    public boolean loginCheck(LoginDTO dto) {
	        boolean result = false; // 디폴트값 로그인 실패
	        String sql = "SELECT * FROM login WHERE user_id = ? AND password = ? AND valid = 'Y'";

	        try (Connection conn = BoardConnect.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, dto.getUserId());
	            pstmt.setString(2, dto.getPassword());

	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    result = true;  // 로그인 성공
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
	    
	    public boolean createId(LoginDTO dto) {
	        String sql = "INSERT INTO login (user_id, password, user_name, user_email, user_phone, user_address) VALUES (?, ?, ?, ?, ?, ?)";
	        boolean result = false;
	               
	        try (Connection conn = BoardConnect.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	       	
	            pstmt.setString(1, dto.getUserId());
	            pstmt.setString(2, dto.getPassword());
	            pstmt.setString(3, dto.getUserName());
	            pstmt.setString(4, dto.getUserEmail());
	            pstmt.setString(5, dto.getUserPhone());
	            pstmt.setString(6, dto.getUserAddress());


	            int rows = pstmt.executeUpdate();
	            result = (rows > 0);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }

	    
	    
	    public LoginDTO getUserById(String id) {
	    	LoginDTO dto = null;
	        String sql = "SELECT * FROM login WHERE user_id = ?";

	        try (Connection conn = BoardConnect.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, id);

	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    dto = new LoginDTO();
	                    dto.setUserId(rs.getString("user_id"));
	                    dto.setPassword(rs.getString("password"));
	                    dto.setUserName(rs.getString("user_name"));
	                    dto.setUserEmail(rs.getString("user_email"));
	                    dto.setUserPhone(rs.getString("user_phone"));
	                    dto.setUserAddress(rs.getString("user_adress"));
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return dto;
	    }
	    
	    public boolean updateUser(LoginDTO dto) {
	        String sql = "UPDATE login SET user_name = ?, user_email = ?, user_phone = ?, user_address = ? WHERE user_id = ?";
	        boolean result = false;

	        try (Connection conn = BoardConnect.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, dto.getUserName());
	            pstmt.setString(2, dto.getUserEmail());
	            pstmt.setString(3, dto.getUserPhone());
	            pstmt.setString(4, dto.getUserAddress());
	            pstmt.setString(5, dto.getUserId());

	            int rows = pstmt.executeUpdate();
	            result = (rows > 0); // 1건 이상 업데이트 되면 성공

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }

	    public boolean deleteUserById(String userId){
	        String sql = "UPDATE login SET valid = 'N' WHERE user_id = ?";
	        boolean result = false;

	        try (Connection conn = BoardConnect.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	                        
	            pstmt.setString(1, userId);

	            int rows = pstmt.executeUpdate();
	            result = (rows > 0); // 1건 이상 업데이트 되면 성공

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
}
