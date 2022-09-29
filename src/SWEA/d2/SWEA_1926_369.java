package SWEA.d2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SWEA_1926_369 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String pattern369 = "[0124578]*[369]+[0124578]*";
		Pattern pattern = Pattern.compile(pattern369);

		for (int i = 1; i <= N; i++) {
			String temp = Integer.toString(i);
			Matcher matcher = pattern.matcher(temp);
			if (matcher.matches()) {
				for (int j = 0; j < temp.length(); j++) {
					if (temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
						System.out.print("-");
					}
				}
				System.out.print(" ");
			} else {
				System.out.print(temp + " ");
			}
		}
	}

}
