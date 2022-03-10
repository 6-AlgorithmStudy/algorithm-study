import java.util.Scanner;

public class Main_사다리타기 {
	
	static int N, M, H;
	static int result;
	static boolean[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		H=sc.nextInt();
		
		map=new boolean[M+1][N+1];
		visited=new boolean[(N+1)*(M+1)];
		result=Integer.MAX_VALUE;
		
		for(int m=0; m<M; m++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			map[a][b]=true;
		}
		
		for(int i=0;i<=H;i++) { // 빈 곳에 가로 사다리 놓는 걸 0개부터 H개까지 모두 선택해보기
			select(0,0,i);
		}
		
		if(result==Integer.MAX_VALUE) { // result가 처음이랑 똑같을 경우=계산 안 되는 경우다
			result=-1;
		}
		
		System.out.println(result); // result 출력
	}


	// selectNum개만큼 사다리의 가로선 선택하는 메소드
	// cnt: 지금까지 고른 수
	// now: 지금 방문하는 수
	private static void select(int cnt, int now, int selectNum) {
		
		if(cnt==selectNum) { // 모두 골랐을 경우
			
			boolean isAllPassed=true;
			
			for(int j=1;j<=N;j++) {
				if(!ladder(j)) { 
					isAllPassed=false;
				}
			}
			
			if(isAllPassed) {
				result=Math.min(result, cnt);
			}
			
			return;
		}
		
		if(now==visited.length) return;
		
		if(selectNum>=result) return;
		
		int nowi=now/(N+1);
		int nowj=now%(N+1);
		
		if(nowi>0 && nowj>0 && nowi<=M && nowj<N && !visited[now] && !map[nowi][nowj]) {
			visited[now]=true;
			select(cnt+1, now+1, selectNum);
		}
		
		visited[now]=false;
		select(cnt, now+1, selectNum);
		
	}
	
	// 사다리를 타고 내려감
	private static boolean ladder(int startj) {
		
		int i=0;
		int j=startj;
		
		while(true) {
			
			if(i>=M) break;
			if(map[i][j]) j++; // 내 오른쪽이 true이면 오른쪽으로 한 칸 가고
			else if(map[i][j-1]) j--; // 왼쪽이 true이면 왼쪽으로 한 칸 간다
			i++;
			
		}
		
		if(j==startj) return true;
		return false;
		
	}
	
	// 디버깅용
	static void print() {
		for(int i=0;i<=M;i++) {
			for(int j=0;j<=N;j++) {
				
				if(map[i][j])
					System.out.print("O");
				else 
					System.out.print("X");
			}
			
			System.out.println();
		}
	}
	
}
