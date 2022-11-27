package BOJ.Gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_17609_회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        out:
        while (T-- > 0) {
            String input = br.readLine();
            int l = 0;
            int r = input.length() - 1;
            while (l < r) {
                if (input.charAt(l) == input.charAt(r)) {
                    l++;
                    r--;
                } else {
                    // 왼쪽
                    int tmpl = l + 1;
                    int tmpr = r;
                    int tmp = 0;
                    while (tmpl < tmpr) {
                        if (input.charAt(tmpl) == input.charAt(tmpr)) {
                            tmpl++;
                            tmpr--;
                        } else {
                            tmp++;
                            break;
                        }
                    }
                    if (tmp == 0) {
                        // 1 가능
                        sb.append(1).append("\n");
                        continue out;
                    } else {
                        // 오른쪽

                        tmpl = l;
                        tmpr = r - 1;
                        tmp = 0;
                        while (tmpl < tmpr) {
                            if (input.charAt(tmpl) == input.charAt(tmpr)) {
                                tmpl++;
                                tmpr--;
                            } else {
                                tmp++;
                                break;
                            }
                        }
                        if (tmp == 0) {
                            // 1 가능
                            sb.append(1).append("\n");
                            continue out;
                        } else {
                            sb.append(2).append("\n");
                            continue out;
                        }
                    }
                }




            }  sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
