import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = sc.nextInt();
			int[][] arr = new int[2][N];
			for (int i = 0; i < 2; i++)
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			if (N > 1) {
				arr[0][1] += arr[1][0];
				arr[1][1] += arr[0][0];
			}
			for (int i = 2; i < N; i++) {
				arr[0][i] = Math.max(arr[1][i - 1], Math.max(arr[0][i - 2], arr[1][i - 2])) + arr[0][i];
				arr[1][i] = Math.max(arr[0][i - 1], Math.max(arr[0][i - 2], arr[1][i - 2])) + arr[1][i];
			}
			sb.append(Math.max(arr[0][N - 1], arr[1][N - 1])).append("\n");
		}
		System.out.println(sb);
	}

}