# n = int(input())
# nlist = list(int(input()) for _ in range(n))
# nlist.sort()

# result = list()

# for i in range(2, min(nlist)+1):
#     compare = nlist[0] % i
#     flag = 1

#     for num in nlist:
#         k = num % i
#         if compare != k:
#             flag = 0
#             break
    
#     if flag == 1:
#         result.append(i)

# for num in result:
#     print(num, end=" ")


import math
n = int(input())
temp = []
result = []
gcd = 0

for i in range(n):
    temp.append(int(input()))
    if i == 1:
        gcd = abs(temp[1] - temp[0])
    gcd = math.gcd(abs(temp[i] - temp[i - 1]), gcd)

gcd_a = int(gcd ** 0.5)

for i in range(2, gcd_a + 1):
    if gcd % i == 0:
        result.append(i)
        result.append(gcd // i)

result.append(gcd)
result = list(set(result))
result.sort()

for i in result:
    print(i, end = ' ')