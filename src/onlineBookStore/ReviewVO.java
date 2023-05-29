package onlineBookStore;

public class ReviewVO {
	
	private String m_id;
	private String review;
	
	public ReviewVO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewVO(String m_id, String review) {
		super();
		this.m_id = m_id;
		this.review = review;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	

}
