'''import sys

n = int(sys.stdin.readline())
schedule = []
dp = [0 for _ in range(n+1)]

for _ in range(n):
    schedule.append(list(map(int, sys.stdin.readline().split())))

for i in range(n):
    for j in range(i + schedule[i][0], n + 1):
        dp[j] = max(dp[j], dp[i] + schedule[i][1])

print(dp[-1])
'''

# dp문제 중 top-down은 재귀이용한다

import sys

n = int(sys.stdin.readline())
schedule = []
dp = [0 for _ in range(n+1)]

for _ in range(n):
    schedule.append(list(map(int, sys.stdin.readline().split())))

for i in range(n-1, -1, -1):
    if i + schedule[i][0] > n:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i + 1], schedule[i][1] + dp[i + schedule[i][0]])

print(dp[0])