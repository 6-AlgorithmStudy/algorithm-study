import java.util.*;

public class Main_안전영역 {

	static boolean[][] visited;
	static int N;
	static int[][] map;
	static int result;
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	static int DROWN;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		result=1;
		DROWN=-1;
		map=new int[N][N];
		int maxHeight=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
				maxHeight=Math.max(map[i][j], maxHeight);
			}
		}
		
		for(int i=1;i<maxHeight;i++) {
			rain(i);
			result=Math.max(getSafePlace(), result);
		}
		
		System.out.println(result);
	}
	
	static void rain(int water) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]<=water) {
					map[i][j]=DROWN;
				}
			}
		}
//		System.out.println("water: "+water);
	}
	
	static int getSafePlace() {
		
		int safePlaceNum=0;
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				if(map[i][j]!=DROWN && !visited[i][j]) {
					dfs(i, j);
					safePlaceNum++;
				}
				
			}
		}
//		System.out.println("safePlaceNum: "+safePlaceNum);
		
		return safePlaceNum;
	}
	
	static void dfs(int i, int j) {
		
		visited[i][j]=true;
		
		for(int dir=0;dir<4;dir++) {
			int ni=i+di[dir];
			int nj=j+dj[dir];
			
			if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj]!=DROWN && !visited[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}
	
}
