# 순열: n개에서 m개를 뽑는데 순서 상관있게 뽑음
'''
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
'''

import sys

n, m = map(int, sys.stdin.readline().split())
result = []

def backtracking(k):
    if k == m:
        for i in result:
            print(i, end=' ')
        print()
        return 
    
    for i in range(1, n+1):
        if i not in result:
            if len(result) != 0:
                if result[k-1] < i:
                    result.append(i)
                    backtracking(k + 1)
                    result.pop()
            else:
                result.append(i)
                backtracking(k + 1)
                result.pop()

backtracking(0)


# combinations 조합 이용

# import sys
# from itertools import combinations

# n, m = map(int, sys.stdin.readline().split())
# arr = []

# for i in range(1, n+1):
#     arr.append(i)

# result = list(combinations(arr, m))

# for i in result:
#     print(" ".join(map(str, i)))

