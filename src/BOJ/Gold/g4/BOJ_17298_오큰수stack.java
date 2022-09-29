package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수stack {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N];
		int[] origin = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			origin[i] = Integer.parseInt(st.nextToken());
		Stack<Integer> nge = new Stack<>();

		for (int i = N - 1; i >= 0; i--) {
			int n = origin[i];

			while (!nge.isEmpty() && nge.peek() <= n) // nge가 비어있지 않고 nge의 peek가 n보다 작거나 같으면 pop
				nge.pop();
			if (nge.isEmpty()) // pop한 후에 nge가 비어있으면 -1
				result[i] = -1;
			else if (nge.peek() > n) { // peek가 크면 오큰수
				result[i] = nge.peek();

			}

			nge.push(n);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(result[i] + " ");
		System.out.println(sb.toString());
	}

}