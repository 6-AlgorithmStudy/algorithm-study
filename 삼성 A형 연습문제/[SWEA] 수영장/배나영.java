import java.util.Scanner;

public class Solution_수영장 {
	
	static int TC;
	static int dayCost; // 1일권
	static int monthCost; // 1달권
	static int month3Cost; // 3달권
	static int yearCost; // 1년권
	static int[] useDate; // 해당 달에 며칠이나 사용할 건지
	static int[] minCost; // 해당 달의 최소 비용
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		TC=sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) { // 각각 테케마다
			
			// 입력 시작
			dayCost=sc.nextInt();
			monthCost=sc.nextInt();
			month3Cost=sc.nextInt();
			yearCost=sc.nextInt();
			minCost=new int[13];
			useDate=new int[13];
			
			for(int i=1; i<13; i++) {
				useDate[i]=sc.nextInt();
				minCost[i]=-1; // -1로 아직 계산 안 한 월 나타냄
			}
			
			// 입력 끝
			
			int result = getMinCost(1); // 1월부터 최소 비용 가져옴
			result=Math.min(result, yearCost); // 1년권과 비교
			
			System.out.println("#"+tc+" "+result); // 출력
		}
	}
	
	static int getMinCost(int month) {
		
		if(month>=13) return 0; // 12월 뒤로는 없으므로 0
		
		if(minCost[month]==-1) { // 최소 비용 아직 계산 안 했다면
			
			minCost[month]=calCost(month); // 최소 비용 계산
			
		}
		
		return minCost[month];
	}
	
	static int calCost(int month) { // 해당 월의 최소 비용 계산해서 리턴
		
		int result=Integer.MAX_VALUE;
		
		result=Math.min(result, useDate[month]*dayCost+getMinCost(month+1)); // 1일권 비교
		result=Math.min(result, monthCost+getMinCost(month+1)); // 1달권 비교
		result=Math.min(result, month3Cost+getMinCost(month+3)); // 3달권 비교
		
		return result;
		
	}

}
