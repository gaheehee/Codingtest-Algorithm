import sys

n = int(sys.stdin.readline())
schedule = []
dp = [0 for _ in range(n+1)]

for _ in range(n):
    schedule.append(list(map(int, sys.stdin.readline().split())))

for i in range(n):
    for j in range(i + schedule[i][0], n + 1):
        dp[j] = max(dp[j], dp[i] + schedule[i][1])

print(dp[-1])