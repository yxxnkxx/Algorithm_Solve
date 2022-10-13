package prg.lv1;

import java.util.Stack;

public class PRG_크레인인형뽑기 {
	public static int solution(int[][] board, int[] moves) {
		int N = board[0].length;
		Stack<Integer>[] stack = new Stack[N];
		for (int i = 0; i < N; i++)
			stack[i] = new Stack<>();

		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != 0) {
					stack[j].add(board[i][j]);
				}
			}
		}
		int ans = 0;
		Stack<Integer> basket = new Stack<>();
		// move
		for (int i = 0; i < moves.length; i++) {
			int move = moves[i] - 1;
			if (!stack[move].isEmpty()) {
				int top = stack[move].pop();
				if (!basket.isEmpty() && basket.peek() == top) {
					ans += 2;
					basket.pop();
				} else
					basket.add(top);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}
}
