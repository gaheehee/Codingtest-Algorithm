'''
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
'''

import sys

n = int(sys.stdin.readline())
arr = list(map(int, str(n)))

arr.sort(reverse=True)

for i in arr:
    print(i, end="")

# arr.sort(reverse=True): 내림차순 정렬
