# O(nlogn) 정렬(sorting):  
'''
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
'''

import sys

def mergesort(arr):
    if len(arr) <= 1:
        return arr

    # devide
    mid = len(arr)//2
    left = mergesort(arr[ : mid])
    right = mergesort(arr[mid : ])

    # conquer
    sortlist = []
    i, j = 0, 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            sortlist.append(left[i])
            i += 1
        else:
            sortlist.append(right[j])
            j += 1
    
    if i != len(left):
        sortlist = sortlist + left[i : ]
    if j != len(right):
        sortlist = sortlist + right[j : ]

    return sortlist



n = int(sys.stdin.readline())
nlist = []

for _ in range(n):
    nlist.append(int(sys.stdin.readline()))

result = mergesort(nlist)
for n in result:
    print(n)


# sort 함수 사용

# import sys

# n = int(sys.stdin.readline())
# nlist = []

# for _ in range(n):
#     nlist.append(int(sys.stdin.readline()))

# nlist.sort()
# for n in nlist:
#     print(n)






