package SWEA.d3;

import java.util.Scanner;

public class SWEA_1289_메모리복구 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int cnt = 0;
			char[] input = sc.next().toCharArray();
			if (input[0] == '1')
				cnt++;
			for (int i = 1; i < input.length; i++) {
				if (input[i - 1] != input[i])
					cnt++;
			}
			System.out.println("#" + t + " " + cnt);

		}
	}

}
