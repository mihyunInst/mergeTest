package book_practice.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import book_practice.vo.Book;

public class BookService {
	
	private Scanner sc = new Scanner(System.in);
	
	List<Map<String, Object>> bookList = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> favorite = new ArrayList<Map<String, Object>>();
	//Set<Map<String, Object>> test = new TreeSet<Map<String, Object>>();
	
	/*
	 * 북넘버 : 1
	 * 작가 : 히가시노게이고
	 * 제목 : 동급생
	 * 가격 : 13000
	 * 출판사 : 재인
	 * 
	 * */
	
	public BookService() {
		Map<String, Object> map1 = new HashMap<>() {{
		    put("bNo", 1);
		    put("title", "용의자 X의 헌신");
		    put("author", "히가시노 게이고");
		    put("price", 13000);
		    put("publisher", "재인");
		}};
		
		Map<String, Object> map2 = new HashMap<>() {{
		    put("bNo", 2);
		    put("title", "만일 내가 인생을 다시 산다면");
		    put("author", "김혜남");
		    put("price", 15480);
		    put("publisher", "메이븐");
		}};
		
		bookList.add(map1);
		bookList.add(map2);
		
		/*
		new Book(2, "만일 내가 인생을 다시 산다면", "김혜남", 15480, "메이븐");
		new Book(3, "트렌드 코리아 2023", "김난도", 17100, "미래의창");
		new Book(4, "아버지의 해방일지", "정지아", 13500, "창비");
		new Book(5, "나미야 잡화점의 기적", "히가시노 게이고", 13320, "현대문학");
		*/
	}
	
	public void displayMenu() {
		
		int sel = 0;
		do {
			
			System.out.println("=== 도서 목록 관리 프로그램 ===");
			System.out.println("1. 도서 조회");
			System.out.println("2. 도서 등록");
			System.out.println("3. 도서 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 즐겨찾기 등록");
			System.out.println("6. 즐겨찾기 목록 조회(+출력)");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 >> ");
			sel = sc.nextInt();
			sc.nextLine();
			
			switch (sel) {
			case 1:  readBook(); break;
			case 2:  createBook(); break;
			case 3:   break;
			case 4:   break;
			case 5: addFavorite(); break;
				
			case 6: readFavorite(); break;
			case 0: System.out.println("프로그램 종료."); break;

			default: System.out.println("잘못 입력하셨습니다.");
			}
			
		}while(sel != 0);
		
		
		
	}
	
	public void readBook() {
		System.out.println("=== 도서 조회 ===");
		
		for( Map<String, Object> temp : bookList) {
			System.out.printf("%-20s" ,temp.get("title") );
			System.out.printf("%10s" , temp.get("author") );
			System.out.printf("%10d원" , temp.get("price") );
			System.out.printf("%10s" , temp.get("publisher") );
			System.out.println();
		
		}
		
		
	}
	
	
	public void createBook() {
		System.out.println("=== 도서 등록 ===");
		
		// 책번호는 알아서 계산 +1씩
		
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("저자 : ");
		String author = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("출판사 : ");
		sc.nextLine();
		String publisher = sc.nextLine();
	
		
		Map<String, Object> newBook = new HashMap<String, Object>() {{
		    put("bNo", bookList.size());
		    put("title", title);
		    put("author", author);
		    put("price", price);
		    put("publisher", publisher);
		}};
		
		bookList.add(newBook);
		
		System.out.println("등록완료");
		
		readBook();
		
	}
	
	public void addFavorite() {
		
		System.out.println("=== 즐겨찾기 등록 ===");
		
		for( Map<String, Object> temp : bookList) {
			System.out.printf("%-3d" ,temp.get("bNo") );
			System.out.printf("%-20s" ,temp.get("title") );
			System.out.printf("%10s" , temp.get("author") );
			System.out.println();
		
		}
		
		System.out.print("즐겨찾기 할 책 등록번호 입력 : ");
		
		int fbNo = sc.nextInt();
		
		
		for( Map<String, Object> temp : bookList) {
			
			if((int)temp.get("bNo") == fbNo) {
				System.out.print(temp.get("title"));
				System.out.print(" 즐겨찾기 등록 완료\n");
				favorite.add(temp);
			}
		
		}
		
		
		
	}
	
	
	public void readFavorite() {
		System.out.println("=== 즐겨찾기 조회 ===");
		
		
		favorite.sort(
			Comparator.comparing((Map<String, Object> map) -> (Integer) map.get("bNo"))
		);
		
		/*
		 * 
		 * 
		 * key:value
		 * 
		 * 
		 * 1:"asdg"
		 * 2: "Sdgdw
		 * 
		 * "bNo": 1
		 * "bNo: 2
		 * "ㄴㅇㅎㄴㅇ" : 30
		 * 
		 * */
		
		for( Map<String, Object> temp : favorite) {
			System.out.printf("%-3d" ,temp.get("bNo") );
			System.out.printf("%-20s" ,temp.get("title") );
			System.out.printf("%10s" , temp.get("author") );
			System.out.println();
			
		}
		
		System.out.print("파일로 내보내시겠습니까?(Y/N) : ");
		char isOutput = sc.next().charAt(0); 
	
		if(isOutput == 'Y') {
			outputFile(favorite);
		} else {
			System.out.println("내보내지 않습니다.");
		}
		
		
	}
	
	public void outputFile(Object obj) {
		
		String filePath = "favorites.txt";
		BufferedWriter writer = null;
		try {
		 	File file = new File(filePath); // File객체 생성
		 	if(!file.exists()){ // 파일이 존재하지 않으면
	            file.createNewFile(); // 신규생성
	        }
		 	 // BufferedWriter 생성
		 	writer = new BufferedWriter(new FileWriter(file));

			
			for( Map<String, Object> temp : favorite) {
				writer.write(temp.get("bNo").toString());
				writer.write("       ");
				writer.write(temp.get("title").toString());
				writer.write("       ");
				writer.write(temp.get("author").toString());
				writer.newLine();

				
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
			
			
		} finally {

			 try { 
			 	writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 스트림 종료
		}
		
		
		
	}
}
