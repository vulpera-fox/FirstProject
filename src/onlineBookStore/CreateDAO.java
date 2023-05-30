package onlineBookStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CreateDAO {
	//멤버변수
		private String url = DBProperties.URL;
		private String uid = DBProperties.UID;
		private String upw = DBProperties.UPW;
		
		//생성자
		public CreateDAO() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (Exception e) {
				System.out.println("CLASS FOR NAME ERR");
			}
		}
		
		
		public int insertCreate(CreateVO vo) {
			
			int result = 0; //0이 반환되면 실패, 1이 반환되면 성공

			Connection conn = null;
			PreparedStatement pstmt = null;

			String sql = "INSERT INTO MEMBERS VALUES(?, ?, ?, ?, ?, ?, ?, '프렌즈')";

			try {

				//2. conn
				conn = DriverManager.getConnection(url, uid, upw);

				//3. pstmt
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPw()); 
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getBirth());
				pstmt.setString(5, vo.getPhone());
				pstmt.setString(6, vo.getEmail());
				pstmt.setString(7, vo.getAddress());

				//4. sql실행
				result = pstmt.executeUpdate(); //성공시 1반환, 실패시 0반환

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {}
			}

			return result;
		}
}
