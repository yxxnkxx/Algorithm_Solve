# [Gold V] 합분해 - 2225 

[문제 링크](https://www.acmicpc.net/problem/2225) 

### 성능 요약

메모리: 13280 KB, 시간: 136 ms

### 분류

다이나믹 프로그래밍(dp), 수학(math)

### 문제 설명

<p>0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.</p>

<p>덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.</p>

### 입력 

 <p>첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.</p>

### 출력 

 <p>첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.</p>

---

dp는 항상 막막한데 점화식만 찾으면 쉽게 풀리는 것 같다



규칙이 있을까 해서 작은 경우의 수부터 하나하나 써봤는데 규칙을 찾을 수 있었다.



```
dp[N][K] = dp[N][K-1] + dp[N-1][K-1] + ... dp[0][K-1]
```

이런 식이 도출되는 이유는 다음과 같다.

문제에 있는 예시인 N=6, K=4일 때를 가정한다.

가능한 경우의 수를 오름차순으로 정렬하며 다음과 같을 것이다.

0 0 0 6

0 0 1 5

0 0 2 4

0 0 3 3

0 0 4 2

. . .

0 0 6 0

0으로 시작하는 경우 끝



1 0 0 5

1 0 1 4

1 0 2 3

1 0 3 2 

...

1 1 1 3

1 1 2 2 

...

1 5 0 0

1로 시작하는 경우 끝



맨 앞자리를 제외하고 뒤만 보면, N=6, K=3일 때의 경우, 맨 앞자리가 1일 때는 N=5, K=3일 때의 경우의 수와 같음을 알 수있다.

6 0 0 0까지 간다면 N=0, K=3일때의 경우의 수와 같다.



이를 토대로 위와 같은 점화식이 도출된 것이다.



dp[i][1]은 i를 1개의 숫자로 표현한 것이니까 모두 1이고, dp[0][k]는 0을 k개의 숫자로 표현한 것이어서 모두 1이다.

이렇게 dp의 초기값을 채우고 하나씩 채워나갔다.
