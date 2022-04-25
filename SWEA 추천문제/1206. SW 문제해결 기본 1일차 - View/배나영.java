import java.util.Scanner;

public class Solution_View {
	
	static int len;
	static boolean[][] map;
	static int result;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		// 테스트케이스
		for(int tc=1; tc<=10; tc++) {
			len=sc.nextInt();
			map=new boolean[256][len];
			result=0;
			
			for(int j=0;j<len;j++) {
				int height=sc.nextInt();
				
				for(int i=0;i<height;i++) {
					map[i][j]=true;
				}
			}
			
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[0].length;j++) {
					if(map[i][j]&&isView(i, j)) {
						result++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

	private static boolean isView(int i, int j) {
		
		if(map[i][j-1] || map[i][j-2] || map[i][j+1] || map[i][j+2]) return false;
		
		return true;
	}

}
