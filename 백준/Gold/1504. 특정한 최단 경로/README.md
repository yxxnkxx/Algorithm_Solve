# [Gold IV] 특정한 최단 경로 - 1504 

[문제 링크](https://www.acmicpc.net/problem/1504) 

### 성능 요약

메모리: 308324 KB, 시간: 1352 ms

### 분류

다익스트라(dijkstra), 그래프 이론(graphs)

### 문제 설명

<p>방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.</p>

<p>세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라. 1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000) 둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데, a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다. (1 ≤ c ≤ 1,000) 다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v<sub>1</sub>과 v<sub>2</sub>가 주어진다. (v<sub>1</sub> ≠ v<sub>2</sub>, v<sub>1</sub> ≠ N, v<sub>2</sub> ≠ 1) 임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재한다.</p>

### 출력 

 <p>첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 그러한 경로가 없을 때에는 -1을 출력한다.</p>

---

다익스트라를 사용하면 되고, v1과 v2를 반드시 거쳐야 하기 때문에
1. 1-v1-v2-N
2. 1-v2-v1-N
까지의 거리 중 작은 값을 찾으면 된다.

시작점이 1, v1, v2인 dijkstra를 총 3번 진행한다.

까다로웠던 점은 v1-v2를 바로 잇는 간선이 아니더라도 두 정점을 지나기만 하면 되기 때문에 두 정점을 잇는 간선의 길이가 아니라 dijkstra를 통해서 경로를 찾아야 한다.

그리고 도달 불가능한 경로인 것을 찾기 위해서 INF를 Long의 max value로 하면, 거리를 계산하는 과정에서 long의 범위를 벗어나서 올바른 값이 나오지 않는다.
최대 간선의 수가 200,000개, 거리의 최대 값이 1000이므로 INF는 200,000,000으로 설정하고, 경로가 INF 이상일 경우에 -1을 출력한다.

