package com.ssafy.review0319;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class gabia01 {
	 public static void main(String[] args) {
	        System.out.println(solution(3, new String[]{
	                "alex111 100",
	                "cheries2 200",
	                "coco 150",
	                "luna 100",
	                "alex111 120",
	                "coco 300",
	                "cheries2 110"
	        }));
	    }

	    public static class Player implements Comparable<Player>{
	        int idx, score;
	        String name;

	        public Player(int idx, String name, int score) {
	            this.idx = idx;
	            this.score = score;
	            this.name = name;
	        }

	        public String getName() {
	            return name;
	        }

	        @Override
	        public int compareTo(Player o) {
	            if(this.score == o.score) return this.idx - o.idx;
	            return o.score - this.score;
	        }
	    }

	    public static int solution(int K, String[] user_scores) {
	        int answer = 0;

//	        TreeMap<String, Player> map = new TreeMap<>();
	        HashMap<String, Player> map = new HashMap<>();
	        List<String> rank = new ArrayList<>();

	        for(int i = 0; i < user_scores.length; i++){
	            String[] user_score = user_scores[i].split(" ");
	            String name = user_score[0];
	            int score = Integer.parseInt(user_score[1]);

	            if(map.containsKey(name)){
	              if(map.get(name).score < score) map.put(name, new Player(i, name, score));
	            }
	            else {
	                map.put(name, new Player(i, name, score));
	            }

	            ArrayList<Player> players = new ArrayList<>(map.values());
	            Collections.sort(players);

	            int size = rank.size();
	            if(size < K && size < players.size()){
	                rank = players.stream().map(Player::getName).collect(Collectors.toList());
	                answer++;
	                continue;
	            }

	            for(int j = 0; j < Math.min(players.size(), K); j++){
	                if(!rank.get(j).equals(players.get(j).getName())){
	                    answer++;
	                    rank = players.stream().limit(K).map(Player::getName).collect(Collectors.toList());
	                    break;
	                }
	            }

	        }


	        return answer;
	    }
}
