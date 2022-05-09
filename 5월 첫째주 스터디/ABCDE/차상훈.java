package backjoon;
import java.io.*;
import java.util.*;

public class Main_G2_13023 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(input.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(input.readLine());
			int value1 = Integer.parseInt(st.nextToken());
			int value2 = Integer.parseInt(st.nextToken());
			list[value1].add(value2);
			list[value2].add(value1);
		}
		
		for (int i = 0; i < n; i++) {
			check = false;
			visited = new boolean[n];
			//dfs 탐색 시작
			dfs(i,0);
			if(check) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	
	private static void dfs(int x, int y) {
		if(y==4) {
			check = true;
		}else {
			for (int i = 0; i < list[x].size(); i++) {
				if(!visited[list[x].get(i)]) {
					visited[x] = true;
					dfs(list[x].get(i), y+1);
					visited[x] = false;	// 초기화
				}
			}
		}
	}
	public static String src = 
			"8 8\r\n" + 
			"1 7\r\n" + 
			"3 7\r\n" + 
			"4 7\r\n" + 
			"3 4\r\n" + 
			"4 6\r\n" + 
			"3 5\r\n" + 
			"0 4\r\n" + 
			"2 7";
}