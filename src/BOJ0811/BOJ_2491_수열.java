package BOJ0811;

import java.util.Scanner;

public class BOJ_2491_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int result = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int increase = 1;
		int decrease = 1;

		for (int i = 1; i < N; i++) {

			if (arr[i - 1] == arr[i]) {
				increase++;
				decrease++;
				continue;
			}
			if (arr[i - 1] < arr[i]) {
				increase++;
				if (result < decrease)
					result = decrease;
				decrease = 1;
			} else {
				decrease++;
				if (result < increase)
					result = increase;
				increase = 1;
			}

		}

		if (result < increase)
			result = increase;
		if (result < decrease)
			result = decrease;

		System.out.println(result);

	}

}
