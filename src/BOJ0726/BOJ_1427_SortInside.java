package BOJ0726;

import java.util.Scanner;

public class BOJ_1427_SortInside {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int[] count = new int[10];
		for (int i = 0; i < input.length(); i++) {

			int c = input.charAt(i) - '0';
			count[c]++;
		}

		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < count[i]; j++) {
				System.out.print(i);
			}
		}

	}

}
