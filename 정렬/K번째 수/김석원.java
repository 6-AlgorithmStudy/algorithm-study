import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int ii = 0;
        answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int tmp[] = new int[end-start];
            int index = 0;

            for(int cur = start; cur < end; cur++) {
                tmp[index++] = array[cur];
            }// end tmp input
            Arrays.sort(tmp);
            answer[ii++] = tmp[commands[i][2]-1];

        }//end i
        return answer;
    }
}