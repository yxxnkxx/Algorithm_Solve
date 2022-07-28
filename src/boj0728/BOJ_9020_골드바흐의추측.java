package boj0728;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_9020_골드바흐의추측 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N + 1];
			for (int i = 2; i < N; i++)
				arr[i] = i; // i로 초기화

			for (int i = 2; i < N; i++) {
				if (arr[i] == 0) // 이미 지워진거면 pass
					continue;
				for (int j = i * 2; j < N; j += i)
					// i의 배수를 찾아서 지움, 이때 i는 제외
					arr[j] = 0;
			}

			Set<Integer> nums = new HashSet<>();
			for (int i = 2; i < N; i++) {
				if (arr[i] != 0)
					nums.add(i);
			} // 소수의 리스트들

			String result = "";
			int dis = N;

			for (Integer num : nums) {
				int other = N - num;
				if (nums.contains(other) && dis > (Math.abs(num - other))) {
					if (num < other) {
						result = num + " " + other;

					} else {
						result = other + " " + num;
					}
					dis = Math.abs(num - other);

				}
			}

			System.out.println(result);
		}
	}
}
