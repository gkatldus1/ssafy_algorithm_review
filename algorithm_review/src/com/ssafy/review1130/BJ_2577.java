package com.ssafy.review1130;

import java.util.Scanner;

public class BJ_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mul = 1;
		for(int i=0; i<3; i++) {
			int input = sc.nextInt();
			mul *= input;
		}
		int[] count = new int[10];
		int index = 0;
		while(mul!=0) {
			index = mul % 10;	//일의 자리 숫자를 판별
			mul /= 10;	//파싱한 일의 자리 숫자만큼 줄여줌
			count[index]++;//사용한 숫자의 개수를 올려줌
		}
		for(int i=0; i<10; i++) {
			System.out.println(count[i]);
		}
		
	}
}
