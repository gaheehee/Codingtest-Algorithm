import sys

arr = []
sum = 0

for i in range(5):
    n = int(sys.stdin.readline().strip())
    sum += n
    arr.append(n)

arr.sort()

print(sum//5, arr[2], sep="\n")


# sys.stdin.readline().strip(): 개행 문자 제거
