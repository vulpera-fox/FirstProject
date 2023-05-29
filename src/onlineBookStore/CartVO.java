package onlineBookStore;

public class CartVO {
	
	private int cart_id;
	private String p_name;
	private int p_count;
	private String m_id;
	private int book_id;
	
	public CartVO() {
	}

	public CartVO(int cart_id, String p_name, int p_count, String m_id, int book_id) {
		super();
		this.cart_id = cart_id;
		this.p_name = p_name;
		this.p_count = p_count;
		this.m_id = m_id;
		this.book_id = book_id;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	
	
	
	

}
