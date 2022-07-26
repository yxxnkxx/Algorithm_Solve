# [Gold II] K번째 수 - 1300 

[문제 링크](https://www.acmicpc.net/problem/1300) 

### 성능 요약

메모리: 12896 KB, 시간: 148 ms

### 분류

이분 탐색(binary_search), 매개 변수 탐색(parametric_search)

### 문제 설명

<p>세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.</p>

<p>배열 A와 B의 인덱스는 1부터 시작한다.</p>

### 입력 

 <p>첫째 줄에 배열의 크기 N이 주어진다. N은 10<sup>5</sup>보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(10<sup>9</sup>, N<sup>2</sup>)보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>B[k]를 출력한다.</p>

## 풀이

이분 탐색을 활용하는 문제다. 이분 탐색 개념에 대해서 대충은 알고 있었는데 이 문제에 활용할 생각은 못 했다.

https://www.acmicpc.net/blog/view/109

이 글과 다른 코드들을 참고해서 이분 탐색으로 문제를 풀었다.


핵심은 K보다 작은 수의 개수를 간단하게 구하는 방법이다.

1	2	3

2	4	6

3	6	9

위 같은 i*j의 배열이 있을 때, 4 이하인 수의 개수는

1행에서 1,2,3(3개), 2행에서 2,4(2개), 3행에서 3(1개)로 총 6개이다.

즉 각 행의 원소의 개수가 N인 i행에서 k보다 작은 수의 개수는 min(k/i, N)이다.

 

내가 풀이를 보면서 의문을 가졌던 점은 두 가지인데, 먼저 이분탐색을 반복하는 과정에서 mid는 right와 left의 중간값인데 이 값이 배열에 있다는 걸 어떻게 확인할 수 있는지다.

 

이것은 이분 탐색의 과정을 통해 확인할 수 있었다.

mid가 7이라면 7 이하인 수의 개수는 (1, 2, 3) (2, 4, 6) (3, 6)이 되어 8이 된다.

 

그리고 mid가 6일 때에도 똑같이 8이 된다.

 

즉 mid 이하인 수의 개수가 K일 때, mid-1 이하인 수의 개수도 K라면, mid는 배열에 존재하지 않는 수가 된다.

mid가 존재한다면 mid-1 이하의 수는 K보다 작은 수가 될 것이기 때문이다.

 

이를 활용해서 이분탐색을 반복한다면 cnt가 K인 수를 만나더라도, 그 중 가장 작은 수를 ans로 판단하기 때문에 정답을 찾을 수 있다.


그리고 right를 처음에 설정할 때 N*N으로 설정하였는데, right를 K로 설정해도 정답이 나온다.

이는 K번째 수가 K보다 작음이 보장되기 때문이다.

N과 K를 조정해가며 반복하다보면 이해할 수 있다.

 

이분 탐색에 대한 공부가 더 필요할 것 같다!
