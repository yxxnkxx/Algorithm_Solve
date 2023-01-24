import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        int cnt = 0;
        int idx = 0;
        while (idx < P.length()) {
            int end = idx;

            StringBuilder substring = new StringBuilder();
            while (end < P.length() && S.contains(substring.toString() + P.charAt(end))) {
                substring.append(P.charAt(end));
                end++;
            }
            cnt++;
            idx = end;

        }
        System.out.println(cnt);

    }
}