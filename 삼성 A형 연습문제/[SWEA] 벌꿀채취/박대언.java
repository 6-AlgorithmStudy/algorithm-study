package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벌꿀채취_2115 {
	static int T, N, M, C, profit;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		
		for (int t = 1; t <= T; t++) {
			// 가격 입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());		// 벌통의 크기
			M = Integer.parseInt(st.nextToken());		// 벌통의 개수
			C = Integer.parseInt(st.nextToken());		// 꿀 채취 최대 양
			map = new int[N][N];
			
			// 이용 계획 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println("#" + t + " " + comb());
		}
	}
	
	private static int comb() {
		int ans = 0;
		int max1 = 0, max2 = 0;
		int size = N - M + 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < size; j++) {
				// 첫 번째 벌통 선택
				profit = 0;
				getMaxHoney(i, j, 0, 0, 0);
				max1 = profit;
				
				// 두 번째 벌통 선택
				profit = 0;
				max2 = 0;
				// 같은 행 다음 열부터 시작
				for (int k = j + M; k < size; k++) {
					getMaxHoney(i, k, 0, 0, 0);
					max2 = Math.max(max2, profit);
				}
				// 다음행 부터 살펴보기
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 < size; j2++) {
						getMaxHoney(i2, j2, 0, 0, 0);
						max2 = Math.max(max2, profit);
					}
				}
				
				ans = Math.max(ans, max1 + max2);
			}
		}
		
		return ans;
	}

	private static void getMaxHoney(int r, int c, int cnt, int sum, int curProfit) {
		// 최대 채취 양 넘은 경우
		if (sum > C) return;
		
		if (profit < curProfit) profit = curProfit;
		
		// 최대 선택
		if (cnt == M) return;
		
		getMaxHoney(r, c + 1, cnt + 1, sum + map[r][c], curProfit + map[r][c] * map[r][c]);
		getMaxHoney(r, c + 1, cnt + 1, sum, curProfit);
	}
	
}