import sys

input = sys.stdin.readline

N = int(input())
nlist = list(map(int, input().split()))

dp = [1]

for i in range(1, len(nlist)):
    compare = nlist[i]
    imm = set([1])

    for j in range(i-1, -1,-1):
        if nlist[j] > compare:
            imm.add(1 + dp[j])

    dp.append(max(imm))


print(max(dp))