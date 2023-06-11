import sys

N, K = map(int, sys.stdin.readline().split())
items = []

for _ in range(N):
    items.append(list(map(int, sys.stdin.readline().split())))

dp = [[0] * (K + 1) for _ in range(N)]

for i in range(N):
    w, v = items[i]
    for j in range(1, K+1):
        if j >= w:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)
        else:
            dp[i][j] = dp[i-1][j]

print(dp[N-1][K])