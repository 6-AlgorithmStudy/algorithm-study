class Solution {
    // 전역 변수
    static int area;
    static int maxsize;
    // 한 영역의 수를 저장하는 변수.
    static int temp_cnt = 0;
    // 상,하,좌,우 배열.
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int[] solution(int n, int m, int[][] picture) {
        area =0;
        maxsize=0;
        int[] answer = new int[2];
        answer[0] = area;
        answer[1] = maxsize;

        // 방문여부 체크 배열.
        boolean[][] check = new boolean[n][m];

        // 배열 탐색.
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                // 0이 아니고, 방문 X
                if(picture[i][j] != 0 && !check[i][j]){
                    // 1씩 증가하며 DFS 탐색
                    area++;
                    dfs(i,j,picture,check);
                }
                // 한 영역의 탐색이 모두 끝나면 조건에 따라 최대 영역의 수 변경.
                if(temp_cnt > maxsize) maxsize = temp_cnt;
                // 한 영역의 수는 다시 초기화.
                temp_cnt = 0;
            }
        }

        // answer 배열에 담아주고 끝.
        answer[0] = area;
        answer[1] = maxsize;

        return answer;
    }

    public static void dfs(int x,int y, int[][] picture, boolean[][] check){
        // 방문한 적 있는 좌표라면 DFS 종료.
        if(check[x][y]) return;

        // 처음 방문 시 방문처리.
        check[x][y] = true;
        // 영역의 수 증가.
        temp_cnt++;

        // 한 좌표에서 상,하,좌,우 탐색.
        for(int i =0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // picture 배열의 범위를 벗어나면 continue.
            if(nx<0 || nx>=picture.length || ny<0 || ny>=picture[0].length) continue;

            // 현 좌표의 색 == 상,하,좌,우 좌표의 색 && 방문한적 없는 상,하,좌,우 좌표라면
            if(picture[x][y] == picture[nx][ny] && !check[nx][ny]){
                // DFS를 위한 재귀호출
                dfs(nx,ny,picture,check);
            }
        }
    }
}