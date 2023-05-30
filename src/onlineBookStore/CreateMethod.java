package onlineBookStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import login.DBProperties;

public class CreateMethod {
	
	public int IdOverlap(String id) {
		String url = DBProperties.URL;
		String uid = DBProperties.UID;
		String upw = DBProperties.UPW;
		
		String sql = "SELECT * FROM MEMBERS WHERE M_ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;

		try  {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt =  conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;
			} else {
				check = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return check;
	}
}
