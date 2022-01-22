# Counting sort(계수 정렬) - O(n+k) k는 배열 안의 최대값
# 수의 범위가 제한되어있고, 배열 안의 값들이 양수일 때 사용
'''
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
'''

import sys

n = int(sys.stdin.readline())
temp = [0]*10000

for _ in range(n):
    num = int(sys.stdin.readline())
    temp[num-1] += 1

k = 1
for i in temp:
    for _ in range(i):
        print(k)
    k += 1