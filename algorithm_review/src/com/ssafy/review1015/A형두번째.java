package com.ssafy.review1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class A형두번째 {
	static int Ms, Ma, N, L; // 예치금, 월별 불입금액, 종목 수, 과거 데이터 기간
    static int arr[][]; // L+1개월 간 N개 종목의 주식 가격

	static LinkedList<Profit> profits; // 각 월별 수익을 낼 수 있는 종목 가격과 수익을 이율 높은 것부터 저장
	static int num; // 각 월별 수익을 낼 수 있는 종목의 개수
	static int money; // 각 월별 현재 잔고
	static int max; // 각 월별 최대 이익 저장

	static class Profit {
	    int price; // 주식 가격
	    int profit; // 이익
	    double per; // 이율

	    public Profit(int price, int profit) {
	        this.price = price;
	        this.profit = profit;
	        this.per = (double) profit / (double) price;
	    }
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    int T = Integer.parseInt(br.readLine());
	    for (int tc = 1; tc <= T; tc++) {
	        // input
	        st = new StringTokenizer(br.readLine());
	        Ms = Integer.parseInt(st.nextToken()); // 예치금
	        Ma = Integer.parseInt(st.nextToken()); // 월별 불입금액
	        st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken()); // 종목 수
	        L = Integer.parseInt(st.nextToken()); // 과거 데이터 기간
	        arr = new int[N][L + 1]; // L+1개월 간 N개 종목의 주식 가격
	        for (int i = 0; i < N; i++) { // 각 종목 별로
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j <= L; j++) { // 월별 주식 가격
	                arr[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }

	        money = Ms; // 현재 잔고

	        for (int j = 0; j < L; j++) { // 월 경과
	            profits = new LinkedList<>();
	            for (int i = 0; i < N; i++) { // 각 종목 별로
	                if (arr[i][j] < arr[i][j + 1])
	                    profits.add(new Profit(arr[i][j], arr[i][j + 1] - arr[i][j]));
	            }

	            num = profits.size();
	            if (num != 0) {
	                max = maxProfit(money);
	                money += max; // 해당 달의 최대 이익 더함
	            }

	            money += Ma; // 월별 불입금액 더함
	        }

	        // output
	        System.out.println("#" + tc + " " + (money - (Ms + L*Ma))); // 현재 잔고 - (예치금 + L개월 간 추가 불입금액)
	    }
	}

	private static int maxProfit(int total) {
	    int sum = 0; // 해당 달의 이익

	    while(!profits.isEmpty()) {
	        double maxPer = 0;
	        int maxIdx = 0;
	        
	        for (int i = 0; i < profits.size(); i++) {
	            if (maxPer < profits.get(i).per) {
	                maxPer = profits.get(i).per;
	                maxIdx = i;
	            } else if (maxPer == profits.get(i).per) {
	                if (profits.get(maxIdx).price > profits.get(i).price) {
	                    maxPer = profits.get(i).per;
	                    maxIdx = i;
	                }
	            }
	        }
	        
	        Profit temp = profits.remove(maxIdx);
	        
	        int cnt = total / temp.price; // 최대한 많이 매수
	        sum += temp.profit * cnt;
	        total -= (temp.price * cnt);
	        
	        if (total <= 0)
	            break;
	    }

	    return sum;
	}
}
