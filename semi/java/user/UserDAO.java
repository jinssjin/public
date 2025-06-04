package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//ctrl + shift + o  자동으로 import
public class UserDAO {
   
   private Connection conn; //자바와 데이터베이스를 연결
   private PreparedStatement pstmt; //쿼리문 대기및 설정
   private ResultSet rs; //결과 값 받아오기
   
   public UserDAO() {
      try {
			// String jdbc_url = "jdbc:mysql://localhost:3306/database?serverTimezone=UTC";  // database = db명
			// Connection con = DriverManager.getConnection(URL, "user', "password");
         String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
         String dbID = "root";
         String dbPassword = "1234";
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
//   로그인 구현 메소드
   public int login(String userID, String userPassword) {
   String sql = "select userPassword from user where userID = ?";
      try { pstmt = conn.prepareStatement(sql); //sql 쿼리문을 대기
          pstmt.setString(1, userID); // 첫번째 '?'에 매개변수로 받아온 'userID'대입
          rs=pstmt.executeQuery(); //쿼리실행후 rs 에 저장
          if(rs.next()) {
             if(rs.getString(1).equals(userPassword)) {
                return 1;//로그인 성공
             }else {
                return 0; //비밀번호 틀림
             }
          }
          return -1; //아이디 없음
      }catch(Exception e) {
         e.printStackTrace();
      }
      return -2;//오류
   } 
   
   public int join(User user) {
	   String SQL = "insert into user values (?,?,?,?,?)";
	   try {
		   pstmt = conn.prepareStatement(SQL);
		   pstmt.setString(1,user.getUserID());
		   pstmt.setString(2,user.getUserPassword());
		   pstmt.setString(3,user.getUserName());
		   pstmt.setString(4,user.getUserGender());
		   pstmt.setString(5,user.getUserEmail());
		   return pstmt.executeUpdate();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return -1;  // 데이터베이스 오류
   }
   
   
}
