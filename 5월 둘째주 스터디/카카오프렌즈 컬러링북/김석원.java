class Solution {
    public boolean vis[][];
    public int area;
    public int[][] board;
    public int[] dx = {0,1,0,-1};
    public int[] dy = {1,0,-1,0};
    public int N,M;
    public void dfs(int i, int j, int num){
        //방문했거나, 나랑 같은 숫자가 아니면 리턴
        if(vis[i][j]) return;
        if(board[i][j] != num ) return;
        if(num == 0) return;
        vis[i][j] = true;
        for(int d = 0; d < 4; d++){
            int nx = i + dx[d];
            int ny = j + dy[d];
            //경계판단
            if(nx < 0 || nx >= M || ny < 0 || ny >= N ) continue;
            // 방문했거나 나랑 같은 숫자가 아니면 컨티뉴
            if(vis[nx][ny] || board[nx][ny] != num) continue;
            ++area;// 면적 증가
            dfs(nx,ny,num);
            
        }
        
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
    //m 이 행 N이 열이다.
        vis = new boolean[m][n];
        board = picture;
        N = n;
        M = m;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                vis[i][j] = false;
            }
        }//end j
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] || picture[i][j] == 0) continue;
                area = 1;
                ++numberOfArea;
                dfs(i,j,picture[i][j]);
                maxSizeOfOneArea = maxSizeOfOneArea < area? area : maxSizeOfOneArea;
            }
        }// end j
        
        
        
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}