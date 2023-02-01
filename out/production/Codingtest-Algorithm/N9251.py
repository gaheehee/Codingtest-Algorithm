'''
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 
모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
'''

import sys

sequence1 = list(sys.stdin.readline().strip())
sequence2 = list(sys.stdin.readline().strip())
len1 = len(sequence1)
len2 = len(sequence2)
dp = [[0]*(len1+1) for _ in range(len2+1)]

for i in range(1, len2+1):
    for j in range(1, len1+1):
        if sequence1[j-1] == sequence2[i-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        

print(dp[len2][len1])


# .strip()를 넣으면 마지막 개행문자 없앨 수 있음