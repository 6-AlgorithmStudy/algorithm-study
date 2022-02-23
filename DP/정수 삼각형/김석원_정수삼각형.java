/*
풀이전략 : 
tri[n][k] = tri[n-1][k-1] 과 tri[n-1][k] 중 큰수 + tri[n][k]
단 0< k < n 그리고 0 < n
*/
class Solution {
    public int solution(int[][] triangle) {
        
        int answer = 0;
        int N = triangle.length;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                int adder = 0;
                //아래 if조건에서 0 <= j-1에서 '='빼먹어서 디버깅 오래함,,,
                if( (0 <= j-1 && j-1 < i) && (i-1 > 0 && j != i)){
                    //선택권이 2개일경우 둘중에 큰숫자를 넣는다.
                    adder = triangle[i-1][j-1] > triangle[i-1][j] ? 
                        triangle[i-1][j-1] : triangle[i-1][j];
                    //0번일때는 위의 0번 N번일때는 N-1번밖에 선택을 못한다.
                    triangle[i][j] += adder;
                    continue;
                }else if(j == 0 && i-1 >= 0){
                    adder = triangle[i-1][j];
                }else if(i-1 >= 0){
                    adder = triangle[i-1][j-1];
                }
                triangle[i][j] += adder;
            }/// end j 
        }    // end i
    //      for(int i = 0; i < N; i++) {
    //         for(int j = 0; j <= i; j++) {
    //     System.out.print(triangle[i][j] + " ");
    //         }
    //          System.out.println();
    // }
        
    for(int i = 0 ; i< N; i++) {
        answer = answer > triangle[N-1][i] ? answer : triangle[N-1][i];
    }
    return answer;
    }
   
}