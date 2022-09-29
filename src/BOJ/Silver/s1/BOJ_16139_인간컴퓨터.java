package BOJ.Silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139_인간컴퓨터 {

	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		arr = new int[input.length() + 1][26];

		for (int i = 1; i <= input.length(); i++) {
			for (int j = 0; j < 26; j++) {
				arr[i][j] = arr[i - 1][j];
			}
			arr[i][input.charAt(i - 1) - 'a'] += 1;
		} // 알파벳 기준으로 누적합하기

		StringBuilder sb = new StringBuilder();

		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = st.nextToken().charAt(0) - 'a';
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(arr[e + 1][key] - arr[s][key]).append("\n");
		}
		System.out.print(sb);

	}

}
