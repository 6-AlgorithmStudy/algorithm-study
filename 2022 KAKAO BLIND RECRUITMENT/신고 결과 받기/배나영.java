import java.util.*;

class Solution {
	static int N;
	static boolean[][] board;
	static int[] picked;
	static int[] alerted;

	public int[] solution(String[] id_list, String[] report, int k) {
		N=id_list.length;
		board=new boolean[N][N];
		picked=new int[N];
		alerted=new int[N];

		for(String r: report) {
			StringTokenizer st = new StringTokenizer(r, " ");
			int from = getIdx(st.nextToken(), id_list);
			int to = getIdx(st.nextToken(), id_list);
			board[from][to] = true;
		}

		checkPick();
		checkAlert(k);
		return alerted;

	}

	private static int getIdx(String name, String[] idList){
		for(int i=0;i<idList.length;i++){
			if(name.equals(idList[i])) return i;
		}

		return -1;
	}

	private static void checkAlert(int k){
		for(int j=0;j<N;j++){
			if(picked[j]>=k){
				for(int i=0;i<N;i++){
					if(board[i][j]) alerted[i]++;
				}
			}
		}
	}

	private static void checkPick(){

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(board[i][j]){
					picked[j]++;
				}
			}
		}
	}
}