import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

// 시간초과 났음...
public class Main_효율적인해킹 {

	static int N, M;
	static ArrayList<Integer>[] computer; // 인덱스에 해당하는 컴퓨터에서 해킹할 수 있는 컴퓨터들 저장
	static int[] hackingNum; // 인덱스에 해당하는 컴퓨터에서 해킹할 수 있는 컴퓨터가 몇 개인지 저장
	static int maxHackingNum; // 해킹 제일 많이 할 수 있는 컴퓨터는 몇 개나 해킹할 수 있는지 저장
	static boolean[] visited; // 컴퓨터 방문 여부 저장
	static StringBuffer sb;
	
	public static void main(String[] args) throws IOException {
		
		// 입력 시작
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		computer=new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			computer[i]=new ArrayList<>();
		}
		
		hackingNum=new int[N+1];
		visited=new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			computer[B].add(A);
		}
		// 입력 끝
		
		maxHackingNum=-1; // 가장 많이 해킹한 컴퓨터 수를 저장할 변수
		
		// 모든 컴퓨터에 대해서 해킹할 수 있는 컴퓨터의 수 구하기 
		for(int i=1; i<=N; i++) {
			hackingNum[i]=getHackingNum(i);
			maxHackingNum=Math.max(hackingNum[i], maxHackingNum);
		}
		
		sb=new StringBuffer();
		for(int i=1; i<=N; i++) {
			if(hackingNum[i]==maxHackingNum) { // 최대 해킹수와 같으면 출력
				sb.append(i+" ");
			}
		}
		
		System.out.println(sb);
		
	}
	
	static int getHackingNum(int num) { // num에 해당하는 컴퓨터의 해킹수 구하는 메소드
		
		if(visited[num]) return hackingNum[num]; // 이미 최대 해킹수를 계산한 적 있으면 그 값 출력
		
		// 계산한 적 없으면
		
		int hacking=1; // 일단 자기 자신은 해킹 가능
		
		for(int now: computer[num]) { 
			hacking+=getHackingNum(now); // 연결된 컴퓨터의 해킹수들 구해서 더해주기 
		}
		
		hackingNum[num]=hacking; // 해킹수 구했으니 저장
		return hacking; 
	}
	
	
}
