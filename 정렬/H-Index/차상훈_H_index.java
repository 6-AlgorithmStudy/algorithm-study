package 정렬;

import java.util.*;

public class H_index {
	public static void main(String[] args) {
		H_index s= new H_index();
		int[] citations = new int[] {3,0,6,1,5};
		System.out.println(s.solution(citations));
	}	
	
	public int solution(int[] citations) {
		// h번 이상 인용된 논문이 h편 이상인 h의 최댓값
		int ans = 0;
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			int h = citations.length-i;
			if(citations[i]>=h) {
				ans = h;
				break;
			}
		}
		return ans;
    }
}
