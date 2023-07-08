import sys
from collections import deque

input = sys.stdin.readline

Vn, En, start = map(int, input().split())
adjacent = [[] for _ in range(Vn + 1)]

for _ in range(En):
    a, b = map(int, input().split())
    adjacent[a].append(b)
    adjacent[b].append(a)

for v in adjacent:
    v.sort()

visited_d = [False] * (Vn+1)
visited_b = [False] * (Vn+1)




def DFS(v):

    visited_d[v] = True
    print(v, end=' ')

    for a in adjacent[v]:
        if not visited_d[a]:
            DFS(a)


def BFS(v):

    q = deque([v])
    visited_b[v] = True

    while q:
        v= q.popleft()
        print(v, end=" ")

        for a in adjacent[v]:
            if not visited_b[a]:
                visited_b[a] = True
                q.append(a)


DFS(start)
print()
BFS(start)