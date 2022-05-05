import java.util.Scanner;

public class 연결요소의개수 {
	static int[][] board;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 M = sc.nextInt();
		board = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			board[x][y] = 1;
			board[y][x] = 1;
		}//end input 
		
		
		
//		for(int i = 1; i <= N; i++) {
//			for(int j =1 ;j <= N; j++) {
//				System.out.print(board[i][j]+ " ");
//			}
//			System.out.println();
//		}
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(board[i][i] == 1) {
				continue;
			}
//			System.out.println(i);
			answer++;
			dfs(i);
			
		}
		System.out.println(answer);
//		for(int i = 1; i <= N; i++) {
//			for(int j =1 ;j <= N; j++) {
//				System.out.print(board[i][j]+ " ");
//			}
//			System.out.println();
//		}
	}
	private static void dfs(int num) {
		// TODO Auto-generated method stub
		board[num][num] = 1;
		for(int i = 1; i <= N; i++) {
			if(i == num)continue; // 자기 자신 방문 막는다.
			if(board[i][i] == 1) continue; // 이미 방문한거 막는다.
			if(board[num][i] == 1) {
				
				dfs(i);
			}
			
		}
	}
}
