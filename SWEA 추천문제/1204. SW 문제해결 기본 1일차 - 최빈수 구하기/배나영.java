import java.util.Scanner;

public class Solution_최빈수구하기 {

	static int TC;
	static int[] grade;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		TC=sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			int num=sc.nextInt();
			grade=new int[101];
			
			for(int i=0;i<1000;i++) {
				int input=sc.nextInt();
				grade[input]++;
			}
			
			int maxVal=-1;
			int maxIdx=-1;
			
			for(int i=0;i<=100;i++) {
				if(grade[i]>=maxVal) {
					maxVal=grade[i];
					maxIdx=i;
				}
			}
			
			System.out.println("#"+tc+" "+maxIdx);
		}
	}
}
