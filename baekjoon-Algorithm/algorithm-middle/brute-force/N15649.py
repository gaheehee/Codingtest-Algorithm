# 백트래킹: 해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 기법
'''
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
'''

import sys

n, m = map(int, sys.stdin.readline().split())
arr = []

def backtracking(depth):
    if depth == m:
        for k in arr:
            print(k, end=' ')
        print()
        return 

    for i in range(1, n+1):
        if i not in arr:
            arr.append(i)
            backtracking(depth + 1)
            arr.pop()
        
backtracking(0)




# # permutation 모듈 이용
# # 순열: n개에서 m개를 뽑는데 순서 상관있게 뽑음

# import sys
# from itertools import permutations

# n, m = map(int, sys.stdin.readline().split())
# arr = list(range(1, n+1))

# result = list(permutations(arr, m))

# #문자열로 변환 후 출력
# for i in result:
#     print(' '.join(map(str,i)))


# # 만약에 런타임 에러나면 문자열이나 인트로 바꾸어 출력해보기