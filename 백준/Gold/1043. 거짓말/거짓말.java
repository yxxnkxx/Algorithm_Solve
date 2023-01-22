import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[][] parties;
    static boolean[] visitParty;
    static boolean[] knowTrue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        parties = new boolean[N + 1][M + 1]; // [사람][파티]

        visitParty = new boolean[M + 1];
        knowTrue = new boolean[N + 1];
        // 사람이 속해있는 파티를 list로 넣어두기 -> 진실을 아는 사람이 속한 파티의 사람들은 모두 진실을 알게 됨
        // 한 번 방문한 파티는 다시 방문X
        int num = sc.nextInt();
        int[] people = new int[num];
        for (int i = 0; i < num; i++) {
            people[i] = sc.nextInt();
        }
//        사람 -> party, 사람을 돌면서 어떤 party에 속해있는지 확인 -> 해당 party에 속한 모든 사람들을 true로 바꾸고 각각 파티를 또 확인

        for (int i = 1; i <= M; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                int p = sc.nextInt();
                parties[p][i] = true;
            }
        }


        // people을 돌면서 party 확인
        for (int i = 0; i < num; i++) {
            if (!knowTrue[people[i]]) {
                dfs(people[i]);
            }
        }


        int cnt = 0;
        for (int i = 1; i <= M; i++)
            if (!visitParty[i]) cnt++;
        System.out.println(cnt);

    }

    static void dfs(int i) {
        knowTrue[i] = true;
        // i가 속해있는 파티를 확인
        for (int m = 1; m <= M; m++) {
            if (parties[i][m] && !visitParty[m]) {
                visitParty[m] = true;
                // m번째 파티에 속해있는 모든 파티원 확인
                for (int n = 1; n <= N; n++) {
                    if (parties[n][m] && !knowTrue[n]) {
                        knowTrue[n] = true;
                        dfs(n);
                    }
                }
            }
        }
    }
}