'''
줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때, 
각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램을 작성하시오.
'''

import sys

n = int(sys.stdin.readline())
pi = list(map(int, sys.stdin.readline().split()))

pi.sort()
imm = 0
minvalue = 0

for i in pi:
    imm += i
    minvalue += imm

print(minvalue)