import sys

input = sys.stdin.readline


T = int(input())


for _ in range(T):
    N = int(input())
    gd = []
    cnt = 1

    for _ in range(N):
        gd.append(list(map(int, input().split())))

    gd.sort()
    top = gd[0][1]

    for s, m in gd:
        if m < top:
            cnt += 1
            top = m

    print(cnt)