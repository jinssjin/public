package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import connect.BoardConnect;
import model.BoardDTO;

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
    private BoardDAO() {}

    public static BoardDAO getInstance() {
        return instance;
    }

  //board 테이블의 레코드 개수
    public int getListCount(String items, String text) {
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;

       int x = 0;

       String sql;
       
       if (items == null && text == null)
          sql = "select count(*) from board where valid='Y'";
       else
          sql = "SELECT count(*) FROM board where valid='Y' AND " + items + " like '%" + text + "%'";
       
       try {
          conn = BoardConnect.getConnection();
          pstmt = conn.prepareStatement(sql);
          rs = pstmt.executeQuery();

          if (rs.next()) 
             x = rs.getInt(1);
          
       } catch (Exception ex) {
          System.out.println("getListCount()     : " + ex);
       } finally {         
          try {            
             if (rs != null) 
                rs.close();                     
             if (pstmt != null) 
                pstmt.close();            
             if (conn != null) 
                conn.close();                                    
          } catch (Exception ex) {
             throw new RuntimeException(ex.getMessage());
          }      
       }      
       return x;
    }
    // 
    public ArrayList<BoardDTO> getBoardList(int page, int limit, String items, String text) {
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;

       int total_record = getListCount(items, text );
       int start = (page - 1) * limit;
       int index = start + 1;

       String sql;

       if (items == null && text == null)
          sql = "select * from board ORDER BY num DESC WHERE valid='Y'";
       else
          sql = "SELECT  * FROM board where valid='Y' AND " + items + " like '%" + text + "%' ORDER BY num DESC ";

       ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
    
       try {
          conn = BoardConnect.getConnection();
          
          
          pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
          rs = pstmt.executeQuery();
          
          while (rs.absolute(index)) {
             BoardDTO board = new BoardDTO();
             board.setBoardNo(rs.getInt("board_no"));
             board.setBoardTitle(rs.getString("board_title"));
             board.setBoardContent(rs.getString("board_content"));
             board.setBoardWriter(rs.getString("board_writer"));
             board.setBoardDate(rs.getString("board_date"));
             board.setValid(rs.getString("valid"));
                          
             list.add(board);
             
             if (index < (start + limit) && index <= total_record)
                index++;
             else
                break;
          }
          return list;
       } catch (Exception ex) {
          System.out.println("getBoardList()      : " + ex);
       } finally {
          try {
             if (rs != null) 
                rs.close();                     
             if (pstmt != null) 
                pstmt.close();            
             if (conn != null) 
                conn.close();
          } catch (Exception ex) {
             throw new RuntimeException(ex.getMessage());
          }         
       }
       return null;
    }

    public String getLoginNameById(String id) {
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;   

       String name=null;
       String sql = "select * from login where user_id = ? ";

       try {
          conn = BoardConnect.getConnection();
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, id);
          rs = pstmt.executeQuery();

          if (rs.next()) 
             name = rs.getString("user_name");   
          
          return name;
          
       } catch (Exception ex) {
          System.out.println("getBoardByNum()      : " + ex);
       } finally {
          try {            
             if (rs != null) 
                rs.close();                     
             if (pstmt != null) 
                pstmt.close();            
             if (conn != null) 
                conn.close();
          } catch (Exception ex) {
             throw new RuntimeException(ex.getMessage());
          }      
       }
       return null;
    }

    
    public void insertBoard(BoardDTO board)  {
       
       Connection conn = null;
       PreparedStatement pstmt = null;
       try {
          conn = BoardConnect.getConnection();      

          String sql = "INSERT INTO board (board_title, board_content, board_writer, board_date, valid) VALUES (?, ?, ?, CURRENT_DATE, ?)";
       
          pstmt = conn.prepareStatement(sql);
          
          pstmt.setString(1, board.getBoardTitle());
          pstmt.setString(2, board.getBoardContent());
          pstmt.setString(3, board.getBoardWriter());
          pstmt.setString(4, "Y");          

          pstmt.executeUpdate();
       } catch (Exception ex) {
          System.out.println("insertBoard()      : " + ex);
       } finally {
          try {                           
             if (pstmt != null) 
                pstmt.close();            
             if (conn != null) 
                conn.close();
          } catch (Exception ex) {
             throw new RuntimeException(ex.getMessage());
          }      
       }      
    } 
    
    public BoardDTO getBoardByNo(int num) {
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       BoardDTO board = null;
       
       String sql = "select * from board where board_no = ? AND valid='Y'";

       try {
          conn = BoardConnect.getConnection();
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, num);
          rs = pstmt.executeQuery();

          if (rs.next()) {
        	  board = new BoardDTO();
        	  board.setBoardNo(rs.getInt("board_no"));
              board.setBoardTitle(rs.getString("board_title"));
              board.setBoardContent(rs.getString("board_content"));
              board.setBoardWriter(rs.getString("board_writer"));
              board.setBoardDate(rs.getString("board_date"));
              board.setValid(rs.getString("valid"));
          }
          
          return board;
       } catch (Exception ex) {
          System.out.println("getBoardByNum()      : " + ex);
       } finally {
          try {
             if (rs != null) 
                rs.close();                     
             if (pstmt != null) 
                pstmt.close();            
             if (conn != null) 
                conn.close();
          } catch (Exception ex) {
             throw new RuntimeException(ex.getMessage());
          }      
       }
       return null;
    }
    
    
    public boolean updateBoard(BoardDTO board) {

       Connection conn = null;
       PreparedStatement pstmt = null;
    
       try {
          String sql = "update board set board_title=?, board_content=? where board_no=?";

          conn = BoardConnect.getConnection();
          pstmt = conn.prepareStatement(sql);
          
          pstmt.setString(1, board.getBoardTitle());
          pstmt.setString(2, board.getBoardContent());
          pstmt.setInt(3, board.getBoardNo());

          int rows = pstmt.executeUpdate();
          
          System.out.println("updateBoard()      : " + rows + " rows updated");
          return rows > 0;

       } catch (Exception ex) {
          System.out.println("updateBoard()      : " + ex);
          return false; 
       } finally {
          try {                              
             if (pstmt != null) 
                pstmt.close();            
             if (conn != null) 
                conn.close();
          } catch (Exception ex) {
             throw new RuntimeException(ex.getMessage());
          }      
       }
    } 
    
    public ArrayList<BoardDTO> getBoardList(int page, int limit, String items, String text, String sort) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int start = (page - 1) * limit;
        ArrayList<BoardDTO> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM board WHERE valid='Y' ");

        if (items != null && text != null && !items.isEmpty() && !text.isEmpty()) {
            sql.append("AND ").append(items).append(" LIKE ? ");
        }

        if (sort == null || sort.isEmpty()) {
            sql.append("ORDER BY board_no DESC ");
        } else {
            sql.append("ORDER BY ").append(sort).append(" ");
        }

        sql.append("LIMIT ?, ?");

        try {
            conn = BoardConnect.getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            int paramIndex = 1;
            if (sql.toString().contains("LIKE")) {
                pstmt.setString(paramIndex++, "%" + text + "%");
            }
            pstmt.setInt(paramIndex++, start);
            pstmt.setInt(paramIndex, limit);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDTO board = new BoardDTO();
                board.setBoardNo(rs.getInt("board_no"));
                board.setBoardTitle(rs.getString("board_title"));
                board.setBoardContent(rs.getString("board_content"));
                board.setBoardWriter(rs.getString("board_writer"));
                board.setBoardDate(rs.getString("board_date"));
                board.setValid(rs.getString("valid"));

                list.add(board);
            }

        } catch (Exception ex) {
            System.out.println("getBoardList() : " + ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }

        return list;
    }
    
    public boolean deleteBoard(int boardNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "update board set valid='N' WHERE board_no = ?";
            conn = BoardConnect.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, boardNo);
            int rows = pstmt.executeUpdate();
            System.out.println("deleteBoard()      : " + rows + " rows deleted");
            return rows > 0;

        } catch (Exception ex) {
            System.out.println("deleteBoard()      : " + ex);
            return false;
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
