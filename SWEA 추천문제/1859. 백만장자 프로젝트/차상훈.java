package SW_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class sw_1859_백만장자프로젝트 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws Exception {
		input = new BufferedReader(new StringReader(src));
		int tc = Integer.parseInt(input.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(input.readLine());
			int arr[] = new int[n];
			tokens = new StringTokenizer(input.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(tokens.nextToken());
			}

			int maxvalue = 0;
			long total = 0;

			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] >= maxvalue) {
					maxvalue = arr[i];
				} else {
					total += maxvalue - arr[i];
				}
			}
			System.out.println("#" + t + " " + total);
		}
	}

	private static String src = "3\r\n" + "3\r\n" + "10 7 6\r\n" + "3\r\n" + "3 5 9\r\n" + "5\r\n" + "1 1 3 1 2";
}
