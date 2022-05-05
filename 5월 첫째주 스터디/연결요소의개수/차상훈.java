package backjoon;
import java.io.*;
import java.util.*;

public class Main_S2_11724 {	
	static ArrayList<Integer>[] list;
	static boolean visited[];
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		int value1,value2,answer = 0;
		
		for(int i = 1; i < n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(input.readLine());
			value1 = Integer.parseInt(st.nextToken());
			value2 = Integer.parseInt(st.nextToken());
			// 인접 리스트 구현
			list[value1].add(value2);
			list[value2].add(value1);
		}
		
		// 방문 여부 점검
		for(int i = 1; i < n+1; i++) {
			// 하나의 그룹에 정점을 방문 후 dfs 호출
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static void dfs(int v){
        if(visited[v]) {
            return;
        }
        visited[v]=true;
        for(int i : list[v]){
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

	public static String src = 
			"6 8\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"5 1\r\n" + 
			"3 4\r\n" + 
			"4 6\r\n" + 
			"5 4\r\n" + 
			"2 4\r\n" + 
			"2 3";
}