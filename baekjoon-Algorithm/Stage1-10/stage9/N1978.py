'''
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
'''
# 27sec

N = int(input())
numlist = list(map(int, input().split(' ')))
count = N

for num in numlist:
    if num == 1:
        count -= 1
    else:
        for n in range(2,num):
            if num%n == 0:
                count -= 1
                break

print(count)