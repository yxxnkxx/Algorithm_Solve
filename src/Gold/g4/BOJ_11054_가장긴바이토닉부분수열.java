package Gold.g4;

import java.util.Scanner;

public class BOJ_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] increase = new int[N];
		int[] decrease = new int[N];

		for (int i = 0; i < N; i++) {
			increase[i] = 1;
			decrease[i] = 1;
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < N; i++)
			for (int j = 0; j < i; j++)
				if (arr[j] < arr[i])
					increase[i] = Math.max(increase[i], increase[j] + 1);

		for (int i = N - 2; i >= 0; i--)
			for (int j = N - 1; j > i; j--)
				if (arr[i] > arr[j])
					decrease[i] = Math.max(decrease[i], decrease[j] + 1);

		int ans = 0;
		for (int i = 0; i < N; i++)
			ans = Math.max(increase[i] + decrease[i] - 1, ans);
		System.out.println(ans);

	}
}
