import sys

input = sys.stdin.readline

T = int(input())

modA = T // 300
remainA = T % 300

modB = remainA // 60
remainB = remainA % 60

modC = remainB // 10
remainC = remainB % 10

if remainC != 0:
    print(-1)
else:
    print(modA, modB, modC, sep=" ")
