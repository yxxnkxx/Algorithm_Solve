package SWEA.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_7102_준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] count = new int[N + M + 1];
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= M; j++)
					count[i + j]++;
			List<Integer> list = new ArrayList<>();
			int max = 0;
			for (int i = 1; i <= N + M; i++)
				if (count[i] > max)
					max = count[i];

			for (int i = 1; i <= N + M; i++)
				if (count[i] == max)
					list.add(i);
			System.out.print("#" + t + " ");
			for (int num : list)
				System.out.print(num + " ");
			System.out.println();
		}
	}

}
