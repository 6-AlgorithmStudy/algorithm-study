/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		 Scanner sc = new Scanner(System.in);
        
        int Tc = sc.nextInt();
        int[] price = new int[4];
        int day = 0,month = 1, tremonth = 2, year = 3;
        int[] plan = new int[13];
        int min = 0;
        Queue<int[]> Q = new LinkedList<>();
        for(int tc = 1; tc <= Tc; tc++) {
            price[day] = sc.nextInt();
            price[month] = sc.nextInt();
            price[tremonth] = sc.nextInt();
            price[year] = sc.nextInt();
            min = price[year];
            for(int i = 1; i <= 12; i++){
                plan[i] = sc.nextInt();
            }//end i(plan input)
            //첫번째가 달 두번째가 총 비용
            int[] temp = {1,0};
           	Q.offer(temp);
            //start bfs
           	 while(!Q.isEmpty()){
                 int[] tmp = Q.poll();
                 if(tmp[0] > 12){//만약에 12개월을 넘어버리면 
                     min = min > tmp[1] ? tmp[1] : min;
                     continue;
                 }
                 if(min < tmp[1]){// 만약 1년권이나 최솟값보다 커버리면 컨티뉴
                     continue;
                 }
                 //일권끊었을때
                 temp = new int[2];
                 temp[0] =tmp[0]+1;
                 temp[1] = tmp[1] + (plan[tmp[0]] * price[day]);
                 Q.offer(temp);
                 //System.out.println("일권 : " + Arrays.toString(temp));
                 //달권끊었을때
                 temp = new int[2];
                 temp[0] = tmp[0]+1;
                 temp[1] =tmp[1] + price[month];
                 Q.offer(temp);
                 //System.out.println("달권 : " + Arrays.toString(temp));
                 //3달권
                 temp = new int[2];
                 temp[0] = tmp[0]+3;
                 temp[1] = tmp[1]+price[tremonth];
                 Q.offer(temp);
                // System.out.println("3달권 : " + Arrays.toString(temp));
             }
            
            System.out.println("#" + tc + " " + min);
            
        }//end tc
	}
}