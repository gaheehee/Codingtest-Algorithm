t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    dp = [[0 for _ in range(0,m)] for _ in range(0,n)]
    
    for i in range(1, n+1):
        for j in range(1, m+1):
            if i == 1:
                dp[i-1][j-1] = j
            elif i <= j:
                dp[i-1][j-1] = dp[i-2][j-2] + dp[i-1][j-2]
    print(dp[n-1][m-1])