package BOJ0723;

import java.util.Scanner;

public class BOJ_1065_한수 {

	public static boolean check(int num) {
		String str = Integer.toString(num);
		char[] nums = str.toCharArray();

		if (nums.length == 1) {
			return true;
		}

		int dis = nums[0] - nums[1];

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] - nums[i + 1] != dis) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (check(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
