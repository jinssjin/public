package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mvc.database.DBConnection;

public class CouponDAO {

    private static CouponDAO instance = new CouponDAO();

    public static CouponDAO getInstance() {
        return instance;
    }

    private CouponDAO() {}

    // 유저가 보유 중이고 사용 가능한 쿠폰 조회
    public List<CouponDTO> getValidCouponsByUser(String userId) {
        List<CouponDTO> list = new ArrayList<>();

        String sql = "SELECT * FROM Coupon WHERE user_id = ? " +
                     "AND coupon_deleted = 'N' " +
                     "AND coupon_state = 'A' " +
                     "AND CURDATE() BETWEEN start_date AND end_date";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CouponDTO dto = new CouponDTO();
                dto.setCouponNum(rs.getInt("coupon_num"));
                dto.setUserId(rs.getString("user_id"));
                dto.setCoupontype(rs.getString("coupon_type"));
                dto.setCouponValue(rs.getInt("coupon_value"));
                dto.setStartDate(rs.getDate("start_date"));
                dto.setEndDate(rs.getDate("end_date"));
                dto.setCouponState(rs.getString("coupon_state"));
                dto.setCouponDeleted(rs.getString("coupon_deleted"));
                list.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
        public void updateExpiredCoupons() {
        String sql = "UPDATE coupon " +
                     "SET coupon_state = 'E' " + // E = 만료됨
                     "WHERE coupon_state = 'A' " +
                     "AND end_date < CURDATE()";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateExpiredCoupons() 에러: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public CouponDTO getCouponByNum(int couponNum) {
        String sql = "SELECT * FROM coupon WHERE coupon_num = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, couponNum);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                CouponDTO dto = new CouponDTO();
                dto.setCouponNum(rs.getInt("coupon_num"));
                dto.setUserId(rs.getString("user_id"));
                dto.setCoupontype(rs.getString("coupon_type"));
                dto.setCouponValue(rs.getInt("coupon_value"));
                dto.setStartDate(rs.getDate("start_date"));
                dto.setEndDate(rs.getDate("end_date"));
                dto.setCouponState(rs.getString("coupon_state"));
                dto.setCouponDeleted(rs.getString("coupon_deleted"));
                return dto;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCouponUsage(int couponNum, int usedAmount) {
        String selectSql = "SELECT coupon_type, coupon_value FROM coupon WHERE coupon_num = ?";
        String updateSql = "UPDATE coupon SET coupon_value = ?, coupon_state = ? WHERE coupon_num = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {

            selectStmt.setInt(1, couponNum);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String type = rs.getString("coupon_type");
                int currentValue = rs.getInt("coupon_value");

                if ("P".equals(type)) {
                    int newValue = currentValue - usedAmount;
                    String newState = (newValue <= 0) ? "E" : "A";

                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, Math.max(0, newValue)); // 음수 방지
                        updateStmt.setString(2, newState);
                        updateStmt.setInt(3, couponNum);
                        updateStmt.executeUpdate();
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("updateCouponUsage() 에러: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void processCouponAfterPayment(int couponNum, int usedAmount) {
        String selectSql = "SELECT coupon_type, coupon_value FROM coupon WHERE coupon_num = ?";
        String updateSql = "UPDATE coupon SET coupon_value = ?, coupon_state = ?, coupon_deleted = ? WHERE coupon_num = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {

            selectStmt.setInt(1, couponNum);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String type = rs.getString("coupon_type");
                int currentValue = rs.getInt("coupon_value");

                if ("D".equals(type)) {
                    // 가격 쿠폰은 그대로 만료 처리
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, 0);
                        updateStmt.setString(2, "E");
                        updateStmt.setString(3, "Y");
                        updateStmt.setInt(4, couponNum);
                        updateStmt.executeUpdate();
                    }

                } else if ("P".equals(type)) {
                    int remainingValue = currentValue - usedAmount;
                    boolean isDepleted = remainingValue <= 0;

                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, Math.max(0, remainingValue));
                        updateStmt.setString(2, isDepleted ? "E" : "A");
                        updateStmt.setString(3, isDepleted ? "Y" : "N");
                        updateStmt.setInt(4, couponNum);
                        updateStmt.executeUpdate();
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("processCouponAfterPayment() 에러: " + e.getMessage());
            e.printStackTrace();
        }
    }



}
