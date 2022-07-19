package BOJ0719;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		Arrays.sort(arr);
		label: for (int i = 1; i < 9; i++) {
			for (int j = 0; j < i; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					int idx = 0;
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							System.out.println(arr[k]);
						}
					}
					break label;
				}
			}

		}

	}

}
