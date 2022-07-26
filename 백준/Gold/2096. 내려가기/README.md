# [Gold V] 내려가기 - 2096 

[문제 링크](https://www.acmicpc.net/problem/2096) 

### 성능 요약

메모리: 236080 KB, 시간: 1228 ms

### 분류

다이나믹 프로그래밍(dp), 슬라이딩 윈도우(sliding_window)

### 문제 설명

<p>N줄에 0 이상 9 이하의 숫자가 세 개씩 적혀 있다. 내려가기 게임을 하고 있는데, 이 게임은 첫 줄에서 시작해서 마지막 줄에서 끝나게 되는 놀이이다.</p>

<p>먼저 처음에 적혀 있는 세 개의 숫자 중에서 하나를 골라서 시작하게 된다. 그리고 다음 줄로 내려가는데, 다음 줄로 내려갈 때에는 다음과 같은 제약 조건이 있다. 바로 아래의 수로 넘어가거나, 아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다는 것이다. 이 제약 조건을 그림으로 나타내어 보면 다음과 같다.</p>

<p><img alt="" src="https://www.acmicpc.net/JudgeOnline/upload/201007/down.png" style="height:92px; width:685px"></p>

<p>별표는 현재 위치이고, 그 아랫 줄의 파란 동그라미는 원룡이가 다음 줄로 내려갈 수 있는 위치이며, 빨간 가위표는 원룡이가 내려갈 수 없는 위치가 된다. 숫자표가 주어져 있을 때, 얻을 수 있는 최대 점수, 최소 점수를 구하는 프로그램을 작성하시오. 점수는 원룡이가 위치한 곳의 수의 합이다.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 숫자가 세 개씩 주어진다. 숫자는 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 중의 하나가 된다.</p>

### 출력 

 <p>첫째 줄에 얻을 수 있는 최대 점수와 최소 점수를 띄어서 출력한다.</p>


---

### 풀이

메모리 초과를 유의해야하는 문제다.

dp[i][0] = max(dp[i-1][0], dp[i-1][1]) + val[i]

dp[i][1] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2]) + val[i]

dp[i][2] = max(dp[i-1][1], dp[i-1][2]) + val[i]

의 형식이기 때문에 N개의 데이터에 대해 모두 배열을 만들 필요가 없다.

최대값과 최소값을 구해야해서 dp[6][2]의 배열을 만들었다.

dp[0]~dp[2]는 최대값을, dp[3]~dp[5]는 최소값을 저장하였고, dp[n][0]에는 이전 값을 dp[n][1]에는 다음 값을 저장하고 한 줄을 검사할 때마다 dp[n][0]에 dp[n][1]의 값을 복사하여 계속했다.

마지막에 dp[n][1]의 최대 최소값을 출력하였더니 n이 1일 때 올바른 값이 나오지 않아 100%에서 틀리는 문제가 발생했다.

그래서 마지막까지 dp[n][0]에 값을 복사하고 dp[n][0]의 최대, 최소값을 찾아 출력하는 것으로 변경하였다.
