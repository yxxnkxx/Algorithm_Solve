import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L, C;
	static String[] arr;
	static String[] result;
	static String vowels = "aeiou";
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new String[C];
		result = new String[L];
		for (int i = 0; i < C; i++)
			arr[i] = sc.next();
		Arrays.sort(arr);
		comb(0, 0, 0, 0);

		System.out.println(sb);
	}

	static void comb(int length, int start, int v, int c) {
		if (length == L && v >= 1 && c >= 2) {
			// 최소 모음1, 자음2
			for (int i = 0; i < L; i++)
				sb.append(result[i]);
			sb.append("\n");
			return;
		} else if (length == L)
			return;

		for (int i = start; i < C; i++) {
			result[length] = arr[i];
			if (vowels.contains(arr[i]))
				comb(length + 1, i + 1, v + 1, c);
			else
				comb(length + 1, i + 1, v, c + 1);
		}
	}
}