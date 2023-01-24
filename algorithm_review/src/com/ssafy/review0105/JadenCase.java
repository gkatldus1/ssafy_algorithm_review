package com.ssafy.review0105;
import java.util.*;
public class JadenCase {
	
	
    public String solution(String s) {
        if(s.isBlank()) return s;
       
        String[] arr = s.toLowerCase().split(" ");
        System.out.println(Arrays.toString(arr));
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length;i++){
            String str = arr[i];
            if(str.length()<1){
                sb.append(" ");
                continue;
            }
            
            sb.append(str.substring(0,1).toUpperCase()).append(str.substring(1)).append(" ");
            
        }
      
        if(s.substring(s.length()-1, s.length()).equals(" "))
            return sb.toString();
        String temp = sb.toString();
        String answer = temp.substring(0, temp.length()-1);
        sb.deleteCharAt(sb.lastIndexOf(" "));
        return sb.toString();
    }
	
}
