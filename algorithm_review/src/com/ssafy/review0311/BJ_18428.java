package com.ssafy.review0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BJ_18428 {
	
	static class Combination{
		int n;
		int r;
		int[] now;
		ArrayList<ArrayList<Position>> result;
		
		public ArrayList<ArrayList<Position>> getResult(){
			return result;
		}
		
		public Combination(int n, int r) {
			this.n = n;
			this.r = r;
			this.now = new int[r];
			this.result = new ArrayList<>();
		}

		public void combination(ArrayList<Position> arr, int depth, int index, int target) {
			if(depth == r) {
				ArrayList<Position> temp = new ArrayList<>();
				for(int i=0; i<now.length; i++) {
					temp.add(arr.get(now[i]));
				}
				result.add(temp);
				return;
			}
			if(target == n)	return;
			now[index] = target;
			combination(arr, depth+1, index+1, target+1);
			combination(arr, depth, index, target+1);
		}
		
	}
	
	static class Position{
		int x;
		int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;
	static char[][] board = new char[6][6];
	static ArrayList<Position> teachers = new ArrayList<>();
	static ArrayList<Position> spaces = new ArrayList<>();
	
	static boolean watch(int x, int y, int direction) {
		//왼
		if(direction == 0) {
			while(y>=0) {
				if(board[x][y] == 'S')	return true;
				else if(board[x][y] == 'O')	return false;
				y--;
			}
		}
		//오
		else if(direction == 1) {
			while(y<n) {
				if(board[x][y] == 'S')	return true;
				else if(board[x][y] == 'O')	return false;
				y++;
			}
		}
		//위
		else if(direction == 2) {
			while(x>=0) {
				if(board[x][y] == 'S')	return true;
				else if(board[x][y] == 'O')	return false;
				x--;
			}
		}
		//아래
		else if(direction == 3) {
			while(x<n) {
				if(board[x][y] == 'S')	return true;
				else if(board[x][y] == 'O')	return false;
				x++;
			}
		}
		return false;
	}
	
	static boolean process() {
		for(int i=0; i<teachers.size(); i++) {
			int x = teachers.get(i).x;
			int y = teachers.get(i).y;
			for(int j=0; j<4; j++) {
				if(watch(x, y, j))	return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = st.nextToken().charAt(0);
				if(board[i][j] == 'T')	teachers.add(new Position(i, j));
				if(board[i][j] == 'X')	spaces.add(new Position(i, j));	
			}
		}
		Combination comb = new Combination(spaces.size(), 3);
		comb.combination(spaces, 0, 0, 0);
		ArrayList<ArrayList<Position>> list = comb.getResult();
		
		boolean found = false;
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.get(i).size(); j++) {
				int x = list.get(i).get(j).x;
				int y = list.get(i).get(j).y;
				
				board[x][y] = 'O';
			}
			if(!process()) {
				found = true;
				break;
			}
			for(int j=0; j<list.get(i).size(); j++) {
				int x = list.get(i).get(j).x;
				int y = list.get(i).get(j).y;
				
				board[x][y] = 'X';
			}
			
		}
		if(found)	System.out.println("YES");
		else	System.out.println("NO");
	}
	
	
	
	
}
