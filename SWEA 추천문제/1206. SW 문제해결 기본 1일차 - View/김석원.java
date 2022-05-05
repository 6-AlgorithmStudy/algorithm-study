package sw;

import java.util.Scanner;

public class View1206SW {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = 10;
	for(int tc = 1; tc <= 10; tc++) {
		int answer = 0;
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			int mindex = i;
			int middle = arr[mindex];
			if(2<= mindex&& mindex < N-2 ) {//양끝-2범위에 있는것만 탐색
				int max = -1;
				
				for(int j = mindex -2; j <= mindex+2; j++) {
					if(j == mindex) continue;
					max = max < arr[j] ? arr[j] : max;
				}//end j
				if(max - middle < 0) {
					answer += middle - max;
					System.out.println(answer);
				}
			}
		}//end i
		System.out.println("#" + tc + " " +answer);
	}//end tc
}
}
