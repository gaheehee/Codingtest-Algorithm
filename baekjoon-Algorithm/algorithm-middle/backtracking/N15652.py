'''
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
'''

import sys

n, m = map(int, sys.stdin.readline().split())
result = []

def backtracking(k):
    if k == m:
        print(' '.join(map(str, result)))
        return

    for i in range(1, n+1):
        if len(result) != 0:
            if result[k-1] <= i:
                result.append(i)
                backtracking(k + 1)
                result.pop()
        else:
            result.append(i)
            backtracking(k + 1)
            result.pop()

backtracking(0)