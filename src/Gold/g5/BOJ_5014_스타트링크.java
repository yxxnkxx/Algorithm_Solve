package Gold.g5;

import java.util.Scanner;

public class BOJ_5014_스타트링크 {
	static int F, S, G, U, D;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt(); // +
		D = sc.nextInt(); // -
		
		dfs(S, 0);
		System.out.println(ans);
		
	}
	
	static void dfs(int floor, int cnt) {
		if (ans!=0 && ans < cnt) return;
		
		if (floor>F || floor <0)
			return;
		
		if (floor==G) {
			if (ans==0 || ans > cnt) ans = cnt;
			return;
		}
		
		
		dfs(floor+U, cnt+1);
		dfs(floor-D, cnt+1);
	}
}
