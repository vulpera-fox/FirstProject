package onlineBookStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OrdersDAO {
	Scanner scan = new Scanner(System.in);
	
	private String url = DBProperties.URL;
	private String uid = DBProperties.UID;
	private String upw = DBProperties.UPW;
	
	public OrdersDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
		}
	}
	
	public int /*void*/ selectLastOrderNumber(OrdersVO vo) { //젤마지막에 주문완료된 주문의 주문번호를 출력하는 메서드
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ORDERNUMBER FROM ORDERS WHERE ROWNUM = 1 ORDER BY ORDERNUMBER DESC";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("ordernumber");
				
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int /*void*/ insertOrders(OrdersVO vo) { //주문내역 테이블 값 입력하는 메서드
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
//		int PRICE ;
//		int B_COUNT;
//		int B_SUM = PRICE*B_COUNT;
		String sql = "INSERT INTO ORDERS(ORDERNUMBER,ORDERDATE,BOOKNAME,PRICE,B_COUNT,B_SUM,ADDERESS,PAY) VALUES(ORDERS_SEQ.NEXTVAL,SYSDATE,?,?,?,?,?,?)";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBookname());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getB_count());
			pstmt.setInt(4, vo.getB_sum());
			pstmt.setString(5, vo.getAdderess());
			pstmt.setString(6, vo.getPay());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		return result;
		
	}

}
