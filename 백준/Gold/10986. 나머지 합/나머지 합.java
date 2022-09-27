
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] res = new long[N];

		long[] cnt = new long[M];
		cnt[0] = 1;
		st = new StringTokenizer(br.readLine());
		res[0] = Long.parseLong(st.nextToken()) % M;
		cnt[(int) res[0]]++;
		for (int i = 1; i < N; i++) {
			res[i] = (res[i - 1] + Long.parseLong(st.nextToken())) % M;
			cnt[(int) res[i]]++;
		}

		long ans = 0;
		for (int i = 0; i < M; i++)
			ans += cnt[i] * (cnt[i] - 1) / 2;
		System.out.println(ans);

	}
}
