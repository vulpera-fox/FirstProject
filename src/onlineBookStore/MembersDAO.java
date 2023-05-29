package onlineBookStore;
import java.util.*;
import java.sql.*;

public class MembersDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("Class for Name Error");
		}
	}

	MembersVO membersvo = new MembersVO();


	private String url = DBProperties.URL;
	private String uid = DBProperties.UID;
	private String upw = DBProperties.UPW;


	public MembersDAO() {
		// TODO Auto-generated constructor stub
	}


	public List<MembersVO> getMembers(String id){
		List<MembersVO> list = new ArrayList<>();

		String sql = "SELECT * FROM MEMBERS WHERE M_ID = ?";
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
				String m_pw = rs.getString("M_PW");
				String m_name = rs.getString("M_NAME");
				String m_birth = rs.getString("M_BIRTH");
				String m_phone = rs.getString("M_PHONE");
				String m_email = rs.getString("M_EMAIL");
				String m_address = rs.getString("M_ADDRESS");
				String m_grade = rs.getString("M_GRADE");
				MembersVO vo = new MembersVO(m_id, m_pw, m_name, m_birth, m_phone, m_email, m_address, m_grade);
				list.add(vo);
			} else {
				System.out.println("조회할 데이터가 없습니다");
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


	public void insertMembers() {
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = DriverManager.getConnection(url,uid,upw);
			conn.setAutoCommit(false);
			String selectSql = "SELECT * FROM MEMBERS WHERE M_ID = ?";
			pstmt = conn.prepareStatement(selectSql);
			System.out.print("아이디를 입력하세요>");
			String id = sc.next();

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("이미 등록된 아이디입니다.");
			} else {
				pstmt.close();
				String insertSql = "INSERT INTO MEMBERS VALUES(?,?,?,?,?,?,?,'브론즈')";
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setString(1, id);
				System.out.print("비밀번호를 입력하세요>");
				String pw = sc.next();
				pstmt.setString(2, pw);
				System.out.print("이름을 입력하세요>");
				String name = sc.next();
				pstmt.setString(3, name);
				System.out.print("생일을 입력하세요>");
				String birth = sc.next();
				pstmt.setString(4, birth);
				System.out.print("전화번호를 입력하세요>");
				String phone = sc.next();
				pstmt.setString(5, phone);
				System.out.print("이메일을 입력하세요>");
				String email = sc.next();
				pstmt.setString(6, email);
				System.out.print("주소를 입력하세요>");
				String address = sc.next();
				pstmt.setString(7, address);
				pstmt.executeUpdate();
			}
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
