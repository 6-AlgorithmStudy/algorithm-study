package 정렬;

import java.util.*;

public class ksnumbers {
	public static void main(String[] args) {
		ksnumbers s= new ksnumbers();
		int[] arrays = new int[] {1,5,2,6,3,7,4};
		int[][] commands = new int[][] {{2,5,3},{4,4,1},{1,7,3}};
		for (int i = 0; i < commands.length; i++) {
			System.out.print(s.Solution(arrays, commands)[i]+ " ");
		}
	}	
	public int[] Solution(int[] arrays, int[][] commands) {
		// commands의 길이만큼 배열 선언
		int[] ans = new int[commands.length];
		// ans index 선언
        int index = 0;
        
        //반복문 시작
        for (int i = 0; i < commands.length; i++) {
        	// 시작값
			int first = commands[i][0];
			// 종료값
			int second = commands[i][1];
			// 목표 변수
			int k = commands[i][2];
			
			// 필요한 배열만큼 가져오기
			int tmp[] = new int[second-first+1];
			// 배열에 넣을 위치
			int cnt = 0;
			
			// 해당하는 위치의 값 가지고 오기
			for (int j = first-1; j < second; j++) {
				tmp[cnt++] = arrays[j];
			}
			// 정렬
			Arrays.sort(tmp);
			// k번째 값 가지고 오기
			ans[index++] = tmp[k-1]; 
		}
        return ans;
	}
	
	public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // [1,2,3,4,5,6]의 배열이 있다면 copyOfRange(배열,2,5) 의 경우 [3, 4, 5]만 해당
        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
