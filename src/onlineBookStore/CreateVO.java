package onlineBookStore;



public class CreateVO {
	
	private String name;
	private String id;
	private String pw;
	private String birth;
	private String phone;
	private String email;
	private String address;
	
	//생성자
	public CreateVO() {
	}
	public CreateVO(String name, String id, String pw, String birth, String phone, String email, String address) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	//getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
