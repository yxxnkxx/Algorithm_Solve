package Silver.s4;

import java.util.Scanner;

public class BOJ_10158_개미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		int P = sc.nextInt();
		int Q = sc.nextInt();
		int T = sc.nextInt();

		// x가 0일 때, W가 6이라면 0 1 2 3 4 5 6 5 4 3 2 1 0 .. -> 2*W 주기
		// x가 1이라면 1 2 3 ... x가 2라면 2 3 4 ...
		// -> 현재 좌표 + 시간을 주기로 나눈 나머지
		int x = (P + T) % (2 * W);
		int y = (Q + T) % (2 * H);

		x = (x <= W) ? x : 2 * W - x; // x가 W보다 작으면 증가하는 주기, 감소하는 경우만 따로 처리
		y = (y <= H) ? y : 2 * H - y;
		System.out.println(x + " " + y);
	}

}
