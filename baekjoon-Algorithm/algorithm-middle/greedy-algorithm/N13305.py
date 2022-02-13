'''
각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아 
제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하시오.
'''

import sys

n = int(sys.stdin.readline())
road_lenth = list(map(int, sys.stdin.readline().split()))
price_per_liter = list(map(int, sys.stdin.readline().split()))
finalprice = 0
minprice = price_per_liter[0]

for i in range(n-1):
    if price_per_liter[i] <= minprice:
        minprice = price_per_liter[i]
        finalprice += (minprice * road_lenth[i])
    else:
        finalprice += (minprice * road_lenth[i])

print(finalprice)