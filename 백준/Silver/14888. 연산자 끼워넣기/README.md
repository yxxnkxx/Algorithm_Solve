# [Silver I] 연산자 끼워넣기 - 14888 

[문제 링크](https://www.acmicpc.net/problem/14888) 

### 성능 요약

메모리: 13276 KB, 시간: 120 ms

### 분류

백트래킹(backtracking), 브루트포스 알고리즘(bruteforcing)

### 문제 설명

<p>N개의 수로 이루어진 수열 A<sub>1</sub>, A<sub>2</sub>, ..., A<sub>N</sub>이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.</p>

<p>우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.</p>

<p>예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 주어진 연산자가 덧셈(+) 2개, 뺄셈(-) 1개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 60가지의 식을 만들 수 있다. 예를 들어, 아래와 같은 식을 만들 수 있다.</p>

<ul>
	<li>1+2+3-4×5÷6</li>
	<li>1÷2+3+4-5×6</li>
	<li>1+2÷3×4-5+6</li>
	<li>1÷2×3-4+5+6</li>
</ul>

<p>식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.</p>

<ul>
	<li>1+2+3-4×5÷6 = 1</li>
	<li>1÷2+3+4-5×6 = 12</li>
	<li>1+2÷3×4-5+6 = 5</li>
	<li>1÷2×3-4+5+6 = 7</li>
</ul>

<p>N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 둘째 줄에는 A<sub>1</sub>, A<sub>2</sub>, ..., A<sub>N</sub>이 주어진다. (1 ≤ A<sub>i</sub> ≤ 100) 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다. </p>

### 출력 

 <p>첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다. 연산자를 어떻게 끼워넣어도 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다. 또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.</p>

---
### 풀이
전형적인 백트래킹 문제다.

연산자를 int 배열에 담고, 피연산자인 숫자도 배열에 담았다.

숫자의 개수는 N개, 연산자의 개수는 N-1개여서 nums[0]을 시작으로 dfs를 진행한다.

dfs는 깊이가 N-1개가 되었을 때, 즉 N-1개의 연산을 모두 마친 후에 max, min을 업데이트하고 함수를 return한다.

visited[i]는 0에서 시작해서 하나를 방문할 때마다 1씩 증가한다. 

해당 연산자를 아직 방문하지 않았다면 깊이를 1 증가시키고, 연산자의 계산결과를 num1로 하여 다시 dfs를 진행한다.

계산하는 함수는 switch문으로 정의하였다.


