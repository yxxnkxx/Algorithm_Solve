package BOJ.Silver.s5;

import java.util.Scanner;

public class BOJ_11723_집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int num = 0;
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			String comm = sc.next();
			int x = 0;
			if (!comm.equals("all") && !comm.equals("empty"))
				x = sc.nextInt();
			switch (comm) {
			case "add":
				num = num | (1 << x);
				break;
			case "remove":
				num = num & (~(1 << x));
				break;
			case "check":
				if ((num & (1 << x)) == 0)
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
				break;
			case "toggle":
				num = (num ^ (1 << x));
				break;
			case "all":
				num = (1 << 21) - 1;
				break;
			case "empty":
				num = 0;
				break;
			}
		}
		System.out.print(sb);
	}

}
