class Solution {
    static int[][] board;
    public int solution(int m, int n, int[][] puds) {
        int answer = 0;
        int mod = 1000000007;
        board = new int[n+1][m+1];
        for(int[] p : puds){
            board[p[1]][p[0]] = -1;
        }// end pud input
        
        board[1][1] = 1;
        
        for(int i= 1; i<= n; i++) {
            for(int j = 1; j<=m; j++) {
                if(i == 1 && j== 1) continue;
                else if(board[i][j] == -1) board[i][j] = 0;
                else{
                    board[i][j] += (board[i-1][j]%mod + board[i][j-1]%mod);
                }
            }
        }// end dp
        
        // for(int [] a : board){
        //     for(int b : a){
        //         System.out.print(b + " ");
        //     }
        //     System.out.println();
        // }
        
        
        return answer = board[n][m]%mod;
    }
}