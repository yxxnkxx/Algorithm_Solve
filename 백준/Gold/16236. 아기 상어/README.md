# [Gold III] 아기 상어 - 16236 

[문제 링크](https://www.acmicpc.net/problem/16236) 

### 성능 요약

메모리: 295204 KB, 시간: 664 ms

### 분류

너비 우선 탐색(bfs), 그래프 이론(graphs), 그래프 탐색(graph_traversal), 구현(implementation), 시뮬레이션(simulation)

### 문제 설명

<p>N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.</p>

<p>아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.</p>

<p>아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.</p>

<p>아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.</p>

<ul>
	<li>더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.</li>
	<li>먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.</li>
	<li>먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
	<ul>
		<li>거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.</li>
		<li>거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.</li>
	</ul>
	</li>
</ul>

<p>아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.</p>

<p>아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.</p>

<p>공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.</p>

<p>둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.</p>

<ul>
	<li>0: 빈 칸</li>
	<li>1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기</li>
	<li>9: 아기 상어의 위치</li>
</ul>

<p>아기 상어는 공간에 한 마리 있다.</p>

### 출력 

 <p>첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.</p>

---

### 풀이

구현할 것이 많은 문제였다.

상어가 이동할 때 고려해야 할 조건은 다음과 같다.

1.  자신의 크기보다 **먹이의 크기**가 작을 것
2.  먹이까지 **이동 가능**할 것 (자신의 크기보다 작거나 같은 곳만 지나갈 수 있다.)
3.  1, 2의 조건이 여러개라면 **위**에 있는 것(r이 작은 것), 같다면 **왼쪽**에 있는 것(c가 작은 것)부터 먹는다.
4.  1, 2, 3을 가능한 모든 먹이를 방문할 때까지 반복한다.

또 상어의 크기는 먹은 먹이의 수가 상어의 크기와 같아질 때 1씩 증가한다.

그러므로 한 번 먹이를 먹을 때마다 변화하는 **상어의 크기**와, **상어의 위치**에 따라 먹을 수 있는 먹이들을 구하고, 그 중 **가장 가깝고** **위와 왼쪽에 있는 먹이**로 이동해야 한다.

이를 위해 priority queue와 queue를 모두 사용하였다.

먼저 물고기 클래스와 상어 클래스를 선언하였다.

물고기 클래스는 거리-r-c 순으로 정렬하도록 하였다.

그리고 자신의 size보다 크기가 작은 물고기를 빠르게 찾기 위해 물고기의 list를 만들어 정렬했다.

---

isPossible 함수는 최단거리를 찾아야 하기 때문에 bfs를 활용하였다.

시작점인 sr, sc를 넣고 사방탐색을 통해 주변 값들을 방문하며 fr과 fc를 찾을 때까지 반복한다.

큐에 추가할 때는 이전 거리 (tmp\[2\])에 1을 더한 값을 넣어 거리를 저장하도록 하였다.

만약 큐에 들어있는 원소가 없을 때까지 fr과 fc를 찾지 못한다면 방문이 불가능한 경우니까 INF(Integer.MAX\_VALUE)를 return한다.

이후 pq에 넣을 때는 INF가 아닌 경우에만 pq에 넣는다.

pq를 활용한 이유는 거리가 가깝고 r이 작고, c가 작은 경우를 쉽게 걸러내기 위함이었다.

그렇게 하나씩 먹이의 위치로 이동한다.

---

여기서 주의할 점은 pq에서 하나를 뽑고 그 위치로 이동하면, 다시 pq에 있는 원소들을 없애고 이동한 위치에서 거리를 다시 계산해야 한다는 것이다.

또한 cnt를 1씩 증가시키고 크기와 같아지면 size를 1 증가하고, cnt를 초기화해야 한다.

놓치기 쉬운 부분은 **상어가 이동한 후 이전의 위치는 0으로 초기화**해야, 이동 가능 여부를 검사할 때 잘못된 값이 나오지 않는다.
