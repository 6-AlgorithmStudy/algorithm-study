package week_정렬;

import java.util.*;

class Solution {

    static String answer;
    
    public String solution(int[] numbers) {
        
        Number[] nums=new Number[numbers.length]; 
        answer=""; // answer 초기화
        
        for(int i=0;i<numbers.length;i++){
            nums[i]=new Number(numbers[i]); // numbers에 있는 것들 Number 객체로 넣어줌
        }
        
        Arrays.sort(nums); // 정렬해줌
        
        for(int i=0;i<nums.length;i++){
            answer+=nums[i].numStr; // 정렬된 수 차례로 answer에 넣어주기
        }
        
        return answer;
    }
    
    // 비교를 위해서 Comparable 구현
    static class Number implements Comparable<Number> {
        int num;
        String numStr; // 해당 숫자의 String 버전
        
        public Number(int num){
            this.num=num;
            this.numStr=Integer.toString(num); // num을 String으로 바꿔줌
        }
        
        public int compareTo(Number other){ 
            int num1=Integer.parseInt(other.numStr+this.numStr);
            int num2=Integer.parseInt(this.numStr+other.numStr);
            
            return num1-num2;
            // (이번수+비교할 수), (비교할 수+이번수)를 비교해서 오름차순 해준다 
        }
    }
}
