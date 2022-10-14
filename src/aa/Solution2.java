package aa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution2 {

	static int Ms; // 예치금
	static int Ma; // 월별 불입금액
	static int L; // 과거 데이터 기간 (0~L)
	static int N; // 종목 수
	static int[][] table; // 과거 데이터 기간과 각 종목의 가격
	static int cash; // 가지고 있는 현금

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			table = new int[N][L + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j <= L; j++)
					table[i][j] = Integer.parseInt(st.nextToken());
			}
			// 입력 끝
			int[] profit = new int[N]; // 각 기간 별 수익을 저장하기
			cash = Ms; // 0개월의 원금
			for (int m = 0; m < L; m++) {
				int plus = 0;
				Map<Integer, Integer> map = new HashMap<>(); // key: 수익, value: 인덱스

				for (int i = 0; i < N; i++) {
					profit[i] = table[i][m + 1] - table[i][m]; // 다음 달에 예상되는 수익
					map.put(profit[i], i);
				}

				Arrays.sort(profit);
				// 수익이 높은 것부터 가능한 많이 매수하기
				for (int i = N - 1; i > 0; i--) {
					if (profit[i] > 0) {
						int idx = map.get(profit[i]);
						int buy = cash / table[idx][m]; // 가지고 있는 현금에서 살 수 있는 주식의 개수
						cash -= buy * table[idx][m]; // 매수
						plus += buy * table[idx][m + 1]; // 예상되는 다음달 수익
					}
				}
				// 다음 달로 넘어가기 전에 현금을 미리 더해주기, 월별 불입금액 + 다음 달 매도로 벌 수 있는 수익
				cash += plus;
				cash += Ma;

			}
			int origin = Ms + Ma * L; // 투자 원금
			sb.append("#" + t + " " + (cash - origin)).append("\n");

		}
		System.out.print(sb);

	}
}
