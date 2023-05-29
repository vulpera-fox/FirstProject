package onlineBookStore;

import java.sql.*;
import java.util.*;

public class CartDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	CartVO cartvo = new CartVO();
	CartFrame cf = new CartFrame();

	
	private String url = DBProperties.URL;
	private String uid = DBProperties.UID;
	private String upw = DBProperties.UPW;
	

	public CartDAO(){

	}


	public List<CartVO> getCart(String mem_id){
		List<CartVO> list = new ArrayList<>();

		String sql = "SELECT * FROM CART WHERE M_ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int cart_id = rs.getInt("CART_ID");
				String p_name = rs.getString("P_NAME");
				int p_count = rs.getInt("P_COUNT");
				String m_id = rs.getString("M_ID");
				int book_id = rs.getInt("BOOK_ID");
				CartVO vo = new CartVO(cart_id,p_name,p_count,m_id,book_id);
				list.add(vo);
			}

		} catch (SQLException e) {
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



	public void insertCart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름입력>");
		String pname = sc.nextLine();
		String login = "B";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			conn.setAutoCommit(false);
			String selectSql = "SELECT * FROM CART WHERE P_NAME = ?";
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setString(1, pname);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				pstmt.close();
				String updateSql = "UPDATE CART SET P_COUNT = P_COUNT + 1 WHERE P_NAME = ?";
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, pname);
				pstmt.executeUpdate();
			} else {
				pstmt.close();
				String insertSql = "INSERT INTO CART VALUES (CART_SEQ.NEXTVAL, ? , 1 , ? , \n"
						+ "(SELECT BOOK_ID FROM BOOK_INFO WHERE BOOK_NAME = ?))";
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setString(1, pname);
				pstmt.setString(2, login);
				pstmt.setString(3, pname);
				pstmt.executeUpdate();
			}

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (conn!=null) {
				try {
					// 중복방지용 롤백
					conn.rollback();
					System.out.println("롤백");
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} finally {
			try {
				conn.setAutoCommit(true);
				conn.close();
				pstmt.close();
				sc.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}


}
