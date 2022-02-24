class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 전체 맵
        int load[][] = new int[n+1][m+1];
        
        // 웅덩이의 배열만큼 반복문을 돌며 웅덩이는 -1
        for(int i=0; i<puddles.length; i++){
            load[puddles[i][1]][puddles[i][0]]=-1;
        }
        
        // 시작점
        load[1][1]=1;
        
        // 이중 반복문
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                // 웅덩이 만날때 0으로 바꿔주고 돌아감
                if(load[i][j]==-1){
                    load[i][j]=0;
                    continue;
                }
                // i의 값이 0이 아니라면 위쪽값을 load에 더함
                if(i!=1) {
                    load[i][j]+=load[i-1][j]%1000000007;
                }
                // j의 값이 0이 아니라면 왼쪽값을 load에 더함
                if(j!=1) {
                    load[i][j]+= load[i][j-1] % 1000000007;
                }
            }
        }
        // 최종값을 리턴
        return load[n][m]%1000000007;
    }
}