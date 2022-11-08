import sys

n, m = map(int, sys.stdin.readline().split())
book = {}

for i in range(1,n+1):
    poketmon = sys.stdin.readline().rstrip()
    book[i] = poketmon
    book[poketmon] = i

for i in range(0,m):
    target = sys.stdin.readline().rstrip()

    if target.isdigit() == True:
        print(book[int(target)])
    else:
        print(book[target])



# item이 int인지: item.isdigit() == True
# 개행문자 제거: sys.stdin.readline().rstrip()