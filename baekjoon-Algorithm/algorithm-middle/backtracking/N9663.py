# N-Queen
'''
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
'''

# depth 0부터 시작해서 재귀적으로 진행. (depth가 n이랑 같아지면 count)
# 배열의 주소값이 행, 요소값이 열
# 배열에 값을 넣고 공격할 수 없는 위치(True)라면 재귀(depth+1) 호출 

import sys

n = int(sys.stdin.readline())
queen = [0]*n
count = 0

def check(depth):
    for i in range(depth):
        if queen[depth] == queen[i] or abs(queen[depth] - queen[i]) == depth - i:
            return False
    return True

def dfs(depth):
    
    # 탐색 break 
    if depth == n:
        global count
        count += 1
        return

    for i in range(n):
        queen[depth] = i
        if check(depth):
            dfs(depth + 1)

dfs(0)
print(count)

# for i in range(0)은 포문이 돌지 않는다.
