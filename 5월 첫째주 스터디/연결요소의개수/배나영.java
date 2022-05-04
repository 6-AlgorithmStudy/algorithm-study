import java.util.Scanner;

public class 연결요소의개수 {

    static int N, M;
    static boolean[][] connected; // 노드들의 연결 관계
    static int[] visited; // 노드 방문했는지 여부 저장. 몇 번째 그룹인지 저장해준다.
    static int result; // 그룹의 개수

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        connected=new boolean[N+1][N+1];
        visited=new int[N+1];
        result=1;

        for(int m=0; m<M; m++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            connected[u][v]=true;
            connected[v][u]=true;
        }

        for(int i=1; i<=N; i++){
            if(visited[i]==0){ // 방문한 적 없으면
                visited[i]=result; // 방문시킴
                dfs(i); // i에서 방문할 수 있는 곳 다 방문시키고
                result++; // 증가
            }
        }

        result--;
        System.out.println(result);
    }

    static void dfs(int node){
        for(int i=1; i<=N; i++){
            if(visited[i]==0 && connected[node][i]){
                visited[i]=result; // 방문 처리
                dfs(i); // 연결된 다음 노드 방문
            }
        }
    }
}
