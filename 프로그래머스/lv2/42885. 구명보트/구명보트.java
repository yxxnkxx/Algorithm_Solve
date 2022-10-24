
class Solution {
    public int solution(int[] people, int limit) {
        int[] count = new int[241];
        for (int i=0; i<people.length; i++) {
            count[people[i]]++; // count 배열
        }


        int cnt = people.length;
        for (int c=240; c>=40; c--) {
            label: while (count[c]>0) {
                count[c]--;
                for (int j=40; j<=c; j++) {
                    if (count[j]>0 && c+j <= limit) {
                        count[j]--;
                        cnt--; // 전체 개수
                        continue label;
                    }
                }
            }
        }

        return cnt;
    }
}