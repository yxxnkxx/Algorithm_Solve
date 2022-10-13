import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		int dis = 0;
		int day = 1;

		day += (V - A) / (A - B);
		if ((V - A) % (A - B) != 0) {
			day++;
		}
		System.out.println(day);

	}

}