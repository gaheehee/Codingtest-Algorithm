'''
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
'''
# 68ms

def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

n = int(input())
print(factorial(n))


# 68ms

# n = int(input())

# for i in range(n-1, 0, -1):
#     n *= i

# if n == 0:
#     print(1)
# else:
#     print(n)