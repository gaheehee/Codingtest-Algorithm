n, k = map(int, input().split())
dp = []

# 1로 삼각형 생성
for i in range(n+1):
    dp.append([1]*(i+1))

for i in range(2, n+1):
    for j in range(1, i):
        dp[i][j] = dp[i-1][j-1] + dp[i-1][j]

print(dp[n][k] % 10007)
