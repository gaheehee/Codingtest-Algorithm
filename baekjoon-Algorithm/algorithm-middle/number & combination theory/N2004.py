n, m = map(int, input().split())

def count_muliple(n, k):
    cnt = 0
    while n !=0 :
        n = n // k
        cnt += n
    return cnt

cnt2 = count_muliple(n, 2) - count_muliple(m, 2) - count_muliple(n-m, 2)
cnt5 = count_muliple(n, 5) - count_muliple(m, 5) - count_muliple(n-m, 5)

print(min(cnt2, cnt5))