'''
45656이란 수를 보자.

이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

정답을 1,000,000,000으로 나눈 나머지를 출력한다.
'''

import sys

n = int(sys.stdin.readline())
dp = [[0]*10 for _ in range(n+1)]
dp[0] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]

for i in range(1, n):
    for j in range(0, 10):
        if j == 0:
            dp[i][j] = dp[i-1][j+1]
        elif j == 9:
            dp[i][j] = dp[i-1][j-1]
        else:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]

print(sum(dp[n-1]) % 1000000000)

# dp = [[0]*10] * n -> 이런식으로 이중배열 선언하면 에러남


# import sys

# n = int(sys.stdin.readline())
# arr = []

# if n >= 1:
#     arr.append(0)
#     arr.append(9)

# for i in range(2, n+1):
#     arr.append(((arr[i-1] *2) - (i-1)) % 1000000000)

# print(arr[n])