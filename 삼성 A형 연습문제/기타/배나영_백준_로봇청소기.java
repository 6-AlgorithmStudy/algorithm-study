import java.util.Scanner;

public class Main_로봇청소기 {
	
	static int N, M;
	static int[][] map;
	static int nowi, nowj, nowDir;
	static int result;
	static int[] backDir= {2,3,0,1};
	
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,1,0,-1};
	
	public static void main(String[] args) {
		
		// 입력 시작
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		nowi=sc.nextInt();
		nowj=sc.nextInt();
		nowDir=sc.nextInt();
		map=new int[N][M];
		result=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		// 입력 끝
		
		while(true) {
			map[nowi][nowj]=2;
			
			if(!checkDir()) {
				if(!possibleBack()) break;
			}
			else {
				nowDir-=1; // 회전
				if(nowDir==-1) nowDir=3; // 회전
				possibleFrd(); // 전진 가능한 경우 전진함
			}
		}
		
		result=count();
		System.out.println(result);
	}
	
	// 로봇청소기가 청소한 곳(2)의 개수를 세는 메소드
	private static int count() {
		
		int num=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2) {
					num++;
				}
			}
		}
		
		return num;
	}

	// 상하좌우 네 방향에 갈 수 있는 방향이 있는지 체크하는 메소드
	static boolean checkDir() {
		
		for(int dir=0;dir<4;dir++) { // 상하좌우에 대해서
			
			int ni=nowi+di[dir];
			int nj=nowj+dj[dir];
			
			if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==0) { // 4방향 중 갈 수 있는 방향이 있다면
				return true; // true 리턴
			}
		}
		
		return false; // 네 방향 중 갈 수 있는 방향이 없다면 false 리턴
	}
	
	// 후진하는 메소드
	static boolean possibleBack() {
		
		// 현재 위치한 곳의 후진
		int ni=nowi+di[backDir[nowDir]];
		int nj=nowj+dj[backDir[nowDir]];
		
		if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]!=1) { // 후진할 곳이 벽이 아닌 경우
			
			// 후진
			nowi=ni;
			nowj=nj;
			
			return true; // 후진 가능하다
		}
		
		return false; // 후진 불가능하다
	}
	
	// 전진 가능하면 전진
	static void possibleFrd() {
		
		// 현재 위치한 곳의 전진
		int ni=nowi+di[nowDir];
		int nj=nowj+dj[nowDir];
		
		if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==0) { // 전진한 곳이 벽도 아니고 청소도 안 한 곳이라면 
			
			// 전진함
			nowi=ni;
			nowj=nj;
			
			return;
		}
		
	}
}
