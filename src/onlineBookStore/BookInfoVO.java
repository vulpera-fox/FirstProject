package onlineBookStore;

public class BookInfoVO {
	
	private int book_id;
	private String book_name;
	private String book_price;
	private String book_writer;
	private int book_discount;
	private String book_category;
	private int book_count;
	
	public BookInfoVO() {
		
	}
	
	
	public BookInfoVO(int book_id, String book_name, String book_price, String book_writer, int book_discount,
			String book_category, int book_count) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_price = book_price;
		this.book_writer = book_writer;
		this.book_discount = book_discount;
		this.book_category = book_category;
		this.book_count = book_count;
	}


	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public String getBook_name() {
		return book_name;
	}


	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public String getBook_price() {
		return book_price;
	}


	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}


	public String getBook_writer() {
		return book_writer;
	}


	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}


	public int getBook_discount() {
		return book_discount;
	}


	public void setBook_discount(int book_discount) {
		this.book_discount = book_discount;
	}


	public String getBook_category() {
		return book_category;
	}


	public void setBook_category(String book_category) {
		this.book_category = book_category;
	}


	public int getBook_count() {
		return book_count;
	}


	public void setBook_count(int book_count) {
		this.book_count = book_count;
	}
	
	
	
	
	
	
	
}
