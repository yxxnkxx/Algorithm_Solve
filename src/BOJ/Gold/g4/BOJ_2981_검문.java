package BOJ.Gold.g4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2981_검문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int val = arr[1] - arr[0];
		for (int i = 1; i < N; i++) {
			val = gcd(val, arr[i] - arr[i - 1]);
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i * i <= val; i++)
			if (val % i == 0) {
				list.add(i);
				if (val / i != i)
					list.add(val / i);
			}
		Collections.sort(list);
		list.remove(0);
		for (int num : list)
			System.out.print(num + " ");
	}

	static int gcd(int a, int b) {

		while (b > 0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}

}
