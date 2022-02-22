import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //bfs할 스택이 필요
        int X = 0, Y = 1, K = 2;
        Queue<int[]> q = new LinkedList<>();
        //노드와 간선의 정보를 표현할 N*N배열 생성
        int[][] board = new int[n+1][n+1];
        //이제 인풋을 옮기기!!!
        for(int i = 0; i < edge.length; i++) {
            int row = edge[i][X];
            int col = edge[i][Y];
            board[row][col] = 1;
            board[col][row] = 1;
        }// end board input
    
        for(int i = 2; i <= n; i++) {
            if(board[1][i] == 0){
                continue;
            }
            int[] tmp = {1,i,1};
            board[i][i] = 1;
            q.offer(tmp);
        }//1과 연결된놈들 스택에 푸시!!!!
        //그리고 방문에대한 정보는 N,N인덱스에 저장(
왜냐면 이건 다 0으로 고정이니까)
       // bfs시작!!!!
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int vNode = cur[Y]; // 방문한 노드 번호
            int num = cur[K]; //방문 카운트
            if(board[vNode][vNode] != 0 && board[vNode][vNode] < num ){
                continue;
            }//방문했는데 이전에 방문한 놈이 나보다 
적은횟수로 방문하면 컨티뉴!!!
            
            for(int i = 2; i <=n ;i++) {
                if(board[vNode][i] == 0 || i == vNode){
                continue;
                }//1인것만 큐에 푸시 그리고 본인노드 
재귀방문 방지
                int[] tmp = {vNode,i,num+1};
                if(board[i][i] > num+1 || board[i][i] == 0){
                    board[i][i] = num+1;
                }
                q.offer(tmp);
            }//end i
        }// end while
        int max = -1;
        // for(int i= 1; i<= n; i++){
        //     for(int j = 1; j <= n; j++){
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(board[i][i] > max){
                max = board[i][i];
                answer = 1;
            }else if(board[i][i] == max){
                answer++;
            }
        }
        
        
        return answer;
    }
}