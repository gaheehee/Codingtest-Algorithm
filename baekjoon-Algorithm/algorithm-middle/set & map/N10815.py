import sys

cn = int(sys.stdin.readline())
cards = sorted(list(map(int, sys.stdin.readline().split())))
n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))

def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if array[mid] == target:
            return 1
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    
    return 0


for i in nums:
    print(binary_search(cards, i, 0, cn-1), end = " ")