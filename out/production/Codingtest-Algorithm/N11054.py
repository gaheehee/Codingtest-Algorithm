'''
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  
{1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
'''

import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
reverse_a = list(reversed(a))
# idx 0 left, 1 right, 2 sum
dp = [[1, 1] for _ in range(n)]
maxlen = 0

for i in range(1, n):
    # 처음 - 기준까지
    for j in range(0, i):
        if a[j] < a[i]:
            dp[i][0] = max(dp[i][0], dp[j][0] + 1)
    
    for j in range(0, i):
        if reverse_a[j] < reverse_a[i]:
            dp[i][1] = max(dp[i][1], dp[j][1] + 1)

for i in range(n):
    sumresult = dp[i][0] + dp[n-1-i][1]
    if sumresult > maxlen:
        maxlen = sumresult  

print(maxlen-1)