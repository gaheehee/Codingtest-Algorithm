import sys
from itertools import permutations

input = sys.stdin.readline

N = int(input())
nlist = list(map(int, input().split()))
result = 0

per = permutations(nlist)

for p in per:
    s = 0
    for i in range(N - 1):
        s += abs(p[i] - p[i+1])

    result = max(result, s)

print(result)