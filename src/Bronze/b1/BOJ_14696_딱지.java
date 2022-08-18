package Bronze.b1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14696_딱지 {
	static int[] checkA = new int[5];
	static int[] checkB = new int[5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		label: for (int n = 0; n < N; n++) {
			Arrays.fill(checkA, 0);
			Arrays.fill(checkB, 0);
			int numA = sc.nextInt();
			for (int i = 0; i < numA; i++)
				checkA[sc.nextInt()]++;
			int numB = sc.nextInt();
			for (int i = 0; i < numB; i++)
				checkB[sc.nextInt()]++;

			for (int i = 4; i >= 0; i--) {
				if (checkA[i] > checkB[i]) {
					System.out.println("A");
					continue label;
				} else if (checkA[i] < checkB[i]) {
					System.out.println("B");
					continue label;
				}

			}
			System.out.println("D");
		}

	}
}
