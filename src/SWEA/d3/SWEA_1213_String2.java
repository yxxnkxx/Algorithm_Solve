package SWEA.d3;

import java.util.Scanner;

public class SWEA_1213_String2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int T = sc.nextInt();

			// pattern의 길이 n-1-charAt(i) : skip할 크기
			String pattern = sc.next();
			String find = sc.next();
			int patternIdx = 0;
			int findIdx = 0;
			int cnt = 0;
			while (findIdx < find.length()) {
				if (find.charAt(findIdx) == pattern.charAt(patternIdx)) {

					if (patternIdx == pattern.length() - 1) {
						cnt++;
						findIdx++;
						patternIdx = 0;
					} else {
						patternIdx++;
						findIdx++;
					}
				} else {
					if (patternIdx > 0)
						patternIdx--;
					else {
						findIdx++;
					}
				}
			}
			System.out.println("#" + T + " " + cnt);

		}
	}

}
