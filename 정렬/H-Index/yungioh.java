class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int max = -1;
        for(int i = 0 ; i< citations.length; i++){
            if(max < citations[i])
                max = citations[i];
        }
        for(int i = 0; i <= max ; i++){
            int h = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[j] >= i)
                    h += 1;
            }
            if(h>=i && citations.length-h <= i)
                answer = i;
        }
        
        return answer;
    }
}