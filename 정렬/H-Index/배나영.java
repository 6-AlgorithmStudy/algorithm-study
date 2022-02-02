package week_정렬;

import java.util.*;

class Solution {

    static int hIndex; // h-index 저장할 수
    
    public int solution(int[] citations) {
        hIndex=-1; 
        
        for(int i=0;i<=citations.length;i++){
            // 최대 h=논문의 수 이기 때문에
            if(countCitations(i, citations) && hIndex<i){
                // i가 h 수가 될 수 있는지 여부를 구하고
                // h 수가 hIndex보다 큰 경우 hIndex 수를 h 수로 바꿔준다
                hIndex=i;
            }
        }
        
        return hIndex;
    }
    
    // h 수를 구하는 메소드
    static boolean countCitations(int num, int[] citations){
        // num: h 수 후보
        // citations: 값 전달
        int count=0; // num번 이상 인용된 논문의 수를 세어줄 변수
        
        for(int i=0;i<citations.length;i++){
            
            if(citations[i]>=num){ // 인용 수가 num번 이상일 때
                count++; // 숫자 세어주기
            }
        }
        
        if(count>=num) return true; // h번 이상 인용된 논문이 h편이라면 true
        return false; // 아니면 false
    }
    
}
