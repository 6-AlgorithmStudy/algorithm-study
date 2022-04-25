import java.util.Scanner;
import java.util.Stack;

public class Solution_백만장자프로젝트 {
	
	static int N;
	static int TC;
	static Stack<Long> stack;
	static long result;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		TC=sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			N=sc.nextInt();
			stack=new Stack<>();
			result=0;
			
			// stack에 데이터 저장
			for(int n=0;n<N;n++) {
				int input=sc.nextInt();
				stack.push((long) input);
			}
			
			long max=stack.pop();
			
			while(!stack.isEmpty()) {
				long price=stack.pop();
				
				if(max<price) { // 팔기
					max=price;
				}
				else { // 사기
					result += (max-price);
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
