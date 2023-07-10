'''
N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 

연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.

우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.

예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 

주어진 연산자가 덧셈(+) 2개, 뺄셈(-) 1개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 60가지의 식을 만들 수 있다. 

예를 들어, 아래와 같은 식을 만들 수 있다.

N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
'''

import sys

n = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))
# 차례대로  +, -, *, //
ops = list(map(int, sys.stdin.readline().split()))
maxx, minn = - sys.maxsize, sys.maxsize


def dfs(depth, k, add, sub, mul, div):
    # 모든 수 탐색
    if depth == n:
        global maxx, minn
        maxx = max(maxx, k)
        minn = min(minn, k)
        return
    
    if add > 0:
        dfs(depth + 1, k + numbers[depth], add - 1, sub, mul, div)
    if sub > 0:
        dfs(depth + 1, k - numbers[depth], add, sub - 1, mul, div)
    if mul > 0:
        dfs(depth + 1, k * numbers[depth], add, sub, mul - 1, div)
    if div > 0:
        dfs(depth + 1, int(k / numbers[depth]), add, sub, mul, div - 1)


dfs(1, numbers[0], ops[0], ops[1], ops[2], ops[3])

print(maxx)
print(minn)