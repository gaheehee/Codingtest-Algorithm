'''
알고리즘 수업 - 피보나치 수 1
'''

import sys

fibNum = 0

def fib(n):
    global fibNum
    if n == 1 or n == 2:
        fibNum += 1
        return 1
    else:
        return fib(n-1) + fib(n-2)

def fibonacci(n):
    num = 0
    fList = [0]*(n+1)
    for i in range(3, n+1):
        num += 1
        fList[i] = fList[i-1] + fList[i-2]
    return num

num = int(sys.stdin.readline())
fib(num)
print(fibNum, fibonacci(num), sep = ' ')