n, m = map(int, input().split())
a = set(map(int, input().split()))
b = set(map(int, input().split()))

asubb = a - b
bsuba = b - a
sum = asubb | bsuba
print(len(sum))

# 합집합: set.union(a, b) 또는 a | b