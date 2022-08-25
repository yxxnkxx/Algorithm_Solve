package Silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer input = new StringTokenizer(br.readLine());
		int[] arr = new int[20000001];
		for (int i = 0; i < N; i++)
			arr[Integer.parseInt(input.nextToken()) + 10000000]++;
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int k = Integer.parseInt(st.nextToken());
			sb.append(arr[k + 10000000]).append(" ");
		}
		System.out.println(sb.toString());

	}

}
