package BOJ.Silver.s3;

import java.util.Scanner;

public class BOJ_3273_두수의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] arr = new boolean[1000001];
		for (int i = 0; i < N; i++)
			arr[sc.nextInt()] = true;
		int x = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i < 1000001; i++) {
			if (arr[i] == true && (x - i) <= 1000000 && (x - i) >= 0 && arr[x - i] == true) {
				cnt++;
			}
		}
		System.out.println(cnt / 2);

	}

}
