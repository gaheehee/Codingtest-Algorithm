'''
2차원 평면 위의 점 N개가 주어진다. 

좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
'''

import sys

n = int(sys.stdin.readline())
arr = []

for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    arr.append((b, a))

arr.sort()

for a, b in arr:
    print(b, a, sep=" ")