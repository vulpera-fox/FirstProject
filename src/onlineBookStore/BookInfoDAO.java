package onlineBookStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookInfoDAO {
	
	private String url = DBProperties.URL;
	private String uid = DBProperties.UID;
	private String upw = DBProperties.UPW;
	
	public BookInfoDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch(Exception e) {
			System.out.println("Check Class.forName()");
		}
	}
	
	
	public List<BookInfoVO> getBookInfo(String name){
		List<BookInfoVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM BOOK_INFO WHERE BOOK_NAME = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String book_name = rs.getString("book_name");
				String book_price = rs.getString("book_price");
				String book_writer = rs.getString("book_writer");
				int book_discount = rs.getInt("book_discount");
				String book_category = rs.getString("book_category");
				int book_count = rs.getInt("book_count");
				BookInfoVO vo = new BookInfoVO(book_id,book_name,book_price,book_writer,book_discount,book_category,book_count);
				list.add(vo);
				lowerCount(book_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<BookInfoVO> getByCategory(String category){
		List<BookInfoVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM BOOK_INFO WHERE BOOK_CATEGORY IN ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String book_name = rs.getString("book_name");
				String book_price = rs.getString("book_price");
				String book_writer = rs.getString("book_writer");
				int book_discount = rs.getInt("book_discount");
				String book_category = rs.getString("book_category");
				int book_count = rs.getInt("book_count");
				BookInfoVO vo = new BookInfoVO(book_id,book_name,book_price,book_writer,book_discount,book_category,book_count);
				list.add(vo);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	public void lowerCount(int book_id) {
		
		String sql = "UPDATE BOOK_INFO SET BOOK_COUNT = BOOK_COUNT - 1 WHERE BOOK_ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
	}
	
	

}
