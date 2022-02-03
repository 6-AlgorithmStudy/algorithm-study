package programmers;

import java.util.Arrays;

public class 가장큰수 {
	public static String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        // 내림차순 정렬
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        
        if (str[0].equals("0")) return "0";
        
        for (String s : str) answer += s;
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] n1 = {6, 10, 2};
		int[] n2 = {3, 30, 34, 5, 9};
		
		System.out.println(solution(n1));
	}
}
