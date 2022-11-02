import sys

total = int(sys.stdin.readline())
kindNum = int(sys.stdin.readline())

sum = 0
for i in range(kindNum):
    price, num = map(int, sys.stdin.readline().split())
    sum += (price * num)

if sum == total:
    print("Yes")
else:
    print("No")