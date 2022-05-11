import java.util.*;

public class Solution_카카오프렌즈_컬러링북 {
    static boolean[][] visited; // 방문 처리
    static int numberOfArea; // 영역의 개수 세어줌
    static int maxSizeOfOneArea; // 제일 넓은 영역이 몇 칸인지 세어줌
    static int count; // 한 영역 방문했을 때 몇 칸 째인지 세어줌

    static int[] di={0,1,0,-1};
    static int[] dj={1,0,-1,0};
    static int M, N;

    public static int[] solution(int m, int n, int[][] picture) {

        visited=new boolean[picture.length][picture[0].length];
        M=m;
        N=n;
        numberOfArea=0;
        maxSizeOfOneArea=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]>0 && !visited[i][j]){
                    count=0;
                    dfs(picture, i, j);
                    numberOfArea++;
                }
            }
        }

        // 결과 출력
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static void dfs(int[][] picture, int i, int j){

        // 방문 처리
        visited[i][j]=true;
        count++;

        // 지금까지 방문한 칸의 개수가 영역 최대 사이즈보다 크면 maxSizeOfOneArea에 저장
        if(count>maxSizeOfOneArea){
            maxSizeOfOneArea=count;
        }

        // 모든 방향에 대해서 갈 수 있는 같은 영역은 방문해준다
        for(int dir=0; dir<4; dir++){
            int ni=i+di[dir];
            int nj=j+dj[dir];

            // 방문한 적 없고, 지금의 색깔과 같은 경우에 방문
            if(ni>=0 && nj>=0 && ni<M && nj<N && !visited[ni][nj] && picture[ni][nj]==picture[i][j]){
                dfs(picture, ni, nj);
            }
        }
    }

    public static void main(String[] args) {

        int[][] picture = new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}};

        int[] result = solution(6, 4, picture);
        System.out.println(result[0]); // numberOfArea
        System.out.println(result[1]); // maxSizeOfOneArea
    }

}
