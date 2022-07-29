package BOJ0729;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2447_별찍기10 {
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = (int) Math.sqrt(N);
		int cnt = 1;
		String[] init = { "*" };
		String[] result = star(cnt, init);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (String str : result) {
			bw.write(str);
			bw.write("\n");
		}
		bw.flush();

	}

	static String[] star(int cnt, String[] str) {

		int length = (int) (Math.pow(3, cnt));
		String[] strs = new String[length];
		for (int i = 0; i < length; i++) {
			strs[i] = "";
		}

		// 이걸 3으로 나눠서 각 부분을 처리해야됨
		for (int i = 0; i < 3; i++) {
			// 3으로 나눈 각 부분은 length/3만큼의 길이를 가짐
			for (int j = 0; j < str.length; j++) {
				if (i == 1) {
					strs[i * length / 3 + j] += str[j];
					for (int k = 0; k < length / 3; k++) {
						strs[i * length / 3 + j] += " ";
					}
					strs[i * length / 3 + j] += str[j];
				} else {
					for (int k = 0; k < 3; k++) {
						strs[i * length / 3 + j] += str[j];
					}
				}
			}

		}
		if (length == N) {
			return strs;
		} else {
			return star(++cnt, strs);
		}

	}

}
