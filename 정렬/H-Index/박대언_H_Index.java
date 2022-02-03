package programmers;

import java.util.Arrays;

public class H_Index {
	
	public static int solution(int[] citations) {
        int answer = 0;
        int n;
        // 배열 정렬
        Arrays.sort(citations);

        for(int i = 1; i <= citations.length; i++) {
        	n = citations[citations.length - i];
   	
        	if (i <= n) answer++;
//        	if (n < i) {
//        		answer = i - 1;
//        		break;
//        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] c = {3, 0, 6, 1, 5};
		
		int sol = solution(c);
		System.out.println(sol);
	}
}