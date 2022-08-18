package Bronze.b1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10163_색종이 {
	static int[][] arr = new int[1001][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 1001; i++) {
			Arrays.fill(arr[i], -1);
		}
		int N = sc.nextInt();
		int[] area = new int[N];
		for (int n = 0; n < N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			for (int i = x; i < x + width; i++)
				for (int j = y; j < y + height; j++)
					arr[i][j] = n;

		}

		for (int i = 0; i < 1001; i++)
			for (int j = 0; j < 1001; j++)
				if (arr[i][j] != -1)
					area[arr[i][j]]++;

		for (int i = 0; i < area.length; i++)
			System.out.println(area[i]);
	}

}
