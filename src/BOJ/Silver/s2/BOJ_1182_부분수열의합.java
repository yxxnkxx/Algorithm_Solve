package BOJ.Silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int[] arr;
	static int N, S;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		StringTokenizer input = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(input.nextToken());
		// 입력
		findSum(0, 0);
		if (S == 0)
			cnt--; // 공집합 제외

		System.out.println(cnt);
	}

	static void findSum(int idx, int sum) {
		if (idx == N) {
			if (sum == S) {
				cnt++;
			}
			return;
		}
		findSum(idx + 1, sum + arr[idx]); // 포함하기
		findSum(idx + 1, sum); // 포함 안하기
		// 공집합은 빼야됨..
	}

}
