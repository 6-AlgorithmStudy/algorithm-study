package week_정렬;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer=new int[commands.length]; // 결과 저장
        
        for(int i=0;i<commands.length;i++){ // 모든 명령들마다
            answer[i]=sorting(array, commands[i]); // 리턴된 k번째 수 저장
        }
        
        return answer; // 결과 리턴
    }
    
    static int sorting(int[] array, int[] command){
        int[] arr=Arrays.copyOfRange(array, command[0]-1, command[1]);
        // copyOfRange: 두번째 인자에서부터 세번째 인자 앞까지 자르는 함수
        Arrays.sort(arr); // 정렬
        return arr[command[2]-1]; // k번째 수 리턴
    }
}
