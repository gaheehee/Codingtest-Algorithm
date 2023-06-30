import sys

input = sys.stdin.readline

N = int(input())

dp = []
dp.append(1)
dp.append(1)

for i in range(2, N):
    dp.append(dp[i-2] + dp[i-1])

print(dp[-1])