package mvc.model; // DAO 클래스가 위치한 패키지

import java.sql.Connection; // DB 연결용 클래스
import java.sql.PreparedStatement; // SQL 실행용 클래스
import java.sql.ResultSet; // SQL 결과 처리용 클래스
import java.sql.Timestamp;
import java.util.ArrayList; // 리스트 자료구조

import mvc.database.DBConnection; // 사용자 정의 DB 연결 클래스

public class ReservationDAO{

    private static ReservationDAO instance; // 싱글톤 인스턴스

    private ReservationDAO() {
        // 외부에서 생성자 호출 방지
    }

    // 싱글톤 인스턴스 반환 메서드
    public static ReservationDAO getInstance() {
        if (instance == null)
            instance = new ReservationDAO();
        return instance;
    }

    // 전체 게시글 수 반환 (검색 조건 고려)
    public int getListCount(String searchField, String searchText, String sessionId) {
        int x = 0;
        String sql = "SELECT COUNT(*) FROM reservations WHERE user_id = ?";

        if (searchField != null && searchText != null && !searchText.trim().isEmpty()) {
            sql += " AND " + searchField + " LIKE ?";
        }

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, sessionId);
            
            if (searchField != null && searchText != null && !searchText.trim().isEmpty()) {
                pstmt.setString(2, "%" + searchText + "%");
            }

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                x = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return x;
    }


    // 게시글 목록 반환 (페이지네이션 + 검색 조건)
    public ArrayList<ReservationDTO> getReservationList(int page, int limit, String items, String text, String sessionId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int start = (page - 1) * limit;
        String sql;

        if (items == null || text == null || items.isEmpty() || text.isEmpty()) {
            sql = "SELECT * FROM payment WHERE user_id = ? ORDER BY payment_id DESC LIMIT ?, ?";
        } else {
            sql = "SELECT * FROM payment WHERE user_id = ? AND " + items + " LIKE ? ORDER BY payment_id DESC LIMIT ?, ?";
        }

        ArrayList<ReservationDTO> reservationlist = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, sessionId);

            if (items != null && text != null && !items.isEmpty() && !text.isEmpty()) {
                pstmt.setString(2, "%" + text + "%");
                pstmt.setInt(3, start);
                pstmt.setInt(4, limit);
            } else {
                pstmt.setInt(2, start);
                pstmt.setInt(3, limit);
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                ReservationDTO reservation = new ReservationDTO();
                reservation.setPost_num(rs.getInt("payment_id"));
                reservation.setUser_id(rs.getString("user_id"));
                reservation.setTitle(rs.getString("name"));
                reservation.setContent(rs.getString("phone"));
                reservation.setCategory(rs.getString("price"));
                reservation.setTag(rs.getString("state"));
                reservation.setReservation_date(rs.getString("reservation_date"));
                reservation.setEnd_date(rs.getString("end_date"));
                reservation.setDeleted(rs.getString("deleted"));
                reservationlist.add(reservation);
            }
            return reservationlist;
        } catch (Exception ex) {
            System.out.println("getReservationList() : " + ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
        return null;
    }


    // 특정 ID의 사용자 이름 조회
    public String getLoginNameById(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String name = null;

        String sql = "SELECT * FROM user WHERE user_id = ?";

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next())
                name = rs.getString("name");

            return name;
        } catch (Exception ex) {
            System.out.println("getLoginNameById() : " + ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
        return null;
    }

    // 게시글 가져오기
    public void insertpayment(ReservationDTO payment) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO post (user_id, title, content, category, tag, created_date, end_date, reservation_date, location, people, price, thumbnail, images, deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, payment.getUser_id());
            pstmt.setString(2, payment.getTitle());
            pstmt.setString(3, payment.getContent());
            pstmt.setString(4, payment.getCategory());
            pstmt.setString(5, payment.getTag());
            pstmt.setString(6, payment.getCreated_date());
            pstmt.setString(7, payment.getEnd_date()); // 수정된 부분
            pstmt.setString(8, payment.getReservation_date()); // 수정된 부분
            pstmt.setString(9, payment.getLocation());
            pstmt.setInt(10, payment.getPeople());
            pstmt.setInt(11, payment.getPrice());
            pstmt.setString(12, payment.getThumbnail());
            pstmt.setString(13, payment.getImages());
            pstmt.setString(14, payment.getDeleted());

            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("insertPayment() : " + ex);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    // 게시글 번호로 상세 조회
    public PaymentDTO getPaymentByNum(int Payment_id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ReservationDTO payment = null;

        String sql = "SELECT * FROM post WHERE post_num = ?";

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post_num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	payment = new ReservationDTO();
            	payment.setPost_num(rs.getInt("post_num"));
            	payment.setUser_id(rs.getString("user_id"));
            	payment.setTitle(rs.getString("title"));
            	payment.setContent(rs.getString("content"));
            	payment.setCategory(rs.getString("category"));
            	payment.setTag(rs.getString("tag"));
            	payment.setCreated_date(rs.getString("created_date"));
            	payment.setEnd_date(rs.getString("end_date"));
            	payment.setReservation_date(rs.getString("reservation_date"));
            	payment.setLocation(rs.getString("location"));
            	payment.setPeople(rs.getInt("people"));
            	payment.setPrice(rs.getInt("price"));
            	payment.setThumbnail(rs.getString("thumbnail"));
            	payment.setImages(rs.getString("images"));
            	payment.setDeleted(rs.getString("deleted"));
            }
            return payment;
        } catch (Exception ex) {
            System.out.println("getPaymentByNum() : " + ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
        return null;
    }

    
 // 게시글 수정
    public void updatepayment(ReservationDTO payment) {
        String sql = "UPDATE post SET user_id = ?, title = ?, content = ?, category = ?, tag = ?, " +
                     "updated_date = ?, reservation_date = ?, end_date = ?, location = ?, people = ?, price = ?, " +
                     "thumbnail = ?, images = ?, deleted = ? " +  
                     "WHERE post_num = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, payment.getUser_id()); // 올바르게 설정된 user_id 사용
            pstmt.setString(2, payment.getTitle());
            pstmt.setString(3, payment.getContent());
            pstmt.setString(4, payment.getCategory());
            pstmt.setString(5, payment.getTag());

            pstmt.setString(6, payment.getCreated_date()); 
            pstmt.setString(7, payment.getReservation_date());
            pstmt.setString(8, payment.getEnd_date());
            pstmt.setString(9, payment.getLocation());
            pstmt.setInt(10, payment.getPeople());
            pstmt.setInt(11, payment.getPrice());
            pstmt.setString(12, payment.getThumbnail());
            pstmt.setString(13, payment.getImages());
            pstmt.setString(14, payment.getDeleted());
            pstmt.setInt(15, payment.getPost_num());

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("updatePayment() 에러: " + e.getMessage());
            e.printStackTrace();
        }
    }





    // 게시글 삭제
    public void deletepayment(int post_num) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM post WHERE post_num = ?";

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post_num);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("deletepayment() : " + ex);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
    }  

}
