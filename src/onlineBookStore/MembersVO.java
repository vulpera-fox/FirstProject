package onlineBookStore;

public class MembersVO {
	
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_birth;
	private String m_phone;
	private String m_email;
	private String m_address;
	private String m_grade;
	
	
	public MembersVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MembersVO(String m_id, String m_pw, String m_name, String m_birth, String m_phone, String m_email,
			String m_address, String m_grade) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_birth = m_birth;
		this.m_phone = m_phone;
		this.m_email = m_email;
		this.m_address = m_address;
		this.m_grade = m_grade;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public String getM_pw() {
		return m_pw;
	}


	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public String getM_birth() {
		return m_birth;
	}


	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}


	public String getM_phone() {
		return m_phone;
	}


	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}


	public String getM_email() {
		return m_email;
	}


	public void setM_email(String m_email) {
		this.m_email = m_email;
	}


	public String getM_address() {
		return m_address;
	}


	public void setM_address(String m_address) {
		this.m_address = m_address;
	}


	public String getM_grade() {
		return m_grade;
	}


	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}

}
