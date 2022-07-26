package BOJ0726;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10989_수정렬3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] count = new int[10001];
		for (int i = 0; i < N; i++) {
			count[arr[i]]++;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 10001; i++) {
			for (int j = 0; j < count[i]; j++) {
				bw.write(Integer.toString(i) + "\n");
			}
		}
		bw.close();
	}

}
