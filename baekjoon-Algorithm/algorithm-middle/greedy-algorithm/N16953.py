import sys
import heapq

input = sys.stdin.readline
a , b = map(int,input().split())

def mulTwo(a, count):
    return count+1, a*2

def addOne(a, count):
    return count+1, int(str(a)+"1")

def solution(a, b):
    q = [(0, a)]
    while q:
        cnt, a = heapq.heappop(q)
        if a<b:
            heapq.heappush(q, mulTwo(a, cnt))
            heapq.heappush(q, addOne(a, cnt))
        elif a==b:
            return cnt+1
        else:
            continue
    return -1

print(solution(a, b))