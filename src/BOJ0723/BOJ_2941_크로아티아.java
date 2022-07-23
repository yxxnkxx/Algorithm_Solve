package BOJ0723;

import java.util.Scanner;

public class BOJ_2941_크로아티아 {
	public static void main(String[] args) {
		String[] alphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		boolean check = false;
		String checkStr = "";
		String alphaStr = "";
		int length = input.length();
		int startidx = length - 1;

		for (int i = 0; i < input.length(); i++) {
			checkStr += input.charAt(i);
			for (String str : alphabet) {
				if (checkStr.indexOf(str) != -1) {
					check = true;
					if (startidx > checkStr.indexOf(str)) {
						startidx = checkStr.indexOf(str);
						alphaStr = str;
					} else if (startidx == checkStr.indexOf(str) && alphaStr.length() < str.length()) {
						alphaStr = str;

					}
				}
			}

			if (check) {
				length -= alphaStr.length() - 1;
				checkStr = "";
				check = false;
				alphaStr = "";
				startidx = 100;
			}

		}

		System.out.println(length);
	}

}
