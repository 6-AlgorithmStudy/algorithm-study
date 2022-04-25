package kakao2022;

import java.util.Scanner;

public class 주차문제 {
	static int[] arr;
	static int N;
	static long answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			answer = 0;
			N = sc.nextInt();
		    arr= new int[N];
		    for(int i = 0; i < N; i++) {
		    	arr[i] = sc.nextInt();
		    }//end i
		    solution(0,N);
		    System.out.println("#" + tc + " " + answer);
		}//end testcase
	}
	private static void solution(int start, int end) {//시작값과 끝값에서 최대값의 인덱스를 찾는 재귀함수
		// TODO Auto-generated method stub
		if(end - start == 1) return;
		if(start >= end-1) return;
		long max = -1;
		int index = -1;
		for(int i = start; i < end; i++) {
			if(max <= arr[i]) {
				max = arr[i];
				index = i;
			}
		}//end i (최대값 찾음) 
		//이제 시그마 시작에서 maxindex-1값까지 해주고 이걸 max * (i-1 - start)해주고 계산한다.
		long sum = 0;
		for(int i = start; i < index; i++) {
			sum+= arr[i];
		}
		answer += max * (index - start) - sum;
		solution(index + 1, end);
		
		
	}
}
