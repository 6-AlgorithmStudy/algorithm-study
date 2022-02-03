import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int max = 0;
        //citations에 답이 없을수가 있다. 이것을 유념하자.
        Arrays.sort(citations);
		System.out.println(Arrays.toString(citations));
        //정렬해서 포문돌려서 인용길이 - 인덱스값이 인용횟수보다 작거나 같으면 최대값 대입해줌
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length - i){
                answer = citations.length - i < answer ? answer : citations.length - i;
            }
           
        }
        return answer;
    }
    
}