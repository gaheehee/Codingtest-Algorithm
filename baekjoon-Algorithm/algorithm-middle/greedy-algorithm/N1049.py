import sys

input = sys.stdin.readline

N, M = map(int, input().split())

min6 = 1001
min1 = 1001

for _ in range(M):
    a, b = map(int, input().split())
    if a < min6:
        min6 = a
    if b < min1:
        min1 = b

n6 = N // 6
n1 = N % 6

result = min((n6 + 1) * min6, (n6 * min6) + (n1 * min1), N * min1)

print(result)
