import sys

n = int(sys.stdin.readline())
nlist = sorted(list(map(int, sys.stdin.readline().split())))
m = int(sys.stdin.readline())
mlist = list(map(int, sys.stdin.readline().split()))

ndict = {}

for i in nlist:
    if i in ndict:
        ndict[i] += 1
    else:
        ndict[i] = 1

def binary_search(array, target, start, end):
    
    while start <= end:
        mid = (start + end) // 2

        if array[mid] == target:
            return ndict[target]
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
        
    return 0

for t in mlist:
    print(binary_search(nlist, t, 0, n-1), end=" ")