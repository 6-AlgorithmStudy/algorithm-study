class Solution {
    static boolean[][] visited;
    static int AREA, COUNT, M, N, art[][];
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        
        AREA = -1;
        COUNT = 0;
        M = m;
        N = n;
        visited = new boolean[m][n];
        art = new int[m][];
        for(int i = 0; i<m; i++)
            art[i] = picture[i];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    COUNT = 0;
                    dfs(i,j);
                    numberOfArea++;
                    AREA = AREA < COUNT ? COUNT : AREA;
                }
            }
        }
        int maxSizeOfOneArea = AREA;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static int dx[] = {0,-1,0,1};
    static int dy[] = {-1,0,1,0};
    static void dfs(int x, int y){
        COUNT++;
        visited[x][y] = true;
        int pixel = art[x][y];
        for(int d = 0 ; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx <0 || nx >=M || ny <0 || ny >=N || visited[nx][ny]) continue;
            if(pixel == art[nx][ny])
                dfs(nx,ny);
        }
        
    }
}