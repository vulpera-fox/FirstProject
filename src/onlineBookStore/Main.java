package onlineBookStore;

import java.util.*;


public class Main {

	public static void main(String[] args) {

//		BookInfoDAO bi = new BookInfoDAO();
		CartDAO ci = new CartDAO();
		MembersDAO mi = new MembersDAO();
		ReviewDAO ri = new ReviewDAO();

		Scanner sc = new Scanner(System.in);

		System.out.print("메뉴>");
		
		int menu = sc.nextInt();
		
		
		switch (menu) {
		case 1:
//			System.out.print("책이름>");
//			String book_name = sc.next();
//			
//			for(BookInfoVO i : bi.getBookInfo(book_name)) {
//				String name = i.getBook_name();
//				int price = Integer.parseInt(i.getBook_price());
//				long d_price = Math.round(price - (price * 0.01 * i.getBook_discount()));
//				String writer = i.getBook_writer();
//				String category = i.getBook_category();
//				
//				System.out.println("책 이름 : " + name);
//				System.out.println("가격 : " + d_price);
//				System.out.println("글쓴이 : " + writer);
//				System.out.println("카테고리 : " + category);
//				System.out.println(i.getBook_count());
//			}
			
			break;
		case 2:
//			System.out.print("카테고리>");
//			String book_category = sc.next();
//			for(BookInfoVO i : bi.getByCategory(book_category)) {
//				String name = i.getBook_name();
//				int price = Integer.parseInt(i.getBook_price());
//				long d_price = Math.round(price - (price * 0.01 * i.getBook_discount()));
//				String writer = i.getBook_writer();
//				String category = i.getBook_category();
//				
//				System.out.println("책 이름 : " + name);
//				System.out.println("가격 : " + d_price);
//				System.out.println("글쓴이 : " + writer);
//				System.out.println("카테고리 : " + category);
//				System.out.println("================================");
//			}
			
			break;
		case 3:
			System.out.println("카트");
			ci.insertCart();
			
			break;
		case 4:
			System.out.println("조회");
			String b = sc.next();
			for(CartVO i : ci.getCart(b)) {
				System.out.println(i.getP_name());
				System.out.println(i.getM_id());
				System.out.println(i.getP_count());
				
			}
		case 5:
			System.out.println("조회할 아이디를 입력하세요");
			String m_id = sc.next();
			
			for (MembersVO i : mi.getMembers(m_id)) {
				System.out.println(i.getM_name());
				System.out.println(i.getM_id());
				System.out.println(i.getM_grade());
			}
			
		case 6:
			System.out.println("추가할 아이디를 입력하세요");
			mi.insertMembers();
			
		case 7:
			System.out.println("리뷰입력");
			ri.insertReview();
			
			
		default:
			break;
		}
		
		



		
		
		
		



	}

}
