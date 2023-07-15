import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
nlist = list(map(int, input().split()))

nlist.sort()
nlist = deque(nlist)
imm = [0] * N

flag = False
n, m = 0, 0
half = N // 2
result = 0

for i in range(half):
    if not flag:
        flag = True
        n = nlist.pop()
        m = nlist.popleft()
    else:
        flag = False
        n = nlist.popleft()
        m = nlist.pop()

    imm[half-1-i] = n
    imm[half+i] = m

for i in range(N-1):
    result += abs(imm[i] - imm[i+1])

print(result)