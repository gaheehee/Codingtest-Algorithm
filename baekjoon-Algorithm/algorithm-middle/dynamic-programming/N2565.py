'''
두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 
합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.

전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 
전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 
남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.
'''

import sys

n = int(sys.stdin.readline())
arr = []

for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))

arr.sort(key= lambda x: x[0])
dp = [1] * n

for i in range(1, n):
    for j in range(0, i):
        if arr[j][1] < arr[i][1]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n-max(dp))