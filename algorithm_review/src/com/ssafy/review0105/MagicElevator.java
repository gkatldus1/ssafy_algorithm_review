package com.ssafy.review0105;

public class MagicElevator {
	public int solution(int storey) {
        String num = String.valueOf(storey);
        int len = num.length();
        int[] arr = new int[len];
        int answer = 0;
        
        for(int i=0; i<len; i++){
            arr[i] = num.charAt(i)-'0';
        }
        
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]>5){
                answer += (10 - arr[i]);
                
                if(i == 0){
                    answer++;
                }
                else{
                    arr[i-1]++;                
                }
            }
            else if(arr[i] == 5){
                if(i==0){
                    answer+=5;
                }
                else if(arr[i-1]>=5){
                    answer += (10-arr[i]);
                    arr[i-1]++;
                }
                else{
                    answer += arr[i];
                }
            }
            else{
                answer += arr[i];
            }
            
            
        }
        return answer;
        
        
        
    }
}
