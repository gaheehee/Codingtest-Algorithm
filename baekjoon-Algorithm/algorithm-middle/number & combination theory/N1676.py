n = int(input())

def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n-1)

strr = str(factorial(n))
cnt = 0

for i in range(len(strr)):
    if strr[len(strr)-i-1] == '0':
        cnt += 1
        continue
    else:
        break

print(cnt)