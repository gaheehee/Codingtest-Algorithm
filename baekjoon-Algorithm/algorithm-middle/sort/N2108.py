'''
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 
단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
'''

import sys
import collections

n = int(sys.stdin.readline())
arr = []

for _ in range(n):
    arr.append(int(sys.stdin.readline()))

arr.sort()

print(round(sum(arr)/n))
print(arr[n//2])

count = collections.Counter(arr).most_common(2)

if n > 1:
    if count[0][1] == count[1][1]:
        print(count[1][0])
    else:
        print(count[0][0])
else:
    print(arr[0])

print(max(arr) - min(arr))


# numpy.median(list): 중간값(numpy import 필요) *데이터가 짝수 개일 경우에는 가운데 두 값의 평균 리턴
# count = collections.Counter(arr).most_common(2): arr리스트에서 빈도 가장 높은거 2개 리턴 
# -> [(-2, 2), (-1, 2)] 이런 식으로 [(값, 빈도수)] 리턴