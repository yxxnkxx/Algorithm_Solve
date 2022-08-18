package Silver.s3;

import java.util.Scanner;

public class BOJ_2559_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// K개의 합, index가 1 증가할 때마다 새로운 값 - 맨 앞 값만큼 sum이 변함
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}

		int idx = K;
		int tmp = sum;
		while (idx < N) {
			tmp = tmp + arr[idx] - arr[idx - K];
			sum = Math.max(sum, tmp);
			idx++;
		}
		System.out.println(sum);
	}

}
