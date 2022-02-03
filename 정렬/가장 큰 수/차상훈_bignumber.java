package 정렬;

import java.util.*;

public class bignumber {
	public static void main(String[] args) {
		bignumber s= new bignumber();
		int[] numbers = new int[] {6,10,2};
		System.out.println(s.solution(numbers));
	}	
	
	public String solution(int[] numbers) {
		String ans = new String();
        String[] str = new String[numbers.length];
        
        // String 배열로 변경
        for (int i = 0; i < numbers.length; i++) {
			str[i] = Integer.toString(numbers[i]);
		}
        
        // 큰 값을 앞으로 정렬(내림차순 정렬)
//      내림차순 : return (o2+o1).compareTo(o1+o2);
//		오름차순 : return (o1+o2).compareTo(o1+o2);
        Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
        
        // 같은 수가 중복일 경우 그에 대한 처리, 가장 큰 수가 "0"으로 시작할 경우 "0"을 입력하고 종료
        if (str[0].equals("0")) {
			ans +="0";
		}else {
			for (int j = 0; j < str.length; j++) {
				ans += str[j];
			}
		}
        return ans;
    }
	
}
