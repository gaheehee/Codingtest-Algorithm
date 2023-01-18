s = input()
q = int(input())

for _ in range(q):
    a, l, r = input().split()
    print(s[int(l):int(r)+1].count(a))