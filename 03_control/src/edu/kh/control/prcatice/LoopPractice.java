package edu.kh.control.prcatice;

import java.util.Scanner;

public class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void ex9() {
		/* 실습문제 9
		다음과 같은 실행 예제를 구현하세요.
		ex.
		정수 입력 : 4
		   *
		  **
		 ***
		****
		
		*/ 
		
		System.out.print("정수 입력: ");
		int input = sc.nextInt();
					//	1) 1 <= 4
		for(int row = 1; row <= input; row++) {
			
						//  1) 1 <= 4
						// 	2) 2 <= 4
						// 	3) 3 <= 4
						//  4) 4 <= 4
			for(int col = 1; col <= input; col++) {
				
				//  1) 1 <= 4 - 2
				// 	2) 2 <= 4 - 2
				// 	3) 3 <= 4 - 2
				//  4) 4 <= 4 - 2
				if(col <= input - row) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
	}

	public void ex11() {
	/* 실습문제 11
		다음과 같은 실행 예제를 구현하세요.
		ex.
		정수 입력 : 4
		    *
		   ***
		  *****
		 ******* <=  input * 2 - 1
		*/
		
		System.out.print("정수 입력: ");
		
		int input = sc.nextInt();
		
		for(int row = 1; row <= input; row++) {
			for(int col = 1; col <= input * 2 - 1; col++) {
				// 마지막 줄의 별 갯수: input에 2를 곱한값의 -1
				//		row	  corl ||      row  col
				//1)  4 - 1 >= 1  ||  4 + 1 <= 1  true
				//2)  4 - 1 >= 2  ||  4 + 1 <= 2  true
				//3)  4 - 1 >= 3  ||  4 + 1 <= 3  true
				//4)  4 - 1 >= 4  ||  4 + 1 <= 4  false
				if( input - row >= col || input + row <= col) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	public void ex12() {
		/*  실습문제 12
		다음과 같은 실행 예제를 구현하세요.
		ex.
		정수 입력 : 5
		*****
		*   *
		*   *
		*   *
		*****
		*/
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int row = 1; row <= input; row++) {
			for(int col = 1; col <= input; col++) {
				
				// 첫번째/ 마지막줄,칸일때만 * 출력
				// 입력한 인풋의 길이만큼 행열 길이 지정
				if(row == 1 || row == input  || col == 1 || col == input) {
					System.out.print("*");					
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public void ex13() {
		// 조건1) 2의 배수 또는 3의 배수인 경우 출력
		// => 2나 3으로 나누었을때 나머지값이 0인경우
		// 조건2) 2와 3의 공배수?
		// => 2로도 나누어 떨어지고, 3으로도 나누어 떨어진다.
		/*
		 * 자연수 하나를 입력하세요 : 15
			2 3 4 6 8 9 10 12 14 15 // 2와 3의 배수
			count : 2		// 2와 3의 공배수 (6, 12)
		 * */
		
		System.out.print("자연수 입력 : ");
		int input = sc.nextInt();
		int count = 0;
		
		for(int i = 1; i <= input; i++) {
			if(i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
				
				if(i % 2 == 0 && i % 3 == 0) {
					count++;
				}
			}
		}
		
		System.out.println("\ncount: " + count);
	}
}
