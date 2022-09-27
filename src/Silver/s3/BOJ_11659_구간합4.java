package Silver.s3;

import java.util.Scanner;

public class BOJ_11659_구간합4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N + 1]; // 누적합을 담을 배열
		for (int i = 1; i <= N; i++)
			arr[i] = arr[i - 1] + sc.nextInt();
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			// s~e까지의 합은 e까지의 누적합에서 e-1까지의 누적합을 빼면됨
			sb.append(arr[e] - arr[s - 1]).append("\n");

		}

		System.out.print(sb);
	}

}
