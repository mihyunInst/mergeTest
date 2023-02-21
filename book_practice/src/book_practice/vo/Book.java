package book_practice.vo;

public class Book {
	private int bNo;// 번호
	private String title;// 제목
	private String author;// 작가
	private int price;// 가격
	private String publisher;// 출판사
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bNo, String title, String author, int price, String publisher) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}


	public int getbNo() {
		return bNo;
	}


	public void setbNo(int bNo) {
		this.bNo = bNo;
	}


	public String gettitle() {
		return title;
	}


	public void settitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bNo=" + bNo + ", title=" + title + ", author=" + author + ", price=" + price + ", publisher="
				+ publisher + "]";
	}
	
	
}
