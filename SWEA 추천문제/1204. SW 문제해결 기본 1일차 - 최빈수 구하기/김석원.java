package sw;

import java.util.Scanner;

/*
 * 1000명의 수학성적의 최 빈수
 * 일단 1000개의 입력값을 받은 뒤 
 * arr[101]로 100점까지 갯수 다 카운트하고
 * 101번 탐색해서 최대값의 인덱스 뽑으면 끝
 */
public class SW_1204최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int answer = 0;
			int tcnum = sc.nextInt();
			int[] arr = new int[101];
			for(int i = 0; i < 101; i++) {
				arr[i] = 0;

		}//end i
			for(int i = 0; i < 1000; i++) {
				arr[sc.nextInt()]++;
			}
			int max = -1;
			for(int i =0 ; i< 101; i++) {
				if(max <= arr[i]) {
					max = arr[i];
					answer = i;
				}
			}
			
			
			System.out.printf("#%d %d\n",tcnum,answer);
		}// end tc
	}
}
