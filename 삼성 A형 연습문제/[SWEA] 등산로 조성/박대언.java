package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 등산로조성_1949 {
	
	static int T, N, K, maxH, ans;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		map = new int[8][8];
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			maxH = 0;
			ans = 0;
			visit = new boolean[8][8];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (maxH < map[i][j]) maxH = map[i][j];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxH) {
						visit[i][j] = true;
						dfs(i, j, map[i][j], 1, 1);
						visit[i][j] = false;
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int r, int c, int height, int move, int cutCnt) {
		for (int i = 0; i < 4; i++) {
			if (ans < move) ans = move;
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
				// 다음 탐색점이 높이가 낮은 곳
				if (height > map[nr][nc]) {
					visit[nr][nc] = true;
					dfs(nr, nc, map[nr][nc], move + 1, cutCnt);
					visit[nr][nc] = false;
				} else {
					// 깎을 횟수가 남아 있고, 깎았을 때 현재 높이보다 낮아진다면
					// 높이는 1만 깎기 (그래야 다음 탐색점에서 최대로 탐색 가능)
					if (cutCnt == 1 && height > map[nr][nc] - K) {
						visit[nr][nc] = true;
						dfs(nr, nc, height - 1, move + 1, cutCnt - 1);
						visit[nr][nc] = false;
					}
				}
			}
		}
	}
}
