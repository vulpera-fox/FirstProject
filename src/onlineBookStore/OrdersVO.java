package onlineBookStore;

public class OrdersVO {
	
	private int ordernumber;
	private String orderdate;
	private String bookname;
	private int price;
	private int b_count;
	private int b_sum;
	private String adderess;
	private String pay;
	
	public OrdersVO() {
		
	}


	public OrdersVO(int ordernumber, String orderdate, String bookname, int price, int b_count, int b_sum,
			String adderess, String pay) {
		super();
		this.ordernumber = ordernumber;
		this.orderdate = orderdate;
		this.bookname = bookname;
		this.price = price;
		this.b_count = b_count;
		this.b_sum = b_sum;
		this.adderess = adderess;
		this.pay = pay;
		
	}







	public int getOrdernumber() {
		return ordernumber;
	}







	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}







	public String getOrderdate() {
		return orderdate;
	}







	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}







	public String getBookname() {
		return bookname;
	}







	public void setBookname(String bookname) {
		this.bookname = bookname;
	}







	public int getPrice() {
		return price;
	}







	public void setPrice(int price) {
		this.price = price;
	}







	public int getB_count() {
		return b_count;
	}







	public void setB_count(int b_count) {
		this.b_count = b_count;
	}







	public int getB_sum() {
		return b_sum;
	}







	public void setB_sum(int b_sum) {
		this.b_sum = b_sum;
	}







	public String getAdderess() {
		return adderess;
	}







	public void setAdderess(String adderess) {
		this.adderess = adderess;
	}







	public String getPay() {
		return pay;
	}







	public void setPay(String pay) {
		this.pay = pay;
	}


	@Override
	public String toString() {
		return "OrdersVO [ordernumber=" + ordernumber + ", orderdate=" + orderdate + ", bookname=" + bookname
				+ ", price=" + price + ", b_count=" + b_count + ", b_sum=" + b_sum + ", adderess=" + adderess + ", pay="
				+ pay + "]";
	}

	

	



		
}
