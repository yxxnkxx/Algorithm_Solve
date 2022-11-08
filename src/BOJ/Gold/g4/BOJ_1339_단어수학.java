    package BOJ.Gold.g4;

    import java.util.*;

    public class BOJ_1339_단어수학 {
        static class Word implements Comparable<Word> {

            String str;
            int length;

            int idx; // 앞글자부터

            int cnt;

            public Word(String str) {
                this.str = str;
                this.length = str.length();
                this.idx = 0;
            }

            public List<Integer> findCnt() {
                List<Integer> list = new ArrayList<>();
                char c = str.charAt(idx);
                for (int i = idx + 1; i < this.str.length(); i++) {
                    if (this.str.charAt(i) == c) list.add(i);
                }
                return list;

            }


            @Override
            public int compareTo(Word o) {
                // 길이가 같으면 알파벳이 중복되어 있을 경우 중복되는 자릿수가 더 높은 경우가 우위
                // BC AA -> A가 9를 가져가야 함
                if (o.length == this.length) {
                    List<Integer> list1 = this.findCnt();
                    List<Integer> list2 = o.findCnt();
                    int size1 = list1.size();
                    int size2 = list2.size();
                    if (size1 == 0 && size2 == 0) {
                        return 0; // 아무거나 상관x
                    } else if (size1 == 0)
                        return 1; //
                    else if (size2 == 0)
                        return -1;
                    else {
                        int idx = 0;
                        int min = Math.min(size1, size2);
                        while (idx < min) {
                            int val1 = list1.get(idx);
                            int val2 = list2.get(idx);
                            if (val1 != val2) {
                                return val2 - val1;
                            }
                            idx++;
                        }
                    }

                }


                return o.length - this.length;
            }

        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            Word[] arr = new Word[N];
            HashMap<Character, Integer> map = new HashMap<>();
            // map에 자릿수를 저장하기
            for (int i = 0; i < N; i++) {
                arr[i] = new Word((sc.next()));
                for (int j = 0; j < arr[i].length; j++) {
                    char c = arr[i].str.charAt(j);
                    int pos = 0;
                    if (map.containsKey(c)) {
                        pos = map.get(c);
                    }
                    pos += (Math.pow(10, arr[i].length - j));
                    map.put(c, pos);
                }
            }
            int num = 9;
            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((o1, o2) -> o2.getValue() - o1.getValue());
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i).getKey(), num--);
            }

            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                String str = arr[i].str;
                int pos = 1;
                int res = 0;
                for (int j = str.length() - 1; j >= 0; j--) {
                    int tmp = map.get(str.charAt(j));
                    res += tmp * pos;
                    pos *= 10;
                }
                nums[i] = res;
            }
            int ans = 0;
            for (int i = 0; i < N; i++)
                ans += nums[i];
            System.out.println(ans);
        }
    }
