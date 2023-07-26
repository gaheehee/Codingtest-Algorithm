import math

def merge_sort(arr, p, r):
    if p < r and count <= k:
        q = math.ceil((p+r) // 2)
        merge_sort(arr, p, q)
        merge_sort(arr, q+1, r)
        merge(arr, p, q, r)

def merge(arr, p, q, r):
    global count
    global result
    i = p
    j = q+1
    tmp = []

    while i <= q and j <= r:
        if arr[i] <= arr[j]:
            tmp.append(arr[i])
            i += 1
        else:
            tmp.append(arr[j])
            j += 1

    while i <= q:
        tmp.append(arr[i])
        i += 1
    
    while j <= r:
        tmp.append(arr[j])
        j += 1

    i = p
    t = 0

    while i <= r:
        arr[i] = tmp[t]
        count += 1
        if count == k:
            result = arr[i]
            break
        i += 1
        t += 1

n, k = map(int, input().split())
a = list(map(int, input().split()))
count = 0
result = -1
merge_sort(a, 0, n-1)
print(result)