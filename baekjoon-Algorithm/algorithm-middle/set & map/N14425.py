n, m = map(int, input().split())
nset = [input() for _ in range(0, n)]
mset = [input() for _ in range(0, m)]
num = 0

for i in mset:
    if i in nset:
        num += 1

print(num)