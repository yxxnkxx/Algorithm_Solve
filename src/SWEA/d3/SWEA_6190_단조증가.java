package SWEA.d3;

import java.util.Scanner;

public class SWEA_6190_단조증가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			int result = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int tmp = arr[i] * arr[j];
					if (tmp > result && isIncrease(tmp))
						result = tmp;
				}
			}

			sb.append("#" + (t + 1) + " " + result + "\n");
		}
		System.out.print(sb.toString());
	}

	static boolean isIncrease(int num) {
		String str = Integer.toString(num);
		if (num < 10)
			return true;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) > str.charAt(i + 1))
				return false;
		}
		return true;
	}

}
