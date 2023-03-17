package com.ssafy.review0317;
import java.util.*;

public class Programmers_hotel {
	
	static class Book implements Comparable<Book> {
		int start, end;
		
		public Book(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Book other) {
			if(this.start == other.start) {
				return Integer.compare(this.end, other.end);
			}
			return Integer.compare(this.start, other.start);
		}
		
	}
	
	static int calcMinute(String time) {
		StringTokenizer st = new StringTokenizer(time, ":");
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		return hour*60+minute;
		
		
	}
	
	public static void main(String[] args) {
		//[["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]
		String[][] book_times = {{"15:00", "17:00"}, {"16:40", "18:20"},{"14:20", "15:20"},{"14:10", "19:20"},{"18:20", "21:20"}};
		
		ArrayList<Book> bookList = new ArrayList<>();
		
		for(String[] book : book_times) {
			int start = calcMinute(book[0]);
			int end = calcMinute(book[1]);
			bookList.add(new Book(start, end+10));
		}
		Collections.sort(bookList);
		
		ArrayList<Integer> rooms = new ArrayList<>();
		
		for(int i=0; i<bookList.size(); i++) {
			boolean flag = false;
			Book now = bookList.get(i);
			if(rooms.size() == 0) {
				rooms.add(now.end);
				continue;
			}
			for(int j=0; j<rooms.size(); j++) {
				if(now.start>=rooms.get(j)) {
					rooms.set(j, now.end);
					flag = true;
					break;
				}
			}
			if(!flag) {
				rooms.add(now.end);
				
			}
		}
		
		
		System.out.println(rooms.size());
		System.out.println();
		for(int i=0; i<rooms.size(); i++) {
			System.out.println(rooms.get(i));
		}
		
	}
		
	

}
