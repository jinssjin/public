package mvc.model; // DAO 클래스가 위치한 패키지

import java.sql.Connection; // DB 연결용 클래스
import java.sql.PreparedStatement; // SQL 실행용 클래스
import java.sql.ResultSet; // SQL 결과 처리용 클래스
import java.sql.Timestamp;
import java.util.ArrayList; // 리스트 자료구조

import mvc.database.DBConnection; // 사용자 정의 DB 연결 클래스

public class PaymentDAO {
	
	private static PaymentDAO instance; // 싱글톤 인스턴스

    private PaymentDAO() {
        // 외부에서 생성자 호출 방지
    }

    // 싱글톤 인스턴스 반환 메서드
    public static PaymentDAO getInstance() {
        if (instance == null)
            instance = new PaymentDAO();
        return instance;
    }

    public int insertPayment(PaymentDTO dto) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO Payment (user_id, name, phone, price, state, reservation_date, end_date, deleted) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getUserId());
            pstmt.setString(2, dto.getName());
            pstmt.setString(3, dto.getPhone());
            pstmt.setInt(4, dto.getPrice());
            pstmt.setString(5, dto.getState());
            pstmt.setString(6, dto.getReservationDate());
            pstmt.setString(7, dto.getEndDate());
            pstmt.setString(8, dto.getDeleted());

            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	DBConnection.close(conn, pstmt);
        }

        return result;
    }
}
