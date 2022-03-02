import java.util.Scanner;

public class Main_연구소 {
	
	static int N, M;
	
	static int[][] map;
	static int[][] originMap;
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		result=0;
		originMap=new int[N][M];
		visited=new boolean[N*M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				originMap[i][j]=sc.nextInt();
			}
		}
		
		map=copyMap();
		choose3(0,0);
		
		System.out.println(result);
		
	}
	
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
	
	static int[][] copyMap(){
		
		int[][] copy=new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copy[i][j]=originMap[i][j];
			}
		}
		
		return copy;
		
	}
	
	static void choose3(int now, int selectedNum) {
		
		if(selectedNum==3) {
			makeWall();
			spread();
			int count=countSafePlace();
			map=copyMap();
			result=Math.max(result, count);
			return;
		}
		
		if(now>=visited.length) return;
		
		int i=now/M;
		int j=now%M;
		
		if(map[i][j]==0 && !visited[now]) {
			visited[now]=true;
			choose3(now+1, selectedNum+1);
			visited[now]=false;
		}
		
		choose3(now+1, selectedNum);
	}
	
	// 벽 세우기
	static void makeWall() {
		
		for(int idx=0;idx<visited.length;idx++) {
			
			if(visited[idx]) { // 벽을 세우기로 표시해준 곳일 경우
				int i=idx/M;
				int j=idx%M;
				
				map[i][j]=1; // 벽을 세워준다
			}
		}
	}
	
	static int countSafePlace() {
		
		int count=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(map[i][j]==0) {
					count++;
				}
				
			}
		}
		
		return count;
	}
	
	static void spread() {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(map[i][j]==2) {
					dfs(i, j);
				}
				
			}
		}
	}
	
	static void dfs(int i, int j) {
		
		map[i][j]=3; // 바이러스 새로 퍼뜨림
		
		for(int dir=0;dir<4;dir++) {
			int ni=i+di[dir];
			int nj=j+dj[dir];
			
			if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj]==0) {
				dfs(ni, nj);
			}
		}
	}
	
	

}
