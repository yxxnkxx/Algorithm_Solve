# [Silver I] Z - 1074 

[문제 링크](https://www.acmicpc.net/problem/1074) 

### 성능 요약

메모리: 12912 KB, 시간: 112 ms

### 분류

분할 정복(divide_and_conquer), 재귀(recursion)

### 문제 설명

<p>한수는 크기가 2<sup>N</sup> × 2<sup>N</sup>인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.</p>

<p style="text-align:center"><img alt="" src="https://upload.acmicpc.net/21c73b56-5a91-43aa-b71f-9b74925c0adc/-/preview/" style="width: 100px; height: 99px;"></p>

<p>N > 1인 경우, 배열을 크기가 2<sup>N-1</sup> × 2<sup>N-1</sup>로 4등분 한 후에 재귀적으로 순서대로 방문한다.</p>

<p>다음 예는 2<sup>2</sup> × 2<sup>2</sup> 크기의 배열을 방문한 순서이다.</p>

<p style="text-align:center"><img alt="" src="https://upload.acmicpc.net/adc7cfae-e84d-4d5c-af8e-ee011f8fff8f/-/preview/" style="width: 250px; height: 252px;"></p>

<p>N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.</p>

<p>다음은 N=3일 때의 예이다.</p>

<p style="text-align:center"><img alt="" src="https://upload.acmicpc.net/d3e84bb7-9424-4764-ad3a-811e7fcbd53f/-/preview/" style="width: 533px; height: 535px;"></p>

### 입력 

 <p>첫째 줄에 정수 N, r, c가 주어진다.</p>

### 출력 

 <p>r행 c열을 몇 번째로 방문했는지 출력한다.</p>

---

분할 정복으로 풀면 되는 문제다. 처음에는 배열을 선언해서 cnt를 더하였는데, 이러면 입력의 크기가 커질 때 메모리가 부족하다.

그래서 배열을 선언하지 않고 cnt를 증가시키면서 하였는데, 1씩 증가하다 보니 시간초과가 난다.

배열 전체는 4등분이 가능하니까 r과 c가 위치한 사분면에 따라 위치하지 않은 사분면은 cnt가 배열의 크기만큼 증가한다.

이를 활용해서 함수를 구현하였다.
