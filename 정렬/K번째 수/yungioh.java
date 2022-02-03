import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
	/**
	1. i번째에서 j번째까지 짜르기
	2. 오름차순으로 버블정렬 후 k번째 수 return
	*/
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] input = copyArr(array,commands[i][0], commands[i][1]);
            //System.out.println(Arrays.toString(input));
            answer[i] = bubbleSort(input, commands[i][2]);
        }
        
        return answer;
    }
    
    public int[] copyArr(int[] origin, int start, int end){
        int[] tmp = new int[end-start+1];
        for(int i = start; i<=end; i++)
            tmp[i-start] = origin[i-1];
        return tmp;
    }
    
    public int bubbleSort(int[] arr, int target){
        int tmp;
        for(int i = arr.length-1 ; i>0; i--){ 
            for(int j = 0; j<i; j++){
                if(arr[j]>arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        //System.out.println(Arrays.toString(arr));
        return arr[target-1];
    }
}