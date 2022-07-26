package BOJ0726;

import java.util.Scanner;

public class BOJ_1316_GroupWordChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int n = 0; n < N; n++) {
			boolean check = false;
			boolean isGroup = true;

			String input = sc.next();
			for (int i = 0; i < input.length() - 1; i++) {
				if (input.charAt(i) != input.charAt(i + 1)) {
					for (int j = i + 1; j < input.length(); j++) {
						if (input.charAt(i) == input.charAt(j)) {
							check = true;
						}
					}
					if (check) {
						isGroup = false;
						break;
					}
				}
			}
			if (isGroup) {
				cnt++;
				check = false;

			}
		}
		System.out.println(cnt);
	}

}
