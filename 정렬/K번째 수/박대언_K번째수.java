package programmers;

import java.util.Arrays;

public class K번째수 {

	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
       
        for (int i = 0; i < commands.length; i++) {
        	int[] curCmd = commands[i];
        	int n = curCmd[1] - curCmd[0] + 1;
        	int[] arr = new int[n];
        	
        	// i ~ j 번째 배열 잘라내기
        	// Arrays.copyOfRange 사용하면 더 좋을듯
        	for (int j = 0; j < n; j++) {
        		arr[j] = array[curCmd[0] - 1 + j];
        	}
        	// 배열 정렬
        	Arrays.sort(arr);
        	
        	answer[i] = arr[curCmd[2] - 1];
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		int[] sol = solution(array, commands);
		
		for (int i = 0; i < sol.length; i++)
			System.out.println(sol[i]);
	}

}
