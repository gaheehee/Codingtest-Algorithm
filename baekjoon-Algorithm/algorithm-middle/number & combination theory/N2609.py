# 최대공약수와 최소공배수
'''
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
'''

import sys

temp = list(map(int, sys.stdin.readline().split()))
a = max(temp)
b = min(temp)

while b != 0:
    a = a % b
    a, b = b, a

# 최대공약수
print(a)

# 최소공배수
print((temp[0] * temp[1]) // a)


# Euclidean algorithm
# 유클리드 알고리즘 이용
# a와 b (a > b)가 있다고 할 때, a와 b의 최대공약수 G는 b와 a%b(a를 b로 나눈 나머지)의 최대공약수 G'과 서로 같다
