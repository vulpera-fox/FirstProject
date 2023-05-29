package onlineBookStore;
import java.util.*;
import java.sql.*;
public class ReviewDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("Class for Name Error");
		}
	}
	
	ReviewVO reviewvo = new ReviewVO();
	
	private String url = DBProperties.URL;
	private String uid = DBProperties.UID;
	private String upw = DBProperties.UPW;
	
	
	public ReviewDAO() {
	}
	
	public List<ReviewVO> getReview(String id){
		List<ReviewVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM REVIEW WHERE M_ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String m_id = rs.getString("M_ID");
				String r_info = rs.getString("R_INFO");
				ReviewVO vo = new ReviewVO(m_id,r_info);
				list.add(vo);
			} else {
				System.out.println("작성하신 리뷰가 없습니다.");
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
	
	
	
	public void insertReview() {
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println("리뷰를 입력해주세요");
		String review = sc.nextLine();
		
		try {
			
			conn = DriverManager.getConnection(url,uid,upw);
			conn.setAutoCommit(false);
			String insertSql = "INSERT INTO REVIEW VALUES(?,?)";
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, "b");
			pstmt.setString(2, review);
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if(conn!=null) {
				try {
					conn.rollback();
				} catch (Exception e2) {
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
