package hashStudy;
//https://www.acmicpc.net/problem/15829

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_Hashing2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long r = 31;
		long M = 1234567891;
		int leng = Integer.parseInt(br.readLine());
		String input = br.readLine().toString();
		long a = 'a';
		long answer = 0;
		String aa ="1234";
		long arr[] = new long[50];
		arr[0] = 31;
		for(int i = 0; i < leng; i++) {
			char ch = input.substring(i,i+1).charAt(0);
			long ch1 = ch;
			long tmp = ch1 -  a + 1;
			
//			int tmp = Integer.parseInt(aa) - a + 1;
			if(i == 0) {
				arr[0] = 1;
				long rr = arr[0] % M;
				
				answer += tmp *  rr;
			}else {
				arr[i] = arr[i-1] * 31 % M;
				//answer += 을 answer = answer + 로 고치니까 해결된다. 
				answer =(answer +  tmp * arr[i]) % M;
			}
//			System.out.println(answer);
		}
		System.out.println(answer);
		
	}
}
