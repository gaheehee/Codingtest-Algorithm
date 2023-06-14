import sys

input = sys.stdin.readline

n = int(input())
nlist = list(map(int, input().split()))

dp = [1]

for i in range(1, n):
    d = []

    for j in range(i):
        if nlist[j] < nlist[i]:
            d.append(dp[j])

    if not d:
        dp.append(1)
    else:
        dp.append(max(d) + 1)


print(max(dp))