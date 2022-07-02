import sys

n = int(input())
arr, arri = [], []
big_l, small_l = [], []

for i in range(6):
    a, b = map(int, input().split())
    arri.append(a)
    arr.append(b)

for i in range(1, 5):
    if arri.count(i) == 1:
        big_l.append(arr[arri.index(i)])
        temp = arri.index(i) + 3
        if temp >= 6:
            temp -= 6
        small_l.append(arr[temp])

print(n * (big_l[0]*big_l[1] - small_l[0]*small_l[1]))