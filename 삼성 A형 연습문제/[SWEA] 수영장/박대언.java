package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장_1952 {
	static int T;
	static int[] prices, plans, sol;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		prices = new int[4];
		plans = new int[13];
		sol = new int[13];
		int temp;
		StringTokenizer st;
		
		for (int t = 1; t <= T; t++) {
			// 가격 입력
			st = new StringTokenizer(br.readLine());
			prices[0] = Integer.parseInt(st.nextToken());
			prices[1] = Integer.parseInt(st.nextToken());
			prices[2] = Integer.parseInt(st.nextToken());
			prices[3] = Integer.parseInt(st.nextToken());
			
			// 이용 계획 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				temp = Integer.parseInt(st.nextToken());
				// 1일, 1달 이용권 가격 비교
				plans[i] = Math.min(temp * prices[0], prices[1]);
			}
			
			// 누적된 최소값 구하기 (3달 이용권 가격 누적 비교)
			for (int i = 1; i <= 12; i++) {
				sol[i] = sol[i - 1] + plans[i];
				if (i >= 3 && sol[i] > sol[i - 3] + prices[2]) {
					sol[i] = sol[i - 3] + prices[2];
				}
			}
			
			if (sol[12] > prices[3]) sol[12] = prices[3];
			System.out.println("#" + t + " " + sol[12]);
		}
	}
}