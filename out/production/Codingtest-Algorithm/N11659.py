n, m = map(int, input().split())
nlist = list(map(int, input().split()))
prefix_sum = [0]    # init prefix_sum    
 
temp = 0    
for i in arr:    # accumulate arr section 
    temp += i
    prefix_sum.append(temp)
 
for i in range(m):
    a, b = map(int, input().split())
    print(prefix_sum[b] - prefix_sum[a-1])
