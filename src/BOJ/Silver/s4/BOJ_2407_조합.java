package BOJ.Silver.s4;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407_조합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = new BigInteger(Integer.toString(sc.nextInt()));
		BigInteger m = new BigInteger(Integer.toString(sc.nextInt()));
		BigInteger cnt = new BigInteger("0");
		BigInteger result = new BigInteger("1");

		while (cnt.compareTo(m) < 0) {
			result = result.multiply(n);
			cnt = cnt.add(BigInteger.ONE);
			n = n.subtract(BigInteger.ONE);

		}
		while (m.compareTo(BigInteger.ZERO) > 0) {
			result = result.divide(m);
			m = m.subtract(BigInteger.ONE);
		}
		System.out.println(result.toString());
	}

}
