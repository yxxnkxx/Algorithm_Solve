class Solution {

    static int[] rate = {10, 20, 30, 40};
    static int e; // emoticon 길이
    static int n; // users 길이
    static int[] out; // 이모티콘의 할인율을 저장할 배열

    static int register; // 가입자수
    static int sum; // 판매액


    static public int[] solution(int[][] users, int[] emoticons) {


        // 이모티콘 개수만큼 완탐 4^n(emoticon), users를 돌면서 가입자수와 판매액 조사, 최대값 찾기
        e = emoticons.length;
        n = users.length;

        out = new int[e]; // 이모티콘 할인율
        perm(0, users, emoticons);


        return new int[]{register, sum};
    }

    static void perm(int idx, int[][] users, int[] emoticons) {
        if (idx == e) {
            cal(users, emoticons);
            return;
        }

        for (int i = 0; i < 4; i++) {
            out[idx] = rate[i];
            perm(idx + 1, users, emoticons);
        }
    }

    static void cal(int[][] users, int[] emoticons) {
        int tmpRegister = 0;
        int tmpSum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < e; j++) {
                // j번쨰 item을 구매하는지 안하는지
                if (users[i][0] <= out[j]) {
                    tmp += emoticons[j] * (100 - out[j]) / 100;
                }
            }
            if (tmp >= users[i][1]) {
                tmpRegister++;
            } else {
                tmpSum += tmp;
            }
        }

        // 우선순위 비교
        if (tmpRegister > register) {
            register = tmpRegister;
            sum = tmpSum;
        } else if (tmpRegister == register) {
            sum = Math.max(sum, tmpSum);
        }
    }

}