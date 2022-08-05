package BOJ0805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_6588_골드바흐의추측 {

	static boolean[] isNotPrime = new boolean[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		for (int i = 2; i < 1000001; i++) {
			if (isNotPrime[i]) // 이미 지워진거면 pass
				continue;
			for (int j = i * 2; j < 1000001; j += i)
				// i의 배수를 찾아서 지움, 이때 i는 제외
				isNotPrime[j] = true;
		}

		while (N != 0) {
			for (int i = 2; i < N; i++) {
				if (!isNotPrime[i] && !isNotPrime[N - i]) {
					bw.write(N + " = " + i + " + " + (N - i));
					bw.newLine();
					break;
				}
			}

			N = Integer.parseInt(br.readLine());
		}
		bw.flush();
	}
}
