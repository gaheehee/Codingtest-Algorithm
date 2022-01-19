# O(n^2) 정렬: 버블정렬 - 오름차순 정렬
'''
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
'''

# sort 함수 사용: 76ms
# sort 함수 사용 시 시간 더 짧음

import sys

n = int(sys.stdin.readline())
arr = []

for _ in range(n):
    arr.append(int(sys.stdin.readline()))

arr.sort()

for i in arr:
    print(i)


# sort 함수 미사용: 308ms

# n = int(input())
# arr = []

# for _ in range(n):
#     arr.append(int(input()))

# while n >= 1:
#     for i in range(0, n-1):
#         if arr[i] > arr[i+1]:
#             temp = arr[i]
#             arr[i] = arr[i+1]
#             arr[i+1] = temp
#     n -= 1

# for num in arr:
#     print(num)