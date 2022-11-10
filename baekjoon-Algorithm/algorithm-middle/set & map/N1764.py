d, b = map(int, input().split())
dlist = set(input() for _ in range(d))
blist = set(input() for _ in range(b))

dblist = sorted(list(dlist & blist))
print(len(dblist))
for i in dblist:
    print(i)

# 교집합: list(a & b) *a, b는 set임