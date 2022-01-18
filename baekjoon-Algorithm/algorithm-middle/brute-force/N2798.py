'''
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 

블랙잭은 카지노마다 다양한 규정이 있다.

한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.

김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 

그런 후에 딜러는 숫자 M을 크게 외친다.

이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 

블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
'''

import sys

n, m = map(int, sys.stdin.readline().split())
numlist = list(map(int, sys.stdin.readline().split()))
nmax = 0

for i in range(0, n-2):
    n1 = numlist[i]
    for j in range(i+1, n-1):
        n2 = numlist[j]
        for k in range(j+1, n):
            n3 = numlist[k]
            nsum = n1 + n2 + n3
            if nsum <= m and nsum > nmax:
                nmax = nsum

print(nmax)



''' 
조합 라이브러리 사용
라이브러리 사용보다 위처럼 하는게 메모리나 시간 측면에서 더 적게 걸린다.
하지만 아래의 방법도 있다.
'''



# from itertools import combinations
# import sys

# n, m = map(int, sys.stdin.readline().split())
# numlist = list(map(int, sys.stdin.readline().split()))
# combilist = list(combinations(numlist, 3))
# nmax = 0

# for n1, n2, n3 in combilist:
#     nsum = n1 + n2 + n3
#     if nsum <= m and nmax < nsum:
#         nmax = nsum

# print(nmax)

# combinations(반복 가능한 객체, n): n=몇개를 뽑을 것인지, 순서 의미 X, 중복 X (import itertools 필요)