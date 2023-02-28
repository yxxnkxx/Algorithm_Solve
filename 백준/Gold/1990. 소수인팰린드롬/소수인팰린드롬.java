
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 에라토스테네스의 체 -> 팰린드롬 검사
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[b+1];
        for (int i=2; i<=b; i++) {
            if (!arr[i]) {
                for (int j=i*2; j<=b; j+=i) {
                    arr[j]=true;
                }
            }
        } // 에라토스테네스의 체
        StringBuilder sb = new StringBuilder();
        for (int i=a; i<=b; i++){
            if (!arr[i]) {
                // 팰린드롬 확인하기
                if (check(i)) sb.append(i).append("\n");
            }
        }
        sb.append(-1);

        System.out.println(sb);


    }

    static boolean check(int i) {
        String str = String.valueOf(i);
        int length = str.length();
        for (int j=0; j<str.length()/2; j++) {
            if (str.charAt(j)!=str.charAt(length-1-j)) return false;
        }
        return true;
    }
}
